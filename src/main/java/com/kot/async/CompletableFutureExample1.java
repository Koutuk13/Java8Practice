package com.kot.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureExample1 {

    static CompletableFuture<String> waitAndReturn(long millis, String value, ExecutorService es) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(millis);
                System.out.println("CompletableFuture run by thread :: "+ Thread.currentThread().getName());
                return value;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },es);
    }

    public static void main(String[] args) {

        ExecutorService es = Executors.newFixedThreadPool(4);
        CompletableFuture<String> cf1 = waitAndReturn(0, "CompletableFuture1", es);
        CompletableFuture<String> cf2 = waitAndReturn(20000, "CompletableFuture2", es);
        CompletableFuture<String> cf3 = waitAndReturn(6000, "CompletableFuture3", es);

        es.shutdown();
        System.out.println("Execution not started yet");

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(cf1,cf2,cf3);

        System.out.println("Execution started");

        voidCompletableFuture.thenAcceptAsync((__)->{
            System.out.println("CompletableFuture run by thread :: " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
                System.out.println(cf1.join() + " , " + cf2.join() + " , " + cf3.join());
                System.out.println("ForkJoinPool executed");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        //.join();

        System.out.println("Execution completed");
    }
}
