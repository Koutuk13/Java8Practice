package com.kot.async;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class WhyNotFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<List<Integer>> submit = executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(10/0);
            //delay(1);
            return Arrays.asList(10, 20, 30);
        });

        List<Integer> integers = submit.get();
        System.out.println(integers);
        executorService.shutdown();
    }

    private static void delay(int min){
        try {
            TimeUnit.MINUTES.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ;
    }
}
