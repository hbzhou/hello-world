package com.itsz.java.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author jeremy
 */
public class NIOServer {

    private ServerSocketChannel serverSocketChannel;

    private Selector selector;

    private Charset charset = Charset.forName("UTF-8");

    private ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

    private Map<SocketChannel,String> clientMap = new ConcurrentHashMap<>();


    public static void main(String[] args) {

        try {
            NIOServer server = new NIOServer();
            server.startup();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startup() throws IOException {
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(8999));

        selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("server is listening now");

        while (true) {
            int selectNum = selector.select();
            if (selectNum > 0) {
                continue;
            }
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                iterator.remove();
                if (!selectionKey.isValid()) {
                    continue;
                }
                handleSelectKey(serverSocketChannel, selectionKey);
            }
        }
    }

    private void handleSelectKey(ServerSocketChannel serverSocket, SelectionKey sk) throws IOException {
        if (sk.isAcceptable()) {
            SocketChannel socketChannel = serverSocket.accept();
            socketChannel.configureBlocking(false);
            socketChannel.register(selector, SelectionKey.OP_READ);
            sk.interestOps(SelectionKey.OP_ACCEPT);
            System.out.println("sever is listening from " + socketChannel.getRemoteAddress());
            String clientName = getClientName(socketChannel);
            String info = String.format("Welcome %s to chatRoom", clientName);
            if(!clientMap.isEmpty()){
                clientMap.forEach((channel,name)->{
                    try {
                        channel.write(charset.encode(info));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
            clientMap.put( socketChannel,clientName);
        }

        if (sk.isReadable()) {
            SocketChannel socketChannel = ((SocketChannel) sk.channel());
            int read = socketChannel.read(byteBuffer);
            if (read > 0) {
                byteBuffer.flip();
                String receiveText = String.valueOf(charset.decode(byteBuffer));
                System.out.println(socketChannel.toString() + ":" + receiveText);
                dispatchMessage(clientMap.get(socketChannel),receiveText);
                byteBuffer.clear();
            }
        }
    }

    private void dispatchMessage(String clientName, String message) {
        if (!clientMap.isEmpty()) {
            clientMap.forEach(((tmpChannel,name) -> {
                try {
                    if (!name.equals(clientName)) {
                        tmpChannel.write(charset.encode(clientName+":"+message));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }));
        }
    }

    private String getClientName(SocketChannel client) {
        Socket socket = client.socket();
        return "[" + socket.getInetAddress().toString().substring(1) + ":" + Integer.toHexString(client.hashCode()) + "]";
    }

}
