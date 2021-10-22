package com.Hausaufgabe1;

import java.util.Arrays;
import static com.Hausaufgabe1.Sorting.insertionSort;
public class Aufgabe2 {
    Aufgabe2(){}
    /**runs each of the exercises from Aufgabe2 with a hardcoded array
     * @param null
     */
    public static void run() {
        int[] array = {2, 3, 4, 5};
        insertionSort(array);//sort the array first
        System.out.print
                (getMaxNumber(array));
        System.out.println();
        System.out.print
                (getMinNumber(array));
        System.out.println();
        System.out.print
                (getMaxSum(array));
        System.out.println();
        System.out.print
                (getMinSum(array));
        System.out.println();
    }

    /**
     * returns the max number in an int array
     * @param numberArray array of ints
     * @return the max from the array
     */
    public static int getMaxNumber(int[] numberArray) {

        return numberArray[numberArray.length-1];//return the max
    }

    /**
     *returns the min nuber in an int array
     * @param numberArray array of ints
     * @return the min from the array
     */
    public static int getMinNumber(int[] numberArray) {

        return numberArray[0];//return the min since its on the first index
    }

    /**
     *returns the max sum of n-1 numbers from the array
     * @param numberArray array of ints we search through
     * @return the max sum as int
     */
    public static int getMaxSum(int[] numberArray) {
        int sum = 0;
        for (int i = numberArray.length - 1; i >= 1; i--) {//start from the end to the beginning
            sum = sum + numberArray[i];
        }
        return sum;
    }
    /**
     *returns the min sum of n-1 numbers from the array
     * @param numberArray array of ints we search through
     * @return the min sum as int
     */
    public static int getMinSum(int[] numberArray) {
        int sum = 0;
        for (int i = 0; i <= numberArray.length - 2; i++) {//start from the begin// ning
            sum = sum + numberArray[i];
        }
        return sum;
    }
}
