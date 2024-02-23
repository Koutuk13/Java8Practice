package com.kot.stream.groupby;

import com.kot.stream.sort.Employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupByExample1 {

    public static void main(String[] args) {

        List<Employee> employeeList = Stream.of(
                new Employee(101, "FirstName", "Devops", 60000),
                new Employee(102, "SecondName", "Testing", 80000),
                new Employee(103, "ThirdName", "BA", 90000),
                new Employee(104, "FourthName", "Consulting", 40000),
                new Employee(105, "FifthName", "Procurement", 20000),
                new Employee(106, "Sixth", "Procurement", 30000),
                new Employee(107, "Seventh", "Consulting", 20000),
                new Employee(108, "Eight", "Consulting", 10000),
                new Employee(109, "Ninth", "BA", 85000)
        ).collect(Collectors.toList());


        Map<String, List<Employee>> collect = employeeList.stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment()));

        Map<String, List<Long>> collect1 = employeeList.stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.mapping(Employee::getSalary, Collectors.toList())
                ));

        Map<String, Map<String, Long>> collect4 = employeeList.stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment(),
                        Collectors.mapping(employee -> employee,
                                Collectors.toMap(Employee::getName, Employee::getSalary))
                ));


        System.out.println(collect);
        System.out.println(collect1);
        System.out.println(collect4);

        System.out.println("=============Solution 1====================");

        List<Map<String, Employee>> collect2 = collect.entrySet().stream()
                .map(entry -> {
                    Employee emp = entry.getValue().stream()
                            .sorted(Collections.reverseOrder(Comparator.comparing(Employee::getSalary)))
                            .collect(Collectors.toList()).get(0);
                    Map<String, Employee> newMap = new HashMap<>();
                    newMap.put(entry.getKey(), emp);
                    return newMap;
                }).collect(Collectors.toList());


        System.out.println(collect2);

        System.out.println("============Solution 2====================");


        Map<String, Employee> collect3 = collect.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> sortEmployeesBasedOnSalary(entry.getValue())
                ));
        System.out.println(collect3);

        System.out.println("=============Solution 3====================");

        Map<String, Employee> collect5 = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(
                                        Comparator.comparing(Employee::getSalary))
                                , Optional::get)));

        System.out.println(collect5);
    }

    private static Employee sortEmployeesBasedOnSalary(List<Employee> employeeList) {
        return employeeList.stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(Employee::getSalary)))
                .collect(Collectors.toList()).get(0);
    }

}
