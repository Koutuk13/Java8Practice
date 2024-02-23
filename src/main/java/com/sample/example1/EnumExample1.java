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
        Matcher matcher = pattern.matcher(Vehicle.CAR.value);
        System.out.println(matcher.find());
        System.out.println(Vehicle.valueOf("CAR"));
       // System.out.println("TRUCK".equalsIgnoreCase(Vehicle.valueOf("TRUCK").toString()));
        Matcher matcher1 = pattern.matcher("TRUCK");
        System.out.println(matcher1.find());
        System.out.println(Vehicle.valueOf("TRUCK"));
    }

    enum Vehicle {
        CAR("cars"), BIKE("bikes"), BUS("buses");

        private final String value;

        Vehicle(String vehicle) {
            this.value = vehicle;
        }
        @Override
        public String toString() {
            return value;
        }
    }
}