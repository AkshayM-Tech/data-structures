package org.akm.array;

import java.util.Arrays;

/*
    Write a program to right-rotate an array by 1 place.

    I/P : [1,2,3,4,5]
    O/P : [5,1,2,3,4]
 */
public class RightRotateBruteForce {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int n = arr.length;
        int d = 1;
        rightRotateByOnePlaces(arr, n, d);

        int[] arr1 = {1,2,3,4,5};
        int n1 = arr.length;
        int d1 = 2;
        rightRotateByTwoPlaces(arr1, n1, d1);
    }

    private static void rightRotateByOnePlaces(int[] arr, int n, int d) {
        System.err.println("Before Array : "+ Arrays.toString(arr));

        int temp = arr[n - d];
        for (int i = n - d - 1; i >= 0; i--){
            arr[i + d] = arr[i];
        }
        arr[0] = temp;

        System.err.println("After Array : "+ Arrays.toString(arr));
    }

    private static void rightRotateByTwoPlaces(int[] arr, int n, int d) {
        System.err.println("Before Array : "+ Arrays.toString(arr));

        int[] temp = new int[d];
        for (int i = n - d; i < n; i++)
            temp[i - d - 1] = arr[i];

        for (int i = n - d - 1; i >= 0; i--){
            arr[i + d] = arr[i];
        }

        for (int i = 0; i < d; i++){
            arr[i] = temp[i];
        }
        System.err.println("After Array : "+ Arrays.toString(arr));
    }
}
