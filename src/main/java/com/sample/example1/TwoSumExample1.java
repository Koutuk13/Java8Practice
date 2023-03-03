package com.sample.example1;

import java.util.Arrays;
import java.util.List;

public class TwoSumExample1 {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(20,30,50,40,10);
        //List<Integer> numbers = Arrays.asList(10,20,30,40,50);
        int target = 70;
        int first=0,last=numbers.size()-1;
        int currentSum=0;
        while(first<last) {
            currentSum = numbers.get(first)+numbers.get(last);
            if(currentSum==target) {
                System.out.println("Pair: "+first+" "+last);
                last--;
            }else if(currentSum < target) {
                first++;
            }else {
                last--;
            }
        }

    }
}
