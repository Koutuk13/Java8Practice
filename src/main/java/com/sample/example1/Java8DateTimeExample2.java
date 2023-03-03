package com.sample.example1;

import java.sql.Date;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Java8DateTimeExample2 {

    public static void main(String[] args) {

     /*   LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyyMMdd");
        System.out.println("Formatted localDate : " + localDate.format(dateTimeFormatter1));

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyyMMddHH");
        DateTimeFormatter dateTimeFormatter3 = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        DateTimeFormatter dateTimeFormatter4 = DateTimeFormatter.ofPattern("yyyyMMdd");
        System.out.println("Formatted localDateTime with hour : " + localDateTime.format(dateTimeFormatter2));
        System.out.println("Formatted localDateTime with hour-minutes: " + localDateTime.format(dateTimeFormatter3));
        System.out.println("Formatted localDate : " + localDateTime.format(dateTimeFormatter4));

        System.out.println("Substring of localDateTime : " + Integer.parseInt(localDateTime.format(dateTimeFormatter3).substring(8)));

        System.out.println("======================================");

        String cobDate = "20220422";
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime2 = LocalDateTime.of(LocalDate.parse("20220422",DateTimeFormatter.ofPattern("yyyyMMdd")),LocalTime.now());
        System.out.println(localDateTime2);
        System.out.println("Formatted localDateTime with hour : " + localDateTime2.format(dateTimeFormatter2));
        System.out.println("Formatted localDateTime with hour-minutes: " + localDateTime2.format(dateTimeFormatter3));*/

        String startDate = "20220615";
        String endDate = "20220715";
        LocalDate startDate1 = LocalDate.parse(startDate,DateTimeFormatter.ofPattern("yyyMMdd"));
        LocalDate endDate1 = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("yyyMMdd"));
        while (startDate1.isBefore(endDate1)){
            System.out.println(startDate1);
            System.out.println(startDate1.format(DateTimeFormatter.ofPattern("yyyMMdd")));
            startDate1 = startDate1.plusDays(1);
            System.out.println("===========");
        }
        System.out.println("****************");

        String dateTimeStrm = DateTimeFormatter.ofPattern("uuuuMMddhhmmss").withZone(ZoneId.systemDefault()).format(Instant.now());
        System.out.println(dateTimeStrm);




    }
}
