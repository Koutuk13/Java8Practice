package com.sample.example1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample1 {

    public static void main(String[] args) {

        List<String> listCountry = Arrays.asList("india", "japan", "singapore", "usa", "congo", "aus");

        listCountry.stream().filter(c -> c.length() > 3).map(c -> c.toUpperCase()).forEach(System.out::println);

        System.out.println("====================================");

        List<Integer> numbers = Arrays.asList(100, 500, 600, 200, 400, 800);
        System.out.println(numbers.stream().reduce(400, (a, b) -> a + b));

        System.out.println("====================================");

        List<Integer> testNumbers = Arrays.asList(5, 7, 11, 13);
        List<Integer> subTestNo = testNumbers.subList(0, 2);
        subTestNo.stream().forEach(System.out::println);
        System.out.println("-----");
        testNumbers.stream().forEach(System.out::println);

        System.out.println("====================================");
    }
}
