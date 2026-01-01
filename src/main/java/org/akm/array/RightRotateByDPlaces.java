package org.akm.array;

import java.util.Arrays;

/*
    Write a program to right-rotate array by D places.

    Ex :
        #1
        I/P : [1,2,3,4,5]
        D   : 1
        O/P : [5,1,2,3,4]

        #2
        I/P : [1,2,3,4,5]
        D   : 2
        O/P : [4,5,1,2,3]

        #3
        I/P : [1,2,3,4,5]
        D   : 7 --> d % n --> 7 % 5 --> 2
        O/P : [4,5,1,2,3]
 */
public class RightRotateByDPlaces {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        int d = 7;
        int n = array.length;

        System.err.println("Before Array : "+ Arrays.toString(array));
        d = d % n;
        reverse(array, n - d, n - 1);
        reverse(array, 0, n - d - 1);
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
