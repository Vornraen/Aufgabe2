package com.company;

public class Sorting {
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
