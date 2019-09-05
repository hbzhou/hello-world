package com.itsz.java.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * @author jeremy
 */
public class NIOClient {

    private SocketChannel socketChannel;

    private Selector selector;

    private Charset charset = Charset.forName("UTF-8");

    private  ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

    private ExecutorService threadPool = new ThreadPoolExecutor(
            Runtime.getRuntime().availableProcessors() + 1,
            Runtime.getRuntime().availableProcessors() * 2 + 1,
            1000,
            TimeUnit.NANOSECONDS,
            new LinkedBlockingQueue<>(),
            Executors.defaultThreadFactory()


    );

    public static void main(String[] args) throws IOException {
        NIOClient client = new NIOClient();
        client.startup();


    }

    public void startup() throws IOException {
        socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);

        selector = Selector.open();

        socketChannel.register(selector, SelectionKey.OP_CONNECT);

        socketChannel.connect(new InetSocketAddress("127.0.0.1", 8999));

        while (true) {
            selector.select();
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                iterator.remove();
                if (!selectionKey.isValid()) {
                    continue;
                }
                handleSelectKey(selectionKey);
            }

        }

    }

    private void handleSelectKey(SelectionKey selectionKey) throws IOException {
        if (selectionKey.isReadable()) {
            SocketChannel socketChannel = ((SocketChannel) selectionKey.channel());
            int read = socketChannel.read(byteBuffer);
            if (read > 0) {
                byteBuffer.flip();
                String receiveText = String.valueOf(charset.decode(byteBuffer));
                byteBuffer.clear();
                System.out.println(receiveText);
            }
        }
        if (selectionKey.isConnectable()) {
            SocketChannel socketChannel = ((SocketChannel) selectionKey.channel());
            if (socketChannel.isConnectionPending()) {
                socketChannel.finishConnect();
                System.out.println("连接成功");
                threadPool.submit(() -> {
                    while (true) {
                        Scanner scanner = new Scanner(System.in);
                        String content = scanner.nextLine();
                        if(content.length()>0){
                            socketChannel.write(charset.encode(content));
                        }
                    }
                });
                socketChannel.register(selector, SelectionKey.OP_READ);
            }

        }

    }


}
