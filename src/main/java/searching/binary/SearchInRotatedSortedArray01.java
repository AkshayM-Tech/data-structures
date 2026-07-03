package searching.binary;

import java.util.Arrays;

/*
    --> Leet Code : 33 - Search in Rotated Sorted Array
    - There is an integer array nums sorted in ascending order (with distinct values).
    - Prior to being passed to your function, nums is possibly left rotated at an unknown index k
    - Given the array nums after the possible rotation and an integer target, return the index of target if it is
      in nums, or -1 if it is not in nums.
    - You must write an algorithm with O(log n) runtime complexity.

    Ex : 1
        I/P : [4,5,6,7,0,1,2], target = 0
        O/P : 4

    Ex : 2
        I/P : [4,5,6,7,0,1,2], target = 3
        O/P : -1

    Ex : 3
        I/P : [1], target = 0
        O/P : -1
*/
public class SearchInRotatedSortedArray01 {
    public static void main(String[] args) {
        int[][] data = {
                {4, 5, 6, 7, 0, 1, 2},
                {4, 5, 6, 7, 0, 1, 2},
                {1},
        };
        int[] targets = {0, 3, 0};
        int index = 0;

        for (int[] array : data) {
            System.err.println("I/P : "+Arrays.toString(array)+", Target : "+targets[index]+", O/P : "+searchInSortedAndRotatedArray(array, targets[index]));
            index++;
        }
    }

    private static int searchInSortedAndRotatedArray(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (high + low) / 2;

            if (array[mid] == target) {
                return mid;
            } else if (array[low] <= array[mid]) {// Check if 1st half is sorted
                // Check if target lies in first half
                if (array[low] <= target && array[mid] >  target) {
                    // If target lies in 1st half then ignore 2nd half (move high to 1st half) and search target in 1st half
                    high = mid - 1;
                } else  {
                    // else if target is not lying in 1st half then ignore 1st half (move low to 2nd half) and search target in 2nd half
                    low = mid + 1;
                }
            } else { // Else 2nd half is sorted
                // Check if target lies in 2nd v
                if (array[mid] < target && array[high] >= target) {
                    // If target lies in 2nd half then ignore 1st half (move low to 2nd half) and search target in 2nd half.
                    low = mid + 1;
                } else  {
                    // else if target is not lying in 2nd half then ignore 2nd half (move high to 1st part) and search target in 1st half.
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
