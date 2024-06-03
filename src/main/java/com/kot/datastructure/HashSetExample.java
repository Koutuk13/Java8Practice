package com.kot.datastructure;

import java.util.HashSet;
import java.util.Objects;

public class HashSetExample {

    private String name;
    private int age;

    public HashSetExample(String name, int age){
        this.age = age;
        this.name = name;
    }

    public int hashCode(){
        return this.age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashSetExample that = (HashSetExample) o;
        return age == that.age && Objects.equals(name, that.name);
    }

    public static void main(String[] args) {
        HashSetExample obj1 = new HashSetExample("Name1", 30);
        HashSetExample obj2 = new HashSetExample("Name1", 30);

        HashSet<HashSetExample> h = new HashSet<>();
        h.add(obj1);
        h.add(obj2);
        //if equals method is not overriden - 2 entries in hashset
        //if equals method is overriden - 1 entry in hashset
        h.stream().forEach(System.out::println);
    }
}
