package com.sample.example1;

public class EnumExample2 {

    public static void main(String[] args) {
        SingletonEnum singleton = SingletonEnum.INSTANCE;
        singleton.setValue(2);
        System.out.println(singleton.getValue());
        singleton.setValue(3);
        System.out.println(singleton.getValue());
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
