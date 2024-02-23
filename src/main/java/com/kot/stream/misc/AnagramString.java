package com.kot.stream.misc;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AnagramString {
    //program to check if two strings are anagrams or not?
    public static void main(String[] args) {
        String s1 = "RaceCar";
        String s2 = "CarRace";

        String[] split = s1.split("");
        System.out.println("length is :" + split.length);

        String collect1 = Stream.of(s1.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
        String collect2 = Stream.of(s2.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());

        if(collect1.equals(collect2)){
            System.out.println("It is anagram");
        }else{
            System.out.println("It is not anagram");
        }
    }
}
