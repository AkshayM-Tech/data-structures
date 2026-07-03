package searching.binary;

import java.util.Arrays;

/*
    --> Leet Code : 704
    - Given an array of integers nums which is sorted in ascending order, and an integer target,
        write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
    - You must write an algorithm with O(log n) runtime complexity.

    Ex:1 -
        I/P : [-1,0,3,5,9,12]
        Target = 9
        O/P : 4
        Explanation: 9 exists in nums and its index is 4

    Ex:2 -
        I/P : [-1,0,3,5,9,12]
        Target = 2
        O/P : -1
        Explanation: 2 does not exist in nums so return -1
*/
public class SearchElement {
    public static void main(String[] args) {
        int[][] data = {{-1, 0, 3, 5, 9, 12}, {-1, 0, 3, 5, 9, 12}, {5}, {1, 3, 5, 7, 8, 9}};
        int[] keys = {9, 2, 5, 6};
        int key = 0;

        for (int[] array : data) {
            System.err.println(Arrays.toString(array)+" : "+searchKey(array, keys[key++]));
        }
    }

    /*
        - T.C : O(log n) & S.C : O(1)
    */
    private static int searchKey(int[] array, int key) {
        int n = 0;
        if (array != null)
            n = array.length;

        if (n <= 0)
            return -1;

        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (array[mid] == key) {
                return mid;
            }else if (array[mid] > key) {
                high = mid - 1;
            }else  {
                low = mid + 1;
            }
        }
        return -1;
    }
}
