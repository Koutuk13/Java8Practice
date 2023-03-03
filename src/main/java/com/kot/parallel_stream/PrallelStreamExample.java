package com.kot.parallel_stream;

import java.util.List;
import java.util.stream.IntStream;

public class PrallelStreamExample {

    public static void main(String[] args) {
        long start=0;
        long end=0;
        long start1=0;
        long end1=0;

       /* start = System.currentTimeMillis();
        IntStream.range(1,10000).forEach(System.out::println);
        end = System.currentTimeMillis();
        System.out.println("Plain stream time :: "+ (end - start));

        System.out.println("============================================");
        start1 = System.currentTimeMillis();
        IntStream.range(1,10000).parallel().forEach(System.out::println);
        end1 = System.currentTimeMillis();
        System.out.println("Plain stream time :: "+ (end - start));
        System.out.println("Parallel stream time :: "+ (end1 - start1));*/

        System.out.println("============================================");

        IntStream.range(1,10).forEach(x->{
            System.out.println("Thread: "+ Thread.currentThread().getName() + " "+ x);
        });

        System.out.println("============================================");

        IntStream.range(1,10).parallel().forEach(x->{
            System.out.println("Parallel Thread: "+ Thread.currentThread().getName() + " " + x);
        });

        System.out.println("============================================");


        List<Employee> employeeList = EmployeeDAO.getEmployee();
        start = System.currentTimeMillis();
        double avg = employeeList
                        .stream().map(Employee::getSalary)
                        .mapToDouble(i -> i)
                        .average()
                        .getAsDouble();
        end = System.currentTimeMillis();
        System.out.println("Plain stream time :: "+ (end - start) + " :: " + avg);

        System.out.println("============================================");

        start1 = System.currentTimeMillis();
        double avgP = employeeList
                        .parallelStream().map(Employee::getSalary)
                        .mapToDouble(i -> i)
                        .average()
                        .getAsDouble();
        end1 = System.currentTimeMillis();
        System.out.println("Parallel stream time :: "+ (end1 - start1) + " :: " + avgP);
    }
}
