package com.kot.stream.reduce;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReduceDemo {

    public static void main(String[] args) {
        IntStream range = IntStream.range(1, 5);
       // range.forEach(System.out::println);
        OptionalDouble average = range.average();
        double asDouble = average.getAsDouble();
        System.out.println(asDouble);
        System.out.println("=======================");
        IntStream range1 = IntStream.range(1, 5);
        OptionalInt reduce = range1.reduce((a, b) -> {
            return (a + b)/2;
        });
        System.out.println(reduce.getAsInt());
    }
}
