package org.akm.array;

import java.util.Arrays;

/*
    Write a program to left-rotate an array by one place.
    I/P : [1,2,3,4,5]
    O/P : [2,3,4,5,1]
 */
public class LeftRotateByOnePlace {
    public static void main(String[] args) {
        int[][] input = {{1,2,3,4,5}, {9,8,7,6,5},{1,5,9,2,4}};

        for (int[] array : input){
            usingBruteForceApproach(array);
            usingOptimalSolution(array, 7);
        }
    }

    private static void usingBruteForceApproach(int[] array) {
        if (array == null || array.length < 2)
            return;

        System.err.println("Before Array : "+ Arrays.toString(array));
        int n = array.length;
        int temp = array[0];

        for (int i = 1; i < n; i++) {
            array[i - 1] = array[i];
        }
        array[n - 1] = temp;

        System.err.println("After Array : "+ Arrays.toString(array));
    }

    private static void usingOptimalSolution(int[] array, int d) {
        if (array == null || array.length < 2)
            return;

        System.err.println("Before Array : "+ Arrays.toString(array));

        int n = array.length;
        reverse(array, 0, d - 1);
        reverse(array, d, n - 1);
        reverse(array, 0, n - 1);

        System.err.println("After Array : "+ Arrays.toString(array));
    }

    private static void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++; right--;
        }
    }
}
