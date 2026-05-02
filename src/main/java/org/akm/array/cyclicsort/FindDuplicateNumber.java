package org.akm.array.cyclicsort;

import java.util.Arrays;

/*
    -> LeetCode : 287
    - Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
    - There is only one repeated number in nums, return this repeated number.
    - You must solve the problem without modifying the array nums and using only constant extra space.

    Ex:1
    I/P : [1,3,4,2,2]
    O/P : 2

    Ex:2
    I/P : [3,1,3,4,2]
    O/P : 3

    Ex:3
    I/P : [3,3,3,3,3]
    O/P : 3
*/
public class FindDuplicateNumber {
    public static void main(String[] args) {
        int[][] input = {{1,3,4,2,2}, {3,1,3,4,2}, {3,3,3,3,3}};

        for (int[] array : input)
            System.out.println("I/P : "+ Arrays.toString(array)+" --> O/P : "+findDuplicateNumber(array));
    }

    private static int findDuplicateNumber(int[] array) {
        int n = array.length;
        int i = 0;

        while (i < n) {
            int correctIndex = array[i] - 1;

            if (array[correctIndex] != array[i]){
                int temp = array[i];
                array[i] = array[correctIndex];
                array[correctIndex] = temp;
            }else {
                i++;
            }
        }
        for (int j = 0; j < n; j++){
            if (array[j] != j + 1){
                return array[j];
            }
        }
        return 0;
    }
}
