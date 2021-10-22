package com.Hausaufgabe1;

import java.util.Arrays;

import static com.Hausaufgabe1.Sorting.insertionSort;

public class Aufgabe1 {
    Aufgabe1(){}

    /**runs each of the exercises from Aufgabe1 with a hardcoded array
     * @param null
     */
    public static void run() {
        int[] array={13,18,56,40,89,14};
        System.out.print
                (Arrays.toString(getinsufficientGradeList(array)));
        System.out.println();
        System.out.print
                (getMedianGrade(array));
        System.out.println();
        System.out.print
                (Arrays.toString(getRoundedGrades(array)));
        System.out.println();
        System.out.print
                (getBiggestRoundedGrade(array));
        System.out.println();

    }
    /**
     * Checks if the grades in a given array are below 40 and returns them if they are;
     * @param gradesList the array of the grades that we check
     * @return the array of the grades that are insufficient
     */
    public static int[] getinsufficientGradeList(int[] gradesList) {

        int[] auxNoten = new int[gradesList.length + 1];
        int k = 0; //if the grade is not above 40 we put it in the vector
        for (int note : gradesList) {
            if (note <40) {
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
    /**
     *Calculates the median grade from a list of grades, formula is (sumOfAllGrades
     * divided by how many there are)
     * @param gradesList the list of grades that we look through
     * @return an int that's the median grade
     */
    public static int getMedianGrade(int[] gradesList) {

        int sum=0;
        for(int note:gradesList){ //the median of the grades
            sum=note+sum;
        }
        return sum/gradesList.length;
    }
    /**
     *Returns an array of the grades that can be rounded to the next 5 multiple
     * @param gradesList array of the grades that we look through
     * @return array with the rounded grades
     */
    public static int[] getRoundedGrades(int[] gradesList) {

        int[] auxNoten=new int[gradesList.length];
        int k=0;
        for(int note: gradesList){

            if(note>38){//if the grade is above 38 we can round it up
                if(note%10>5){
                    auxNoten[k]=note+(10-note%10);//round it up to 10
                    k++;
                }

                else {if(note%5>=3){//round it up to 5
                    auxNoten[k]=note+(5-note%5);
                    k++;}
                }}


        }
        return Arrays.copyOfRange(auxNoten,0,k);//return the array
    }
    /**
     *Returns the biggest of the rounded grades
     * @param gradesList array with the grades in it
     * @return the biggest grade from the list after we see what grades we can round
     */
    public static int getBiggestRoundedGrade(int[] gradesList) {

        int[] auxGradesList=getRoundedGrades(gradesList);//take the grades
        insertionSort(auxGradesList);//sort the grades
        return auxGradesList[auxGradesList.length-1];//return the last element since its the biggest

    }
}
