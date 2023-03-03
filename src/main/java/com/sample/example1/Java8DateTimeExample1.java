package com.sample.example1;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Java8DateTimeExample1 {

    public static void main(String[] args) {

        Date date1 = new Date();
        System.out.println("Java Util Date :: "+ date1);

        LocalDate date2 = LocalDate.now();
        System.out.println("Java8 Local Date :: "+ date2);

        LocalDate date3 = LocalDate.now(ZoneId.systemDefault());
        System.out.println("Java8 Local Date in default zone :: "+ date3);

        LocalDateTime date4 = LocalDateTime.now();
        System.out.println("Java8 Local DateTime in default zone :: "+ date4);

        ZonedDateTime date5 = ZonedDateTime.now();
        System.out.println("Java8 Zoned Date Time in default zone :: "+ date5);

        Instant date6 = Instant.now();
        System.out.println("Java8 Instant in :: "+ date6);

        Instant date7 = Instant.now();
        System.out.println("Java8 Instant in :: "+ date7);

        System.out.println("===========");
        System.out.println(LocalDate.now().minusDays(30).atStartOfDay(ZoneId.systemDefault()));

        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY,0);
        c.set(Calendar.MINUTE,0);
        c.set(Calendar.SECOND,0);
        c.set(Calendar.MILLISECOND,0);
        c.add(Calendar.DAY_OF_MONTH,-30);

        System.out.println(c.getTime());
        System.out.println(LocalDateTime.ofInstant(c.getTime().toInstant(),ZoneId.systemDefault()));
        System.out.println("===========");
        System.out.println(ZonedDateTime.ofInstant(c.toInstant(),ZoneId.systemDefault()));

       // System.out.println(LocalDate.ofInstant(Instant.ofEpochMilli(Long.parseLong("1628101800000")),ZoneId.systemDefault()));
        //1628015400000 = 2021-08-04
        //1628101800000 = 2021-08-05
        //1633285800000 = 2021-10-04

        //1621535400000 = 2021-05-21
        //1624213800000 = 2021-06-21
        //1626805800000 = 2021-07-21
        //1629484200000 = 2021-08-21
        //1632162600000 = 2021-09-21
        //1634754600000 = 2021-10-21
        //1637433000000 = 2021-11-21
        //1640025000000 = 2021-12-21
        //1642703400000 = 2022-01-21
        //1645381800000 = 2022-02-21
        //1647801000000 = 2022-03-21
        //1650479400000 = 2022-04-21
        //1653071400000 = 2022-05-21

        LocalDate localDate = LocalDate.now();
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
        System.out.println("Formatted localDateTime with hour-minutes: " + localDateTime2.format(dateTimeFormatter3));

        System.out.println("======================================");

        String dateTime = ZonedDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_INSTANT);
        System.out.println(dateTime);
        //ofPattern("yyyy-MM-ddThh:mm:ssZ")
        String dateTime1 = ZonedDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"));
        System.out.println(dateTime1);

        System.out.println("======================================");

        String timestamp = "2023-02-28T03:58:15";
        String expected = "2023-02-28 15:58:15";


        LocalDateTime localDateTime_44 = LocalDateTime.parse(timestamp,DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
        String exp = localDateTime_44.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(exp);
    }
}
