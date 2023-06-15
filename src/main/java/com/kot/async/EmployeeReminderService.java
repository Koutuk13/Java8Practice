package com.kot.async;

import com.kot.async.repository.EmployeeDAO;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class EmployeeReminderService {

    /*
        Executed by single worker thread from  ForkJoinPool.commonPool
        because we are using thenApply, thenAccept
     */
    private static void sendReminderToEmployee() throws ExecutionException, InterruptedException {
        CompletableFuture.supplyAsync(() -> {
            System.out.println("Inside completable future 1 :: "+ Thread.currentThread().getName());
            return EmployeeDAO.fetchEmployee();
        }).thenApply(empList->{
            System.out.println("Inside completable future 2 :: "+ Thread.currentThread().getName());
            return empList.stream().filter(employee -> "TRUE".equals(employee.getNewJoiner())).collect(Collectors.toList());
        }).thenApply(empList-> {
            System.out.println("Inside completable future 3 :: " + Thread.currentThread().getName());
            return empList.stream().filter(employee -> "TRUE".equals(employee.getLearningPending())).collect(Collectors.toList());
        }).thenApply(empList->{
            System.out.println("Inside completable future 4 :: " + Thread.currentThread().getName());
            return empList.stream().map(emp-> emp.getEmail()).collect(Collectors.toList());
        }).thenAccept(emailIdList->{
            System.out.println("Inside completable future 5 :: " + Thread.currentThread().getName());
            emailIdList.forEach(EmployeeReminderService::sendEmail);
        }).get();
    }

    /*
        Executed by different thread from Fixed thread pool
        because we are using thenApplyAsync, thenAcceptAsync
     */
    private static void sendReminderToEmployeeAsync() throws ExecutionException, InterruptedException {
        Executor executor = Executors.newFixedThreadPool(5);
        CompletableFuture.supplyAsync(() -> {
            System.out.println("Inside completable future 1 :: "+ Thread.currentThread().getName());
            return EmployeeDAO.fetchEmployee();
        },executor).thenApplyAsync(empList->{
            System.out.println("Inside completable future 2 :: "+ Thread.currentThread().getName());
            return empList.stream().filter(employee -> "TRUE".equals(employee.getNewJoiner())).collect(Collectors.toList());
        },executor).thenApplyAsync(empList-> {
            System.out.println("Inside completable future 3 :: " + Thread.currentThread().getName());
            return empList.stream().filter(employee -> "TRUE".equals(employee.getLearningPending())).collect(Collectors.toList());
        },executor).thenApplyAsync(empList->{
            System.out.println("Inside completable future 4 :: " + Thread.currentThread().getName());
            return empList.stream().map(emp-> emp.getEmail()).collect(Collectors.toList());
        },executor).thenAcceptAsync(emailIdList->{
            System.out.println("Inside completable future 5 :: " + Thread.currentThread().getName());
            emailIdList.forEach(EmployeeReminderService::sendEmail);
        }).get();
    }

    private static void sendEmail(String emailId){
        System.out.println("Sending training reminder email to email-id :: " + emailId);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        sendReminderToEmployee();
        //sendReminderToEmployeeAsync();
        System.out.println("End of main method :: "+ Thread.currentThread().getName());
    }
}
