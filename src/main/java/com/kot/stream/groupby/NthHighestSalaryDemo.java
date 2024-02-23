package com.kot.stream.groupby;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NthHighestSalaryDemo {

    public static void main(String[] args) {

        Map<String, Integer> map1 = new HashMap<>();
        map1.put("name1",1000);
        map1.put("name2",1100);
        map1.put("name3",1200);
        map1.put("name4",1300);
        map1.put("name5",1400);
        map1.put("name6",1500);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("name1",1000);
        map2.put("name2",1000);
        map2.put("name3",1200);
        map2.put("name4",1200);
        map2.put("name5",1200);
        map2.put("name6",1400);
        map2.put("name7",1400);
        map2.put("name8",1500);
        map2.put("name9",1600);

        map2.keySet().stream().forEach(System.out::println);

        List<String> collect = map2.entrySet().stream()
                .collect(Collectors.mapping(Map.Entry::getKey, Collectors.toList()));
        System.out.println(collect);

        System.out.println("=================");


        /*Map.Entry<String, Integer> result1 = getNthHighestSalary(4,map2);
        System.out.println(result1);*/

        /*Map.Entry<Integer, List<String>> result2 = getNthHighestSalary(3,map1);
        System.out.println(result2);*/

        Map.Entry<Integer, List<String>> result1 = getNthHighestSalary(4,map2);
        System.out.println(result1);

    }

    static Map.Entry<Integer, List<String>> getNthHighestSalary(int num, Map<String, Integer> map){
        return
                map.entrySet().stream()
                    .collect(Collectors.groupingBy(
                            Map.Entry::getValue,Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                    .entrySet().stream()
                    .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                    .collect(Collectors.toList())
                    .get(num-1);



    }

    /*static Map.Entry<String, Integer> getNthHighestSalary(int num, Map<String, Integer> map){
        return map.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toList())
                .get(num-1);
    }*/



}
