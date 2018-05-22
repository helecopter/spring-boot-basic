package com.example.demo.domain;

public class FizzBuzz {

    public static String getValue(int input){
        String value = String.valueOf(input);
        String value2 = "";
        if(input%3==0){
            value2 = "Fizz";
        }
        if(input%5==0){
            value2 += "Buzz";
        }
        if(!value2.equals(""))
            return value2;
        return value;
    }
}
