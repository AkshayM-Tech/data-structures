package org.akm.array;

import java.util.Arrays;

/*
    Write a program to move all zeros to the beginning of the array.

    I/P : [1,2,0,3,4,0,5,0,6,0,0]
 */
public class MoveZerosToBeginning {
    public static void main(String[] args) {
        int[][] input = {{0,1,0,3,12}, {0}, {1,2,0,3,4,0,5,6,0,0,0,7}};

        for (int[] array : input){
            moveZerosToStarting(array);
        }
    }

    private static void moveZerosToStarting(int[] array) {
        if (array == null || array.length == 0)
            return;

        int n = array.length - 1;
        int idx = n;

        for (int i = n; i >= 0; i--){
            if (array[i] != 0){
                array[idx--] = array[i];
            }
        }

        for (int i = idx; i >= 0; i--){
            array[i] = 0;
        }

        System.err.println(Arrays.toString(array));
    }
}
