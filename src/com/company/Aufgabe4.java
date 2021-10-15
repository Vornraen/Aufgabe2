package com.company;

import static com.company.Sorting.insertionSort;

public class Aufgabe4 {
    Aufgabe4(){

    }
    public static void run(){
        int[] Keyboard = {1,2,3};
        int[] Laufwerk ={3,6,7,8,18,20};
        insertionSort(Laufwerk);//sort the arrays first
        insertionSort(Keyboard);
        System.out.print(BilligsteTastatur(Keyboard));
        System.out.println();
        System.out.print(TeuresteGegenstand(Keyboard,Laufwerk));
        System.out.println();
        System.out.print(TeuersteKaufen(Laufwerk,8));
        System.out.println();
        System.out.print(LaufwerkUndKeyboardKaufen(Keyboard,Laufwerk,20));
    }


    public static int BilligsteTastatur(int[] array){
        return array[0];
    }
    public static int TeuresteGegenstand(int[] array,int[] array2){//basic minmax function with the biggest from each array
        if(array[array.length-1]>array2[array2.length-1])
            return array[array.length-1];
        return array2[array2.length-1];
    }
    public static int TeuersteKaufen(int[] array,int n){//find the most expensive from the ones we can choose
        int i=array.length-1;
        while(n<array[i]){
            i--;
        }
        return array[i];
    }
    public static int LaufwerkUndKeyboardKaufen(int[] array,int[] array2,int n){
        int priceaux;
        int finalprice=-1;//this is where we get the final price,-1 if we dont find anything
        for(int i=array.length-1;i>=0;i--){
            priceaux=n-array[i];//budget-current item from the first array starting with the most expensive
            for(int j=array2.length-1;j>0;j--){
                if(priceaux-array2[j]>=0){//if we find a pair we memorize it in final price
                    if(finalprice<array[i]+array2[j])//if its bigger than the previous pair we put it in final price
                    finalprice= array[i]+array2[j];
                }
            }
        }
        return finalprice;//return final price
    }
}
