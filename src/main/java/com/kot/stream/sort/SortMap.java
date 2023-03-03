package com.kot.stream.sort;

import java.util.*;

public class SortMap {

    public static void main(String[] args) {

        Map<Employee,Integer> employeeMap = new TreeMap<>((o1, o2) -> (int) (o1.getSalary()-o2.getSalary()));
        employeeMap.put(new Employee(101, "FirstName", "Devops", 60000),60);
        employeeMap.put(new Employee(102, "SecondName", "Testing", 80000),90);
        employeeMap.put(new Employee(103, "ThirdName", "BA", 90000),50);
        employeeMap.put(new Employee(104, "FourthName", "Consulting", 40000),40);
        employeeMap.put(new Employee(105, "FifthName", "Procurement", 20000),120);

        System.out.println(employeeMap);
        System.out.println("******************************");
        List<Map.Entry<Employee,Integer>> employeeList = new ArrayList<>(employeeMap.entrySet());
        employeeMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getName)))
                .forEach(System.out::println);
        System.out.println("******************************");
        employeeMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(System.out::println);

    }
}
