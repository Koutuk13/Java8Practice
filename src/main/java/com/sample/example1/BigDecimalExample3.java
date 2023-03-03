package com.sample.example1;

import java.math.BigDecimal;
import java.math.MathContext;

public class BigDecimalExample3 {
    public static void main(String[] args) {

        BigDecimal dbShareAmount = new BigDecimal(10235150.480);
        BigDecimal contractAggAmount = new BigDecimal(18764442.580);
        BigDecimal scheduleAmount = new BigDecimal(18764442.580);

        BigDecimal finalAmount =
                dbShareAmount.divide(contractAggAmount, MathContext.DECIMAL64)
                        .multiply(scheduleAmount);

        System.out.println(finalAmount);
    }
}
