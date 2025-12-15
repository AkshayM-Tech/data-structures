package org.akm.array;

import java.util.Arrays;

/*
    Write a program to delete the given element from given array
    and keep the array size as it is.
 */
public class DeleteElement {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,7,9};
        int target = 7;

        deleteElementFromArray(nums, target);
    }

    private static void deleteElementFromArray(int[] nums, int target) {
        int index = 0;
        int n = nums.length;

        for (index = 0; index < n; index++) {
            if (nums[index] == target)
                break;
        }
        if (index == n)
            return;

        for (int j = index; j < n - 1; j++){
            nums[j] = nums[j + 1];
        }

        System.err.println(Arrays.toString(nums));
    }
}
