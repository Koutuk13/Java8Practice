package com.kot.async;

import com.kot.async.dto.Employee;
import com.kot.async.repository.EmployeeDAO;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException; 

public class SupplyAsyncDemo {

    public static List<Employee> fetchEmployee() throws ExecutionException, InterruptedException {
        CompletableFuture<List<Employee>> listCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Inside completable future :: "+ Thread.currentThread().getName());
            return EmployeeDAO.fetchEmployee();
        });
        return listCompletableFuture.get();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Employee> employees = SupplyAsyncDemo.fetchEmployee();
        System.out.println(employees.size());
    }
}
