package searching.binary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    --> Leet Code : 81
    - There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).
    - Given the array after the rotation and an integer target, return true if target is present in array, otherwise false.

    Ex:1 -
        I/P : [2,5,6,0,0,1,2], target = 0
        O/P : true

    Ex:2 -
        I/P : [2,5,6,0,0,1,2], target = 3
        O/P : false
*/
public class SearchInRotatedSortedArray02 {
    public static void main(String[] args) {
        int[][] data = {{2, 5, 6, 0, 0, 1, 2}, {2, 5, 6, 0, 0, 1, 2}, {1, 0, 1, 1, 1}};
        int[] target = {0, 3, 0};
        int idx = 0;

        for (int[] array : data) {
            System.err.println("I/P : "+ Arrays.toString(array)+", Target = "+target[idx]+", O/P : "+search(array, target[idx]));
            idx++;
        }
    }

    private static boolean search(int[] array, int x) {
        int n =  array.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (array[mid] == x) {
                return true;
            }
            // If LOW = MID = HIGH, then shrink search space
            if (array[low] ==  array[mid] && array[mid] == array[high]) {
                low++;
                high--;
            } else if (array[low] <= array[mid]) {
                if (array[low] <= x && array[mid] > x) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else  {
                if (array[mid] < x && array[high] >= x) {
                    low = mid + 1;
                } else  {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}
