package com.Hausaufgabe1;

public class Sorting {
    /**
     *Basic insertionSort
     * @param array array of ints where we have a list of numbers
     * @return the array sorted
     */
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];//take the current element
            int j = i - 1;
            while(j >= 0 && current < array[j]) {//search for a place we can put it in
                array[j + 1] = array[j];
                j--;
            }
            array[j+1] = current;//put it in its place
        }
    }
}
