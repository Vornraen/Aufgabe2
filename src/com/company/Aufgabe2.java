package com.company;

import java.util.Arrays;
import static com.company.Sorting.insertionSort;
public class Aufgabe2 {
    Aufgabe2(){}
    public static void run() {
        int[] array = {2, 3, 4, 5};
        insertionSort(array);//sort the array first
        System.out.print(MaxZahl(array));
        System.out.println();
        System.out.print(MinZahl(array));
        System.out.println();
        System.out.print(MaxSumme(array));
        System.out.println();
        System.out.print(MinSumme(array));
        System.out.println();
    }

    public static int MaxZahl(int[] numberArray) {
        return numberArray[numberArray.length-1];//return the max
    }

    public static int MinZahl(int[] numberArray) {
        return numberArray[0];//return the min since its on the first index
    }

    public static int MaxSumme(int[] numberArray) {
        int sum = 0;
        for (int i = numberArray.length - 1; i >= 1; i--) {//start from the end to the beginning
            sum = sum + numberArray[i];
        }
        return sum;
    }

    public static int MinSumme(int[] numberArray) {
        int sum = 0;
        for (int i = 0; i <= numberArray.length - 2; i++) {//start from the beginning
            sum = sum + numberArray[i];
        }
        return sum;
    }
}
