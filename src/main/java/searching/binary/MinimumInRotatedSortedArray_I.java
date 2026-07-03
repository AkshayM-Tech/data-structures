package searching.binary;

import java.util.Arrays;

/*
    --> Leet Code : 153 - Find Minimum in Rotated Sorted Array
    - Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
    - For example, the array nums = [0,1,2,4,5,6,7] might become:
      [4,5,6,7,0,1,2] if it was rotated 4 times.
      [0,1,2,4,5,6,7] if it was rotated 7 times.
    - Given the sorted rotated array nums of unique elements, return the minimum element of this array.

    Ex:1
        I/P : [3,4,5,1,2]
        O/P : 1
        Explanation : The original array was [1,2,3,4,5] rotated 3 times.

    Ex:2
        I/P : [4,5,6,7,0,1,2]
        O/p : 0
        Explanation : The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.

    Ex:3
        I/P : [11,13,15,17]
        O/P : 11
        Explanation : The original array was [11,13,15,17] and it was rotated 4 times.

    Ex:4
        I/P : [1, 1, 1, 1, 1]
        O/P : 1
        Explanation : The original array was [1, 1, 1, 1, 1] and it was rotated 0 times.
*/
public class MinimumInRotatedSortedArray_I {
    public static void main(String[] args) {
        int[][] data = {
                {3, 4, 5, 1, 2},
                {4, 5, 6, 7, 0, 1, 2},
                {11, 13, 15, 17},
                {1, 1, 1, 1, 1},
                {1},
                {1, 2}
        };

        for (int[] array : data) {
            System.err.println("I/P : "+ Arrays.toString(array)+" ,O/P : "+findMinimumI(array));
        }
    }

    private static int findMinimumI(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            if (array[i] > array[(i + 1) % n]) {
                return array[(i + 1) % n];
            }
        }
        return array[0];
    }
}
