package com.kot.async;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kot.async.dto.Employee;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.*;

public class RunAsyncDemo {

    private static Void saveEmployees(File file) throws ExecutionException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            try {
                System.out.println("Current thread running is :: " + Thread.currentThread().getName());
                List<Employee> employees = objectMapper.readValue(file, new TypeReference<List<Employee>>() {
                });
                System.out.println("Employee list count is :: " + employees.size());
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
        return voidCompletableFuture.get();
    }

    private static Void saveEmployeesExecutor(File file) throws ExecutionException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();
        Executor executor = Executors.newCachedThreadPool();

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            try {
                System.out.println("Current thread running is :: " + Thread.currentThread().getName());
                List<Employee> employees = objectMapper.readValue(file, new TypeReference<List<Employee>>() {
                });
                System.out.println("Employee list count is :: " + employees.size());
            } catch (IOException e) {
                e.printStackTrace();
            }

        },executor);
        return voidCompletableFuture.get();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        RunAsyncDemo.saveEmployees(new File("employees.json"));
        RunAsyncDemo.saveEmployeesExecutor(new File("employees.json"));
    }
}
