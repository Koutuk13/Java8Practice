package com.kot.stream.misc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicateInList {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,2,3,4,1,2,3);
        integerList.stream().collect(Collectors.toSet()).stream().forEach(System.out::println);
      //  integerList.stream().distinct().forEach(System.out::println);
    }
}
