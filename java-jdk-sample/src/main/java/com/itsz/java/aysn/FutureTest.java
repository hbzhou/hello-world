package com.itsz.java.aysn;


import org.junit.Test;

import java.util.concurrent.*;

public class FutureTest {

    @Test
    public void testFuture() throws Exception {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                Runtime.getRuntime().availableProcessors() * 2,
                Runtime.getRuntime().availableProcessors() * 2 + 1,
                1000, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(1024));

        Future<String> future = threadPool.submit(() -> "future callback");

        Thread.sleep(100);

        String result = future.get();

        System.out.println(result);
    }


    @Test
    public void testCompletableFuture() {
        CompletableFuture.runAsync(() -> System.out.println("running in async"));
    }

    @Test
    public void testCompletableFuture01(){
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello World");
        String result = future.thenApply(s -> s.substring(1, 5)).getNow("hahah");
        System.out.println(result);
    }

    @Test
    public void testCompletableFuture02(){
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "what's your name?");
        future.thenAccept(System.out::println);
    }

    @Test
    public void testCompletableFuture03() throws ExecutionException, InterruptedException {
        CompletableFuture<Double> priceFuture = CompletableFuture.supplyAsync(() -> 0.22D);
        CompletableFuture<Double> discountFuture = CompletableFuture.supplyAsync(() -> 0.8);

        CompletableFuture<Double> resultFuture = priceFuture.thenCombine(discountFuture, (price, discount) -> price * discount);

        Double aDouble = resultFuture.get();

        System.out.println(aDouble);
    }


}
