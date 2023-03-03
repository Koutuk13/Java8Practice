package com.sample.example1;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class EnumExample1 {

    public static void main(String[] args) {
        Vehicle[] vehicle = Vehicle.values();
        for (Vehicle v : vehicle) {
            System.out.println(v);
        }

        String collectVehicle = Arrays.stream(vehicle).map(Vehicle::toString).collect(Collectors.joining("|", "(", ")"));
        System.out.println(collectVehicle);
        Pattern pattern = Pattern.compile(collectVehicle);
        Matcher matcher = pattern.matcher("CAR");
        System.out.println(matcher.find());
       // System.out.println("TRUCK".equalsIgnoreCase(Vehicle.valueOf("TRUCK").toString()));
        System.out.println(Vehicle.valueOf("TRUCK"));
    }

    enum Vehicle {
        CAR, BIKE, BUS
    }
}