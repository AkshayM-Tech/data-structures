package org.akm.array;

import java.util.Arrays;

/*
    Write a program to get the index of the second-largest element from given array.

    I/P : array = {12, 35, 1, 10, 34, 1}
    O/P : 1st largest is 35 at  Idx 1
          2nd largest is 34 at Idx 4


    I/P : array = {10, 5, 10}
    O/P : 1st largest is 10 at  Idx 0
          2nd largest is 5 at Idx 1

    I/P : array = {10, 10, 10}
    O/P : 1st largest is 10 at  Idx 0
          2nd - There is not second largest, So return -1.
 */
public class SecondLargestElement {
    public static void main(String[] args) {
        int[][] input = {{12, 35, 1, 10, 34, 1}, {10, 5, 10}, {10, 10, 10}};

        for (int[] array : input)
            System.err.println("Second Largest Element Idx from array "+Arrays.toString(array)+" is : "+getSecondLargestElement(array));
    }

    private static int getSecondLargestElement(int[] array) {
        int n = array.length;
        int firstIdx = 0;
        int secondIdx = -1;

        if (n < 2)
            return -1;

        for (int i = 0; i < n; i++) {
            if (array[i] > array[firstIdx]){
                secondIdx = firstIdx;
                firstIdx = i;
            } else if (array[i] < array[firstIdx]) {
                if (secondIdx == -1 || array[i] > secondIdx)
                    secondIdx = i;
            }
        }
        return secondIdx;
    }
}
