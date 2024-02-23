package com.kot.stream.misc;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstRepeatedCharacter {

    public static void main(String[] args) {
        String input = "Java Hungry Blog Alive is Awesome";

        Character character = input.chars()
                .mapToObj(ch -> Character.toLowerCase((char) ch))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .findFirst().get();

        System.out.println("First repeated character is :: "+ character);

    }
}
