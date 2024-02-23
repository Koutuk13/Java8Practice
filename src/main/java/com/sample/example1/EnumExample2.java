package com.sample.example1;

public class EnumExample2 {

    public static void main(String[] args) {
        SingletonEnum singleton1 = SingletonEnum.INSTANCE;
        singleton1.setValue(2);
        System.out.println(singleton1.getValue());
        SingletonEnum singleton2 = SingletonEnum.INSTANCE;
        singleton2.setValue(3);
        System.out.println(singleton1.getValue());
    }

    public enum SingletonEnum{
        INSTANCE;

        int value;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

}
