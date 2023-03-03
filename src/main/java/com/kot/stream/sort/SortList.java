package com.kot.stream.sort;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortList {

    public static void main(String[] args) {

        List<Employee> employeeList = Stream.of(
                new Employee(101, "FirstName", "Devops", 60000),
                new Employee(102, "SecondName", "Testing", 80000),
                new Employee(103, "ThirdName", "BA", 90000),
                new Employee(104, "FourthName", "Consulting", 40000),
                new Employee(105, "FifthName", "Procurement", 20000)
                ).collect(Collectors.toList());

        employeeList.stream().sorted(Comparator.comparing(Employee::getId).reversed()).forEach(System.out::println);
        System.out.println("===================================");
        employeeList.stream().sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println);
        System.out.println("===================================");
        Collections.sort(employeeList, (e1, e2) -> e1.getName().compareTo(e2.getName()));
        System.out.println(employeeList);
    }
}
