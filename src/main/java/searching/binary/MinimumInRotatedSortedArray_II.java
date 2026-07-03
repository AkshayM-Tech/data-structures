package searching.binary;

import java.util.Arrays;

/*
    --> Leet Code : 154 - Find Minimum in Rotated Sorted Array II
    - Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
    - For example, the array nums = [0,1,4,4,5,6,7] might become:
        [4,5,6,7,0,1,4] if it was rotated 4 times.
        [0,1,4,4,5,6,7] if it was rotated 7 times.
    - Given the sorted rotated array nums that may contain duplicates, return the minimum element of this array.

    E:1
        I/P : [1,3,5]
        O/P : 1

    Ex:2
        I/P : [2,2,2,0,1]
        O/P : 0
*/
public class MinimumInRotatedSortedArray_II {
    public static void main(String[] args) {
        int[][] data = {
                {1, 3, 5},
                {2, 2, 2, 0, 1},
                {1, 1, 1, 1, 1},
                {1, 2},
                {1}
        };

        for (int[] array : data) {
            System.err.println("I/P : "+ Arrays.toString(array)+" ,O/P : "+findMinimumII(array));
        }
    }

    private static int findMinimumII(int[] array) {
        int n = array.length;

        for (int i = 0; i < n; i++) {
            if (array[i] > array[(i + 1) % n]) {
                return array[(i + 1) % n];
            }
        }
        return array[0];
    }
}
