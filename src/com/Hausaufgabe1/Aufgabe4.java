package com.Hausaufgabe1;

import static com.Hausaufgabe1.Sorting.insertionSort;

public class Aufgabe4 {
    Aufgabe4(){

    }
    /**runs each of the exercises from Aufgabe4 with a hardcoded array
     * @param null
     */
    public static void run(){
        int[] Keyboard = {1,2,3};
        int[] Laufwerk ={3,6,7,8,18,20};
        insertionSort(Laufwerk);//sort the arrays first
        insertionSort(Keyboard);
        System.out.print
                (getCheapestKeyboardPrice(Keyboard));
        System.out.println();
        System.out.print
                (getMostExpensiveEquipment(Keyboard,Laufwerk));
        System.out.println();
        System.out.print
                (getMostExpensiveDiskDriveInBudget(Laufwerk,8));
        System.out.println();
        System.out.print
                (getMostExpensiveDiskDriveAndKeyboardInBudget(Keyboard,Laufwerk,20));
    }

    /**
     *returns the cheapest keyboard price
     * @param keyboardPrices array with the the prices of the keyboards
     * @return the cheapest keyboard's price as int
     */
    public static int getCheapestKeyboardPrice(int[] keyboardPrices){

        return keyboardPrices[0];
    }

    /**
     * returns the most expensive equipment looking in both keyboardPrices and diskDrivePrices
     * @param keyboardPrices array of ints with the prices of keyboards
     * @param diskDrivePrices array of ints with the prices of disk drives
     * @return the most expensive item found
     */
    public static int getMostExpensiveEquipment(int[] keyboardPrices,int[] diskDrivePrices){//basic minmax function with the biggest from each array
        if(keyboardPrices[keyboardPrices.length-1]>diskDrivePrices[diskDrivePrices.length-1])
            return keyboardPrices[keyboardPrices.length-1];
        return diskDrivePrices[diskDrivePrices.length-1];
    }

    /**
     *returns the most expensive disk drive that can be bought
     * @param diskDrivePrices array of ints with the prices of diskdrives
     * @param budget the maximum budget for a diskdrive
     * @return the most expensive affordable diskdrive
     */
    public static int getMostExpensiveDiskDriveInBudget(int[] diskDrivePrices,int budget){//find the most expensive from the ones we can choose
        int i=diskDrivePrices.length-1;
        while(budget<diskDrivePrices[i]){
            i--;
        }
        return diskDrivePrices[i];
    }

    /**
     *finds the most expensive pair of both diskdrive and keyboards
     * @param diskDrivePrices the array with prices of diskdrives
     * @param keyboardPrices the array with prices of keyboards
     * @param budget the maximum price of a pair
     * @return the price of the pair or -1 if we cant find any pairs
     */
    public static int getMostExpensiveDiskDriveAndKeyboardInBudget(int[] diskDrivePrices,int[] keyboardPrices,int budget){
        int price;
        int finalprice=-1;//this is where we get the final price,-1 if we dont find anything
        for(int i=diskDrivePrices.length-1;i>=0;i--){
            price=budget-diskDrivePrices[i];//budget-current item from the first array starting with the most expensive
            for(int j=keyboardPrices.length-1;j>=0;j--){
                if(price-keyboardPrices[j]>=0){//if we find a pair we memorize it in final price
                    if(finalprice<diskDrivePrices[i]+keyboardPrices[j])//if its bigger than the previous pair we put it in final price
                    finalprice= diskDrivePrices[i]+keyboardPrices[j];
                }
            }
        }
        return finalprice;//return final price
    }
}
