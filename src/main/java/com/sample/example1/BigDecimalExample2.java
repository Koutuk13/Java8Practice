package com.sample.example1;

import java.math.BigDecimal;

public class BigDecimalExample2 {
    public static void main(String[] args) {
        String casValue = " -0,35% ";
        casValue = casValue.trim();
        BigDecimal bCasValue;
       // BigDecimal cas = new BigDecimal("0,123");
        try {
            if (casValue.endsWith("%")) {
                String tempCasValue = casValue.substring(0,casValue.length()-1);
                bCasValue = new BigDecimal(tempCasValue);
                System.out.println("if parsed value is : "+ bCasValue);
            } else {
                bCasValue = new BigDecimal(casValue);
                System.out.println("else parsed value is : "+ bCasValue);
            }
        }catch (NumberFormatException e){
            System.out.println("Exception occured while parsing :: "+ e);
            e.printStackTrace();
        }
    }
}
