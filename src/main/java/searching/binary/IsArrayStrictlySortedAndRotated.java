package searching.binary;

import java.util.Arrays;

/*
    --> Check if Array Is Strictly Sorted and Rotated
    - Given an array nums, return true if the array was originally sorted in non-decreasing order,
        then rotated some number of positions (excluding zero). Otherwise, return false.
    - There may be duplicates in the original array.

    Ex : 1
        I/P : [3,4,5,1,2]
        O/P : true
        Explanation : [1,2,3,4,5] is the original sorted array.You can rotate the array by x = 2 positions to
                        begin on the element of value 3: [3,4,5,1,2].

    Ex : 2
        I/P : [2,1,3,4]
        O/P : false
        Explanation : There is no sorted array once rotated that can make nums.

    Ex : 3
        I/P : [1,2,3]
        O/P : false
        Explanation : [1,2,3] is the original sorted array. But it is rotated by 0 places.
*/
public class IsArrayStrictlySortedAndRotated {
    public static void main(String[] args) {
        int[][] data = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {3, 4, 5, 1, 2},
                {2, 1, 3, 4},
                {1, 1, 1, 1, 1}
        };

        for (int[] array : data) {
            System.err.println(Arrays.toString(array)+" : "+isArrayStrictlySortedAndRotated(array));
        }
    }

    private static boolean isArrayStrictlySortedAndRotated(int[] array) {
        int n = array.length;
        int dropCount = 0;

        for (int i = 0; i < n; i++) {
            if (array[i] > array[(i + 1) % n]) {
                dropCount++;
            }
        }
        return dropCount == 1 && array[0] > array[n - 1];
    }
}
