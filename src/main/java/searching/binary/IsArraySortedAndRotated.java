package searching.binary;

import java.util.Arrays;

/*
    --> Leet Code : 1752 - Check if Array Is Sorted and Rotated
    - Given an array nums, return true if the array was originally sorted in non-decreasing order,
        then rotated some number of positions (including zero). Otherwise, return false.
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
        O/P : true
        Explanation : [1,2,3] is the original sorted array. You can rotate the array by x = 0 positions
                        (i.e. no rotation) to make nums.
*/
public class IsArraySortedAndRotated {
    public static void main(String[] args) {
        int[][] data = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {3, 4, 5, 1, 2},
                {2, 1, 3, 4},
                {1, 1, 1, 1, 1}
        };

        for (int[] array : data) {
            System.err.println(Arrays.toString(array)+" : "+isArraySortedAndRotated(array));
        }
    }

    /*
        Here simply sorted array will be considered as rotated by 0 places, ex-[1,2,3,4], Because while comparing
        circular connection last element will be greater than first element.
    */
    private static boolean isArraySortedAndRotated(int[] array) {
        int n = array.length;
        int dropCount = 0;

        for (int i = 0; i < n; i++) {
            if (array[i] > array[(i + 1) % n]) {
                dropCount++;
            }
        }
        return dropCount <= 1;
    }
}
