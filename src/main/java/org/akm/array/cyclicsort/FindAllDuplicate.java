package org.akm.array.cyclicsort;

import java.util.Arrays;
import java.util.List;

/*
    -> LeetCode : 442
    - Given an integer array nums of length n where all the integers of nums are in the range [1, n]
        and each integer appears at most twice, return an array of all the integers that appears twice.
    - You must write an algorithm that runs in O(n) time and uses only constant auxiliary space,
        excluding the space needed to store the output

    Ex:1
    I/p : [4,3,2,7,8,2,3,1]
    O/p : [2,3]

    Ex:2
    I/p : [1,1,2]
    O/p : [1]

    Ex:3
    I/P : [1]
    O/P : []
*/
public class FindAllDuplicate {
    public static void main(String[] args) {
        int[][] input = {{4,3,2,7,8,2,3,1}, {1,1,2}, {1}};

        for (int[] array : input) {
            System.out.println("I/P : "+ Arrays.toString(array)+" -> O/P : "+findDuplicates(array));
        }
    }

    private static List<Integer> findDuplicates(int[] array) {
        int n = array.length;
        int i = 0;
        List<Integer> ans = new java.util.ArrayList<>();

        while (i < n) {
            int correctIndex = array[i] - 1;

            if (array[correctIndex] != array[i]) {
                int temp = array[i];
                array[i] = array[correctIndex];
                array[correctIndex] = temp;
            } else {
                i++;
            }
        }
        for (int j = 0; j < n; j++) {
            if (array[j] != j + 1) {
                ans.add(array[j]);
            }
        }
        return ans;
    }
}
