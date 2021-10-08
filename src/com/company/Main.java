package com.company;

import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
	int[] array={2,3,4,5};
    MaxZahl(array);
    MinZahl(array);
    MaxSumme(array);
    MinSumme(array);
    }

    public static int MaxZahl(int[] numberArray){
        Arrays.sort(numberArray);
        return numberArray[0];
    }
    public static int MinZahl(int[] numberArray){
        Arrays.sort(numberArray);
        return numberArray[numberArray.length-1];
    }
    public static int MaxSumme(int[] numberArray){
        Arrays.sort(numberArray);
        int sum=0;
        for(int i=numberArray.length-1;i>=1;i--) {
            sum=sum+numberArray[i];
        }
        return sum;
        }
    public static int MinSumme(int[] numberArray){
        Arrays.sort(numberArray);
        int sum=0;
        for(int i=0;i>=numberArray.length-2;i--) {
            sum=sum+numberArray[i];
        }
        return sum;
    }
    }


