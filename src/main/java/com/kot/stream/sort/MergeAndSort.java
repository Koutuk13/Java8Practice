package com.kot.stream.sort;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeAndSort {
//Sort employee by name and salary using java 8 stream API
    public static void main(String[] args) {
        List<Employee> employeeList1 = Stream.of(
                                new Employee(101, "FirstName", "Devops", 60000),
                                new Employee(102, "SecondName", "Testing", 80000)
                                ).collect(Collectors.toList());

        List<Employee> employeeList2 = Stream.of(
                new Employee(103, "ThirdName", "BA", 90000),
                new Employee(104, "FirstName", "Consulting", 40000),
                new Employee(105, "FifthName", "Procurement", 20000)
        ).collect(Collectors.toList());

        Stream<Employee> mergedStream1 = Stream.concat(employeeList1.stream(), employeeList2.stream());
        System.out.println("**** The sorted collection is ****");
        mergedStream1.sorted(Comparator.comparing(Employee::getSalary)).forEach(System.out::println);
        /*
        System.out.println("**** The sorted collection in reverse order is ****");
        mergedStream.sorted(Collections.reverseOrder(Comparator.comparing(Employee::getSalary)))
                .forEach(System.out::println);
        */

        System.out.println("**** The sorted collection by name and salary is ****");
        Stream<Employee> mergedStream2 = Stream.concat(employeeList1.stream(), employeeList2.stream());
        mergedStream2.sorted(Comparator.comparing(Employee::getName)
                .thenComparing(Employee::getSalary))
                .forEach(System.out::println);



    }
}
