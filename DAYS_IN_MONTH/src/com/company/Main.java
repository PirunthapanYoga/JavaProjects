package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader read=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input : ");
        String input=read.readLine().trim();
        String[] input_arr=input.split(" ");

        String[] Month = new String[] {"January","February","March","April","May","June","July","August","September","October","November","December"};
        int[] days = new int[] {31,28,31,30,31,30,31,31,30,31,30,31};

        int index_days=0;
        for(int i=0;i<12;i++){
            if(input_arr[0].equalsIgnoreCase(Month[i])){
                index_days=i;
                break;
            }
        }

        int y=Integer.parseInt(input_arr[1]);
        boolean leap=false;

        if(y%4==0 && y%100!=0){
            leap=true;
        }else if(y%400==0){
            leap=true;
        }else{
            leap=false;
        }


        if(leap && index_days==1){
            System.out.println("Output : 29" );
        }else{
            System.out.println("Output : " + days[index_days]);
        }
    }
}
