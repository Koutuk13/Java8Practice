package com.sample.example1;

import java.util.*;

public class TwoSumExample2 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(20, 30, 50, 40, 10);
        Map<Integer,Integer> hm = new HashMap<>();
        int target = 70;

        for(int i = 0;i<numbers.size();i++){
            int sum = target - numbers.get(i);
            if(hm.containsKey(sum)){
                System.out.println("Pair is : "+ numbers.get(hm.get(sum)) + " , " + numbers.get(i));
            }else{
                hm.put(numbers.get(i),i);
            }
        }

    }
}

