package org.akm.array.cyclicsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    -> LeetCode : 448
    Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers
    in the range [1, n] that do not appear in nums.

    Ex:1
        I/P : [4,3,2,7,8,2,3,1]
        O/P : [5,6]

    Ex:2
        I/P : [1,1]
        O/P : [2]
*/
public class FindAllDisappearedNumbers {
    public static void main(String[] args) {
        int[][] input = {{4,3,2,7,8,2,3,1}, {1,1}};

        for (int[] array : input)
            System.out.println(findDisappearedNumbers(array));
    }

    private static List<Integer> findDisappearedNumbers(int[] array) {
        int n = array.length;
        List<Integer> ans = new ArrayList<>();
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
                ans.add(j + 1);
            }
        }
        return ans;
    }
}
