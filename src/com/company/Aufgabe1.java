package com.company;

import java.util.Arrays;

import static com.company.Sorting.insertionSort;

public class Aufgabe1 {
    Aufgabe1(){}
    public static void run() {
        int[] array={13,18,56,54,89,14};
        System.out.print(Arrays.toString(NichtAusreichendeNote(array)));
        System.out.println();
        System.out.print(DurchschnittNoten(array));
        System.out.println();
        System.out.print(Arrays.toString(AbrundetNoten(array)));
        System.out.println();
        System.out.print(HighestDurchschnittNoten(array));
        System.out.println();

    }
    public static int[] NichtAusreichendeNote(int[] noten) {

        int[] auxNoten = new int[noten.length + 1];
        int k = 0; //if the grade is not above 40 we put it in the vector
        for (int note : noten) {
            if (note <= 40) {
                auxNoten[k] = note;
                k++;
            }
        }
        int[] auxNoten2=new int[k]; //we put it in a new aux that's the good size and return it
        while(k>=1){
            auxNoten2[k-1]=auxNoten[k-1];
            k--;
        }
        return auxNoten2;
    }
    public static int DurchschnittNoten(int[] noten) {

        int sum=0;
        for(int note:noten){ //the median of the grades
            sum=note+sum;
        }
        return sum/noten.length;
    }
    public static int[] AbrundetNoten(int[] noten) {

        int[] auxNoten=new int[noten.length];
        int k=0;
        int ok=0;
        for(int note:noten){
            ok=0;
            if(note>38){//if the grade is above 38 we can round it up
                if(note%10>5){
                    auxNoten[k]=note+(10-note%10);//round it up to 10
                    ok=1;
                }

                else {if(note%5>=3){//round it up to 5
                    auxNoten[k]=note+(5-note%5);
                    ok=1;}
                }}
            if(ok==0){//if we didnt round it we just put it in the array
                auxNoten[k]=note;
            }
            k++;
        }
        return auxNoten;//return the array
    }

    public static int HighestDurchschnittNoten(int[] noten) {

        int[] auxNoten=AbrundetNoten(noten);//take the grades
        insertionSort(auxNoten);//sort the grades
        return auxNoten[noten.length-1];//return the last element since its the biggest

    }
}
