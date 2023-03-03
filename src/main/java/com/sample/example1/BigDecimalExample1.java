package com.sample.example1;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class BigDecimalExample1 {

    public static void main(String[] args) {
        BigDecimal dbShareAmount = new BigDecimal(6970060.430);
        BigDecimal currentAmount = new BigDecimal(78754445.160);
       /* BigDecimal hostBankAmount = dbShareAmount.divide(currentAmount,3,RoundingMode.DOWN);

        System.out.println("Host Bank amount==> " + hostBankAmount);*/

        BigDecimal scheduleAmount = new BigDecimal("0.000");
        BigDecimal schAmountItem = new BigDecimal(-766578.810);
        BigDecimal interestAmount = null;
        scheduleAmount = schAmountItem.add(interestAmount == null ? new BigDecimal("0.00") : interestAmount);

       /* System.out.println("Schedule amount==> " + scheduleAmount);
        System.out.println("Schedule amount==> " + scheduleAmount.setScale(3,RoundingMode.DOWN));*/

        BigDecimal contractAggAmount = new BigDecimal(78754445.160);
        BigDecimal shareAmount = currentAmount.divide(contractAggAmount);

       /* BigDecimal finalAmount = hostBankAmount.multiply(scheduleAmount).multiply(shareAmount);

        System.out.println("Host Bank amount==> " + hostBankAmount);
        System.out.println("Schedule amount==> " + scheduleAmount);
        System.out.println("Share amount==> " + shareAmount);
        System.out.println("Final amount==> " + finalAmount);*/

        BigDecimal finalAmount =
       // dbShareAmount.divide(currentAmount,3,RoundingMode.DOWN)
                dbShareAmount.divide(currentAmount,MathContext.DECIMAL64)
                .multiply(schAmountItem.add(interestAmount == null ? new BigDecimal("0.00") : interestAmount))
                .multiply(currentAmount.divide(contractAggAmount,MathContext.DECIMAL64));



        System.out.println("Final amount==> " + finalAmount);

        /*   BigDecimal first = new BigDecimal(1000.500);
        BigDecimal second = new BigDecimal(5000.300);
        System.out.println("total amount==> " + first.add(second));
        System.out.println("total amount==> " + first.add(second).setScale(3,RoundingMode.DOWN));*/
    }
}
