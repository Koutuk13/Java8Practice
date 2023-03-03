package com.sample.example1;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class StringExample1 {

    public static final String CONST1 = "const1";
    public static final String CONST2 = "const1";

    public static void main(String[] args) {

    /*  String sql = String.format(CONST1 +
                          "continue1 = date('%1$s') \r\n" +
                            "continue2 = date('%2$s') \r\n" +
                          "union \r\n" +
                          CONST2 +
                          "continue3 = date('%3$s') \r\n", "04/11/2022", "05/11/2022","06/11/2022");
      System.out.println("Query is :: "+ sql);
*/
       /* List<String> sq3 = Arrays.asList("abc","def","pqr","xyz");
        sq3.stream().map(s-> "'" + s + "'").forEach(System.out::println);
        List<String> sq3_1 = sq3.stream().map(s-> "'" + s + "'").collect(Collectors.toList());
        System.out.println(String.join(",",sq3_1));
        String sq3_2 = sq3.stream().map(s-> "'" + s + "'").collect(Collectors.joining(","));
        System.out.println(String.join(",",sq3_2));

        String sql2  = String.format("Where event in (select * from where row = '%1$s' and rows in (%2$s)) \r\n" +
                    " and date = '%3$s'", "arg1", sq3_2, "arg2");
        System.out.println(sql2);

        String sql3  = String.format("Where event in (select * from where row = '%s' and rows like '%s')"
                         , "arg1", "%arg2%");
        System.out.println(sql3);*/

        String emailID = "kaavya.uppu@db.com";

        Supplier<Boolean> acutal= ()->{
            String actual = "Dispatched success via email. Dispatched to [kaavya.uppu@db.com, kaavya.uppu@db.com, kaavya.uppu@db.com, abc@db.com]";
            Boolean result = actual.contains(emailID);
            System.out.println(result.toString());
            return  result;
        };
        System.out.println(acutal.get().toString());


    }


}
