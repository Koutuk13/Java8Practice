package com.kot.stream.misc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FindDuplicateInList {

    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
        HashSet<Integer> hSet = new HashSet();
        myList.stream().filter(l-> !hSet.add(l)).forEach(System.out::println);

    }
}
