package org.akm.array.cyclicsort;

import java.util.Arrays;

/*
    -> LeetCode : 41
    - Given an unsorted integer array nums, return the smallest missing positive integer.
    - You must implement an algorithm that runs in O(n) time and uses constant extra space.

    Ex:1
    I/p : [1,2,0]
    O/p : 3

    Ex:2
    I/p : [3,4,-1,1]
    O/p : 2

    Ex:3
    I/p : [7,8,9,11,12]
    O/p : 1
*/
public class FirstMissingPositive {
    public static void main(String[] args) {
        int[][] input = {{3,4,-1,1}};//, {1,2,0}, {7,8,9,11,12}};

        for (int[] array : input) {
            System.out.println("I/P : "+ Arrays.toString(array)+" -> O/P : "+firstMissingPositive(array));
        }
    }

    private static int firstMissingPositive(int[] array) {
        int n = array.length;
        int i = 0;

        while (i < n) {
            int correctIndex = array[i] - 1;

            if (array[i] > 0 && array[i] <= n && array[correctIndex] != array[i]) {
                int temp = array[i];
                array[i] = array[correctIndex];
                array[correctIndex] = temp;
            } else {
                i++;
            }
        }
        for (int j = 0; j < n; j++) {
            if (array[j] != j + 1) {
                return j + 1;
            }
        }
        return 0;
    }
}
