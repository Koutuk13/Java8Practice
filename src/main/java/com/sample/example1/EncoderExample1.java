package com.sample.example1;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class EncoderExample1 {

    public static void main(String[] args) throws UnsupportedEncodingException{
        enocder();
        //pipeOperator();
    }
    static void enocder()throws UnsupportedEncodingException {
        String sample = "S*EAX58K";
        System.out.println(URLEncoder.encode(sample, StandardCharsets.UTF_8.toString()));
        System.out.println("After encoding :: "+ sample);
        // -;54EE34 = -%3B54EE34
        // --6V71D9 = --6V71D9
        // -#FDG78U = -%23FDG78U
        // -!EA62QY = -%21EA62QY

        String dummy  = "ABCDE_OD";
        System.out.println(dummy.endsWith("_OD"));
    }
    static void pipeOperator(){
        String sample = "ABCRTG123|XYZ567|LMNO8474";
        System.out.println(sample.split("\\|")[0]);
    }
}
