package org.akm.array;

import java.util.Arrays;

/*
    Write a program to left-rotate an array by D places.

    Ex :
        #1
        I/P : [1,2,3,4,5]
        d   : 2
        O/P : [3,4,5,1,2]

        #2
        I/P : [1,2,3,4,5]
        d   : 3
        O/P : [4,5,1,2,3]

        #3
        I/P : [1,2,3,4,5]
        d   : 7 --> d = d % n --> 7 % 5 = 2
        O/P : [3,4,5,1,2]
 */
public class LeftRotateByDPlaces {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        int d = 7;
        int n = array.length;

        leftRotate(array, n, d);
    }

    private static void leftRotate(int[] array, int n, int d) {
        // Edge case to check if array is null OR array size == d OR d == 0
        // If array size == d OR d == 0 then array remains unchanged.
        if (array == null || array.length == d || d == 0)
            return;
        // If d > array.length then
        if (d > n)
            d = d % n;

        System.err.println("Before Array : "+ Arrays.toString(array));

        reverse(array, 0, d - 1);
        reverse(array, d, n - 1);
        reverse(array, 0, n - 1);

        System.err.println("After Array : "+ Arrays.toString(array));
    }

    private static void reverse(int[] array, int left, int right) {
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;

            left++; right--;
        }
    }
}
