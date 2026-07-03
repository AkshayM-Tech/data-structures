package searching.binary;

import java.util.Arrays;

/*
    - GFG - Ceil in a Sorted Array
    - Given a sorted array arr[] and an integer x, find the index (0-based) of the smallest element in arr[] that is
      greater than or equal to x. This element is called the ceil of x. If such an element does not exist, return -1.

    - Note: In case of multiple occurrences of ceil of x, return the index of the first occurrence.

    Ex : 1
        I/P : [1, 2, 8, 10, 11, 12, 19], x = 5
        O/P : 2
        Explanation : Smallest number greater than 5 is 8, whose index is 2.

    Ex : 2
        I/P : [1, 2, 8, 10, 11, 12, 19], x = 20
        O/P : -1
        Explanation : No element greater than 20 is found. So output is -1.

    Ex : 3
        I/P : [1, 1, 2, 8, 10, 11, 12, 19], x = 0
        O/P : 0
        Explanation : Smallest number greater than 0 is 1, whose indices are 0 and 1.
                    The index of the first occurrence is 0.
*/
public class CeilInSortedArray {
    public static void main(String[] args) {
        int[][] data = {{1, 2, 8, 10, 10, 12, 19}, {1, 2, 8, 10, 10, 12, 19}, {1, 2, 8, 10, 11, 12, 19}};

        int[] keys = {5, 20, 0};
        int key = 0;

        for (int[] array : data) {
            System.err.println("Ceil of target X : "+keys[key]+" In Array : "+ Arrays.toString(array)+" is : "+
                    findCeil(array, keys[key]));
            key++;
        }
    }

    private static int findCeil(int[] array, int key) {
        int n = 0;
        if (array != null)
            n = array.length;
        if (n <= 0)
            return -1;

        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (array[mid] >= key) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return low;
    }
}
