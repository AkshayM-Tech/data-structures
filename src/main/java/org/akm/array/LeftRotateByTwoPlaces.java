package org.akm.array;

import java.util.Arrays;

/*
    Write a prgram to left-rotate an array by D places.
    Ex :
        I/P : [1,2,3,4,5]
        D   : 2
        O/P : [3,4,5,1,2]

        I/P : [1,2,3,4,5]
        D   : 3
        O/P : [4,5,1,2,3]
 */
public class LeftRotateByTwoPlaces {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        int d = 3;
        int n = array.length;

        System.err.println("Before Array : "+ Arrays.toString(array));
        int[] temp = new int[d];
        for (int i = 0; i < d; i++){
            temp[i] = array[i];
        }

        for (int i = d; i < n; i++){
            array[i - d] = array[i];
        }

        int k = 0;
        for (int i = n - d; i < n; i++){
            array[i] = temp[k];
            k++;
        }
        System.err.println("After Array : "+ Arrays.toString(array));
    }
}
