package com.company;

import java.util.Arrays;

public class Aufgabe3 {
    Aufgabe3(){}
    public static void run() {
        int[] array = {1,2,3};
        int[] array2 ={3,6,7,8,0,0,0,0,0,0};
        int[] y=new int[100];
        int[] x=new int[100];
        ToGoodFormat(array,y);
        ToGoodFormat(array2,x);//each big number will have its numbers of digits on the [0] index and the rest of the digits in reverse order
        Sum(x,y);
        int[] printstring=Arrays.copyOfRange(x, 0, x[0]);
        System.out.print(Arrays.toString(printstring));
        System.out.println();
        ToGoodFormat(array2,x);
        Multiplication(x,9);
        printstring=Arrays.copyOfRange(x, 0, x[0]);
        System.out.print(Arrays.toString(printstring));
        System.out.println();
        ToGoodFormat(array2,x);
        Difference(x,y);
        printstring=Arrays.copyOfRange(x, 0, x[0]);
        System.out.print(Arrays.toString(printstring));
        System.out.println();
        ToGoodFormat(array2,x);
        Division(x,5);
        printstring=Arrays.copyOfRange(x, 0, x[0]);
        System.out.print(Arrays.toString(printstring));
        System.out.println();

    }
    public static void ToGoodFormat(int x[],int dest[]){//transforms a given array into one we can work with
        dest[0]=x.length;
        for(int i=x.length,j=1;i>0;i--,j++){
            dest[j]=x[i-1];
        }
    }

    public static void Sum(int[] x,int[] y)//we will save the result in x
    {
        int i,t=0;
        if(x[0]<y[0])
            x[0]=y[0];//we choose the number with the biggest digits number to base our final digits on
        for(i=1;i<=x[0];i++,t/=10)
        {
            t=x[i]+y[i]+t;//current sum including carry-number
            x[i]=t%10;//put the last digit of the carry-number in its place
        }
        if(t!=0)//if the carry-number has digits left we put them at the end
            x[++x[0]]=t;
    }
    static void Multiplication(int[] x, int n)

    {
        int i,t=0;
        for(i=1;i<=x[0];i++,t/=10)
        {
            t=x[i]*n+t;//multiply each digit with the given number and save it in the carry number
            x[i]=t%10;//put the last digit of the carry-number in its place
        }
        for(;t!=0;t/=10)//if the carry number has digits left we put them at the end
            x[++x[0]]=t%10;
    }
    static int Compare(int[] x,int[] y){//checks which is bigger
        if(x[0]>y[0])//if it has more digits
            return 1;
        if(x[x.length-1]>y[y.length-1])//if the most important digit is bigger
            return 1;
        return 0;//if neither return y is bigger
    }
    static void Difference(int[] x, int[] y) //we suppose x>y, we can use the above compare function to check
    {
        int i,j, t = 0;
        for (i = 1; i <= x[0]; i++)
            if(x[i]>=y[i])//if we dont have to borrow to make the difference
                x[i]-=y[i];
            else
            {
                j=i+1;//increment the index from which we borrow
                while(x[j]==0)//until we can borrow
                    x[j++]=9;//set the number on the index to 9 since we borrow
                x[j]--;//borrow
                x[i]=10+x[i]-y[i];//put the result on the correct index
            }
        for (; x[0] > 1 && x[x[0]]==0; x[0]--);//check if we have more zeroes than expected and adjust the number of digits accordingly
    }

    static int Division(int[] x, int n)
    {
        int i,r=0;
        for(i=x[0];i>0;i--)
        {
            r=10*r+x[i];//multiply so we can divide
            x[i]=r/n;//put the number in its place
            r=r%n;//memorize the rest
        }
        for(;x[x[0]]==0 && x[0]>1;)
            x[0]--;//check if we have more zeroes than expected and adjust the number of digits accordingly
        return r;
    }

}
