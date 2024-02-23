package com.sample.example1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreamExample3 {

    public static void main(String[] args) {
        Map<String,Integer> testMap = new HashMap<>();
        testMap.put("abc",1);
        testMap.put("def",2);
        testMap.put("ghi",3);
        testMap.put("jkl",4);

        List<String> listTest = Arrays.asList("def","jkl");
        testMap.keySet().stream().forEach(key->System.out.println(key));
        System.out.println("========================");
        testMap.keySet().retainAll(listTest);
        System.out.println("After retainAll");
        testMap.keySet().stream().forEach(key->System.out.println(key));
        System.out.println("========================");
        testMap.forEach((k,v)-> System.out.println("key is : "+ k + " ::: value is : "+ v));


    }
}
