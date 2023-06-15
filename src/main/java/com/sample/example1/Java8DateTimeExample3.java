package com.sample.example1;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Java8DateTimeExample3 {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.parse("2022-10-31");
        if(localDate.getDayOfWeek().equals(DayOfWeek.SATURDAY)){
            System.out.println("It is Saturday");
        }

        LocalDate localDate2 = LocalDate.parse("2022-10-31");
        LocalDate localDate3 = localDate2.minusDays(2);
        System.out.println(localDate3.toString());

        varargstest("1","2","3");
    }

    static void varargstest(String... param){
        String s1 = String.format("Hello ('%s') and ('%s') and ('%s')", param[0],param[1],param[2]);
        System.out.println(s1);
    }
}
