package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Test3 {


    public static void main (String[] args){
        List<String> stuIDs = Arrays.asList("934567890V", "892030890V",
                "913457689V", "886789805V", "907008934V");

        stuIDs.stream().sorted(Comparator.reverseOrder()).forEach((e) ->{
            if(Integer.parseInt(e.substring(0,2))>90){
                if(Integer.parseInt(e.substring(2,5))>500){
                    System.out.println(e);
                }
            }
        });
    }
}
