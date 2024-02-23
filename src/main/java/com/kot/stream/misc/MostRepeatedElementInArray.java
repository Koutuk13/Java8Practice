package com.kot.stream.misc;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MostRepeatedElementInArray {

    //How do you find the most repeated element in an array?
    public static void main(String[] args) {
        List<String> listOfStrings = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Pen", "Note Book", "Pencil", "Pencil", "Pencil");

        /*String s = listOfStrings.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .map(Map.Entry::getKey)
                .findFirst().get();

        System.out.println("Most repeated element is :: "+ s);*/

        String s1 = listOfStrings.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .get();

        System.out.println("Most repeated element is :: "+ s1);

    }
}
