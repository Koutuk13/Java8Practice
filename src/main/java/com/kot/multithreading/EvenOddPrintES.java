package com.kot.multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class EvenOddPrintES {

    public static void main(String[] args) {

        ExecutorService es = Executors.newFixedThreadPool(2);

        IntStream intStream = IntStream.rangeClosed(1,10);

        intStream.forEach(i->{
            CompletableFuture evenCompletableFuture = CompletableFuture.completedFuture(i)
                    .thenApplyAsync(count-> {
                        if(count%2 ==0){
                            System.out.println(Thread.currentThread().getName() + " :: " + "Even number :: "+ count);
                        }
                        return count;
                    },es);
            evenCompletableFuture.join();

            CompletableFuture oddCompletableFuture = CompletableFuture.completedFuture(i)
                    .thenApplyAsync(count-> {
                        if(count%2 != 0){
                            System.out.println(Thread.currentThread().getName() + " :: " + "Odd number :: "+ count);
                        }
                        return count;
                    },es);
            oddCompletableFuture.join();
        });

        es.shutdown();
    }

}
