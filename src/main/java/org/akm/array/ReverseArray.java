package org.akm.array;

import java.util.Arrays;

/*
    Write a program to reverse the array.
    I/P : arr = {1,2,3,4,5}
    O/P : arr = {5,4,3,2,1}
 */
public class ReverseArray {

    public static void main(String[] args) {
        int[] array01 = {1,2,3,4,5,6};
        reverseWithoutTempVariable(array01);

        int[] array02 = {1,2,3,4,5,6};
        reverseUsingTempVariable(array02);
    }

    // Without using temp/third variable
    private static void reverseWithoutTempVariable(int[] array) {
        int low = 0;
        int high = array.length - 1;

        System.err.println("Before : "+Arrays.toString(array));
        while (low < high){
            array[low] = array[low] + array[high];
            array[high] = array[low] - array[high];
            array[low] = array[low] - array[high];

            low++; high--;
        }
        System.err.println("After : "+Arrays.toString(array));
    }

    // Using temp/third variable
    private static void reverseUsingTempVariable(int[] array) {
        int low = 0;
        int high = array.length - 1;

        System.err.println("Before : "+Arrays.toString(array));
        while (low < high){
            int temp = array[high];
            array[high] = array[low];
            array[low] = temp;

            low++; high--;
        }
        System.err.println("After : "+Arrays.toString(array));
    }
}
