package com.company;

public class Car{

    public static String Check(int x ,int y){
        try {
            int c = y/x;
        }catch(ArithmeticException a){
            return "Can't divide by 0";
        }
        return "Can Divide";
    }

}
