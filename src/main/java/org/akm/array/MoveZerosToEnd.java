package org.akm.array;

import java.util.Arrays;

/*
    Write a program to move all zeros to the end of array.
    - Maintain the order of non-zero elements.

    I/P : [1,2,0,3,4,0,0,6,7]
    O/P : [1,2,3,4,6,7,0,0,0]
*/
public class MoveZerosToEnd {
    public static void main(String[] args) {
        int[][] input = {{0,1,0,3,12}, {0}, {1,2,0,3,4,0,5,6,0,0,0,7}};

        for (int[] array : input)
            moveZerosToTheEnd(array);
    }

    private static void moveZerosToTheEnd(int[] array) {
        if (array == null || array.length == 0)
            return;

        int n = array.length;
        int idx = 0;

        for (int i = 0; i < n; i++){
            if (array[i] != 0){
                array[idx++] = array[i];
            }
        }

        for (int i = idx; i < n; i++){
            array[i] = 0;
        }
        System.err.println(Arrays.toString(array));
    }
}
