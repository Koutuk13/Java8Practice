package com.sample.example1;

import java.sql.Timestamp;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Java8DateTimeExample4 {

    public static void main(String[] args) {
        Timestamp dateTime1 = Timestamp.valueOf("2023-03-29 14:13:58.574000000");
        System.out.println("Timestamp value is: "+ dateTime1);
        OffsetDateTime offsetDateTime = dateTime1.toInstant().atOffset(ZoneOffset.UTC);
        System.out.println("OffsetDateTime value is: "+ offsetDateTime);
        System.out.println("===============================");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDateTime.parse("2023-04-04T10:30:08", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")), ZoneId.of("Europe/London"));
        System.out.println("ZonedDateTime value is: "+ zonedDateTime);
        OffsetDateTime offsetDateTime1 = zonedDateTime.toOffsetDateTime();
        System.out.println("OffsetDateTime value is: "+ offsetDateTime1);

        System.out.println(zonedDateTime.withZoneSameInstant(ZoneId.of("Europe/London")));
        String format = zonedDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
        System.out.println("format is: "+ format);
    }
}
