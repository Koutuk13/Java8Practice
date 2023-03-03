package com.sample.example1;

public class RunTimeExceptionExample1 {

    public static void main(String[] args) {

        for(int i=0;i<10;i++){
            if(i==5) {
                try {
                    throw new TestRunTimeException();
                }
                catch (TestRunTimeException e){
                    System.out.println("Exception caught");
                }
            }
            System.out.println(i);
        }
    }
}
