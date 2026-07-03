package searching.binary;

import java.util.Arrays;

/*
    --> Leet Code : 34
    - Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a
      given target value.
    - If target is not found in the array, return [-1, -1].

    Ex : 1
        I/P : [5,7,7,8,8,10], target = 8
        O/p : [3,4]

    Ex : 2
        I/P : [0, 1, 1, 1, 1, 2], target = 1
        O/P : [1, 4]

    Ex : 3
        I/P : [5,7,7,8,8,10], target = 6
        O/P : [-1,-1]

    Ex : 4
        I/P : [], target = 0
        O/P : [-1,-1]
*/
public class FindFirstAndLastPosition {
    public static void main(String[] args) {
        int[][] data = {
                {5,7,7,8,8,10},
                {5,7,7,8,8,10},
                {0, 1, 1, 1, 1, 2},
                {}
        };
        int[] targets = {8, 6, 1, 0};
        int index = 0;

        for (int[] array : data) {
            System.err.println("I/P : "+Arrays.toString(array)+", Target : "+targets[index]+" , O/P : "+ Arrays.toString(findFirstAndLastPosition(array, targets[index])));
            index++;
        }
    }

    private static int[] findFirstAndLastPosition(int[] array, int target) {
        int firstPosition = findFirstOccurrence(array, target);
        int lastPosition = findLastOccurrence(array, target);

        return new int[] {firstPosition, lastPosition};
    }

    private static int findFirstOccurrence(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (array[mid] == target) {
                ans = mid;
                high = mid - 1;
            } else if (array[mid] >  target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static int findLastOccurrence(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (array[mid] == target) {
                ans = mid;
                low = mid + 1;
            } else if (array[mid] < target) {
                low = mid + 1;
            } else  {
                high = mid - 1;
            }
        }
        return ans;
    }
}
