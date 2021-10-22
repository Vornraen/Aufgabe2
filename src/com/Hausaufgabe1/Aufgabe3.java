package com.Hausaufgabe1;

import java.util.Arrays;

public class Aufgabe3 {
    Aufgabe3(){}
    /**runs each of the exercises from Aufgabe3 with a hardcoded array
     * @param null
     */
    public static void run() {
        int[] array = {1,2,3};
        int[] array2 ={3,6,7,8};
        int[] y=new int[100];
        int[] x=new int[100];
        numberArrayToGoodFormat(array,y);
        numberArrayToGoodFormat(array2,x);//each big number will have its numbers of digits on the [0] index and the rest of the digits in reverse order
        sum(x,y);
        System.out.print
                (Arrays.toString(bigNumberToPrintableForm(x)));
        System.out.println();
        numberArrayToGoodFormat(array2,x);
        multiplication(x,9);
        System.out.print
                (Arrays.toString(bigNumberToPrintableForm(x)));
        System.out.println();
        numberArrayToGoodFormat(array2,x);
        subtraction(x,y);
        System.out.print
                (Arrays.toString(bigNumberToPrintableForm(x)));
        System.out.println();
        numberArrayToGoodFormat(array2,x);
        division(x,5);
        System.out.print
                (Arrays.toString(bigNumberToPrintableForm(x)));
        System.out.println();

    }

    /**
     *transforms the number back to a printable form and returns it
     * @param numberToTransform the number we want to transform back to a printable form
     * @return the number in the normal printable form
     */
    public static int[] bigNumberToPrintableForm(int[] numberToTransform){
        int[] a=new int[numberToTransform[0]]; //get the length of the number
        int k=0;
        for(int i=numberToTransform[0];i>0;i--){//go backwards and add each digit other than the [0] index to the array
            a[k]=numberToTransform[i];
            k++;
        }
        return a;
    }
    /**
     *transforms a number stored on arrays so that we have the number of digits on the [0] index
     * and the rest of the digits are in revers and puts the result in another array
     * @param numberToTransform the number we want to transform
     * @param storeResult the array where we want to store the result
     */
    public static void numberArrayToGoodFormat(int[] numberToTransform, int[] storeResult){//transforms a given array into one we can work with
        storeResult[0]=numberToTransform.length;
        for(int i=numberToTransform.length,j=1;i>0;i--,j++){
            storeResult[j]=numberToTransform[i-1];
        }
    }
    /**
     *adds a big number from another and stores the result in the first
     *@param firstBigNumber the first number we want to add
     *@param secondBigNumber the second number we want to add
     */
    public static void sum(int[] firstBigNumber,int[] secondBigNumber)
    {
        int i,t=0;
        if(firstBigNumber[0]<secondBigNumber[0])
            firstBigNumber[0]=secondBigNumber[0];//we choose the number with the biggest digits number to base our final digits on
        for(i=1;i<=firstBigNumber[0];i++,t/=10)
        {
            t=firstBigNumber[i]+secondBigNumber[i]+t;//current sum including carry-number
            firstBigNumber[i]=t%10;//put the last digit of the carry-number in its place
        }
        if(t!=0)//if the carry-number has digits left we put them at the end
            firstBigNumber[++firstBigNumber[0]]=t;
    }

    /**
     *multiplies the bigNumber by the smallNumber and stores the result in the bigNumber
     * @param bigNumber the big number we want to multiply
     * @param smallNumber the normal small number we want to multiply by
     */
    static void multiplication(int[] bigNumber, int smallNumber)

    {
        int i,t=0;
        for(i=1;i<=bigNumber[0];i++,t/=10)
        {
            t=bigNumber[i]*smallNumber+t;//multiply each digit with the given number and save it in the carry number
            bigNumber[i]=t%10;//put the last digit of the carry-number in its place
        }
        for(;t!=0;t/=10)//if the carry number has digits left we put them at the end
            bigNumber[++bigNumber[0]]=t%10;
    }
    static int Compare(int[] x,int[] y){//checks which is bigger
        if(x[0]>y[0])//if it has more digits
            return 1;
        if(x[x.length-1]>y[y.length-1])//if the most important digit is bigger
            return 1;
        return 0;//if neither return y is bigger
    }
    /**
     * subtracts a big number from another and stores the result in the first
     * @param firstBigNumber the number we want to subtract from
     * @param secondBigNumber the number we subtract
     */
    static void subtraction(int[] firstBigNumber, int[] secondBigNumber) //we suppose x>y, we can use the above compare function to check
    {
        int i,j, t = 0;
        for (i = 1; i <= firstBigNumber[0]; i++)
            if(firstBigNumber[i]>=secondBigNumber[i])//if we dont have to borrow to make the difference
                firstBigNumber[i]-=secondBigNumber[i];
            else
            {
                j=i+1;//increment the index from which we borrow
                while(firstBigNumber[j]==0)//until we can borrow
                    firstBigNumber[j++]=9;//set the number on the index to 9 since we borrow
                firstBigNumber[j]--;//borrow
                firstBigNumber[i]=10+firstBigNumber[i]-secondBigNumber[i];//put the result on the correct index
            }
        for (; firstBigNumber[0] > 1 && firstBigNumber[firstBigNumber[0]]==0; firstBigNumber[0]--);//check if we have more zeroes than expected and adjust the number of digits accordingly
    }
    /**
     *divides a big number by a typical number and stores the result in the bigNumber, also returns the %
     * @param 
     * @return the % of the division
     */
    static int division(int[] bigNumber, int smallNumber)
    {
        int i,r=0;
        for(i=bigNumber[0];i>0;i--)
        {
            r=10*r+bigNumber[i];//multiply so we can divide
            bigNumber[i]=r/smallNumber;//put the number in its place
            r=r%smallNumber;//memorize the rest
        }
        while (bigNumber[bigNumber[0]]==0 && bigNumber[0]>1) {
            bigNumber[0]--;//check if we have more zeroes than expected and adjust the number of digits accordingly
        }
        return r;
    }

}
