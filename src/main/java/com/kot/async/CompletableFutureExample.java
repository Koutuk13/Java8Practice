package com.kot.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class CompletableFutureExample {

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

    static CompletableFuture waitAndThrow(long millis, ExecutorService es) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(millis);
                System.out.println("CompletableFuture run by thread :: "+ Thread.currentThread().getName());
            } finally {
                throw new RuntimeException("Exception in completablefuture 4");
            }
        },es);
    }


    public static void main(String[] args) {

        ExecutorService es = Executors.newFixedThreadPool(4);
        CompletableFuture<String> cf1 = waitAndReturn(1000, "CompletableFuture1", es);
        CompletableFuture<String> cf2 = waitAndReturn(20000, "CompletableFuture2", es);
        CompletableFuture<String> cf3 = waitAndReturn(6000, "CompletableFuture3", es);
        CompletableFuture<String> cf4 = waitAndThrow(8000, es);

        es.shutdown();
        System.out.println("Execution not started yet");

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(cf1,cf2,cf3,cf4);

        System.out.println("Execution started");

        //voidCompletableFuture.join();
        CompletableFuture<String> result = voidCompletableFuture.thenApplyAsync((__) -> {
            System.out.println("CompletableFuture run by thread :: " + Thread.currentThread().getName());
            //System.out.println(cf1.join() + " , " + cf2.join() + " , " + cf3.join());
            String re= cf1.join() + " , " + cf2.join() + " , " + cf3.join() + " , " + cf4.join();
            return re;
        }).exceptionally(err -> {
            //System.out.println("CompletableFuture run by thread :: " + Thread.currentThread().getName());
            System.out.println("oops, there was a problem! " + err.getMessage());
            return "names not found!";
        });
        String ans = result.join();
        System.out.println(ans);
        System.out.println("Execution completed");
    }
}



