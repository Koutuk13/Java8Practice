package com.kot.stream.misc;

import com.sun.xml.internal.fastinfoset.util.CharArray;
import com.sun.xml.internal.ws.util.StringUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FirstNonRepeatedCharacter {

//    find the first non-repeated character in it using Stream functions?
    public static void main(String[] args) {
        String input = "Java Hungry Blog Alive is Awesome";
        HashSet<Character> linkedHashSet = new LinkedHashSet<Character>();
        Stream<Character> characterStream = input.codePoints().mapToObj(c -> (char) c);
        characterStream.filter(c-> !linkedHashSet.add(c)).forEach(System.out::println);
        System.out.println("===============");
        linkedHashSet.stream().findFirst().ifPresent(character -> System.out.println(character));
        System.out.println("##############");

        Character character = input.chars()
                .mapToObj(ch -> Character.toLowerCase((char) ch))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst().get();
        System.out.println("First non-repeated character :: "+ character);
    }
}
