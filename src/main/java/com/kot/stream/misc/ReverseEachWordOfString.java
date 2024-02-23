package com.kot.stream.misc;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseEachWordOfString {

    //Reverse each word of a string using Java 8 streams?
    public static void main(String[] args) {
        String str = "Java Concept Of The Day";

        String collect = Stream.of(str.split(" "))
                        .map(string -> new StringBuffer(string).reverse())
                        .collect(Collectors.joining(" "));
        System.out.println(collect);

    }
}
