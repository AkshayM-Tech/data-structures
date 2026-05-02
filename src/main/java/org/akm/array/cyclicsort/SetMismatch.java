package org.akm.array.cyclicsort;

import java.util.Arrays;

/*
    -> LeetCode : 645
    You have a set of integers s, which originally contains all the numbers from 1 to n.
    Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set,
    which results in repetition of one number and loss of another number.

    You are given an integer array nums representing the data status of this set after the error.

    Find the number that occurs twice and the number that is missing and return them in the form of an array.

    Ex:1
        I/P : [1,2,2,4]
        O/P : [2,3]

    Ex:2
        I/P : [1,1]
        O/P : [1,2]
*/
public class SetMismatch {
    public static void main(String[] args) {
        int[][] input = {{1,2,2,4}, {1,1}};

        for (int[] array : input)
            System.out.println("I/P : "+ Arrays.toString(array)+" --> O/P : "+Arrays.toString(findErrorNums(array)));
    }

    private static int[] findErrorNums(int[] array) {
        int n = array.length;
        int i = 0;

        while (i < n) {
            int correctIndex = array[i] - 1;

            if ((array[correctIndex] != array[i])){
                int temp = array[i];
                array[i] = array[correctIndex];
                array[correctIndex] = temp;
            }else {
                i++;
            }
        }

        for (int j = 0; j < n; j++) {
            if (array[j] != j + 1) {
                return new int[]{array[j], j + 1};
            }
        }
        return new int[]{};
    }
}
