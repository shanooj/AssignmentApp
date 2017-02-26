package com.karbaros.myapp.utility;

/**
 * Created by shanu on 10-Jan-17.
 */

public class ArrayOperation {


    public static int[] generateSortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i<array.length; i++) {
            array[i] = i+1;
        }
        return array;
    }
    public static int[] generateSortedArrayDesc(int size) {
        int[] array = new int[size];
        for (int i = array.length-1; i>=0; i--) {
            array[i] = i + 1;
        }
        return array;
    }
    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        for (int i =0; i<array.length; i++) {
            array[i] = (int) (Math.random()*1000);
        }
        return array;
    }
    // make a clone of  array
    public static int[] makeTempArray (int[] array) {
        int size = array.length;
        int[] arrayTemp = new int[size];
        for (int i = 0; i < arrayTemp.length; i++) {
            arrayTemp[i] = array[i];
        }
        return arrayTemp;
    }

}
