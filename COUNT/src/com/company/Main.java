package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
		BufferedReader read =new BufferedReader (new InputStreamReader(System.in));
		System.out.println("Enter the number with spaces");
			String l= read.readLine().trim();
			String[] k= l.split(" ");
			int[] numbers = new int[k.length];

			for(int i=0;i<k.length;i++){
				numbers[i]=Integer.parseInt(k[i]);
			}


	        int count_odd=0;
	        int count_even=0;

	        for(int n : numbers){
	            if(n%2==0){
	                count_even++;
                }else{
	                count_odd++;
                }
            }

	        System.out.println("Numbers of even numbers : " + count_even);
	        System.out.println("Numbers of even numbers : " + count_odd );
    }
}
