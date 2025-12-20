package org.akm.array;

import java.util.ArrayList;
import java.util.Arrays;

/*
    Write a program to insert an element at given position. Where position = idx-1;
    Ex -
        I/P - arr[] = {5,7,10,20,-}
                x = 3
                pos = 2
        O/P - arr[] = {5,3,7,10,20}
 */
public class InsertElement {
    public static void main(String[] args) {
        int[] array = new int[5];
        array[0] = 5; array[1] = 7; array[2] = 10;
        array[3] = 20;
        int n = array.length;
        int element = 3;
        int position = 2;
        int capacity = 4;

        System.err.println("Before array : "+Arrays.toString(array));
        insertElement(array, n, element, capacity, position);
    }

    private static void insertElement(int[] array, int n, int element, int capacity, int position) {
        if (n == capacity)
            return;

        int idx = position - 1;

        for (int i = n - 1; i >= idx; i--){
            array[i + 1] = array[i];
        }
        array[idx] = element;

        System.err.println("After array : "+Arrays.toString(array));
    }
}
