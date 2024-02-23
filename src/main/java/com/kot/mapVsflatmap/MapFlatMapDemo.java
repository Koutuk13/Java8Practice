package com.kot.mapVsflatmap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapFlatMapDemo {

    public static void main(String[] args) {
        List<Customer> customerList = Stream.of(
                    new Customer("101","FirstName", Arrays.asList(99450454,5758559)),
                    new Customer("102","SecondName", Arrays.asList(2342334,7987979)),
                    new Customer("103","ThirdName", Arrays.asList(3454354,798454)),
                    new Customer("104","FourthName", Arrays.asList(1223432,2432432))
                    ).collect(Collectors.toList());

        customerList.stream().map(customer -> customer.getId()).forEach(System.out::println);
        List<List<Integer>> collect = customerList.stream().map(customer -> customer.getPhoneNumber()).collect(Collectors.toList());
        System.out.println(collect);
        List<Integer> collect1 = customerList.stream().flatMap(customer -> customer.getPhoneNumber().stream()).collect(Collectors.toList());
        System.out.println(collect1);



    }
}
