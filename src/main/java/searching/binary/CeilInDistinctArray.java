package searching.binary;

import java.util.Arrays;

/*
    - Leet Code : 35
    - Given a sorted array of distinct integers and a target X, You have to return the index of X and if X is not
      present then return it ceil value.
    - Ceil is the next greater value of X.

    Ex : 1
        I/P : [1, 3, 5, 7, 9], X = 4, O/P : 2
    Ex : 2
        I/P : [1, 3, 5, 7, 9], X = 0, O/P : 1
    Ex : 1
        I/P : [1, 3, 5, 7, 9], X = 10, O/P : 5
 */
public class CeilInDistinctArray {
    public static void main(String[] args) {
        int[][] data = {{1, 3, 5, 7, 9}, {1, 3, 5, 7, 9}, {1, 3, 5, 7, 9}};
        int[] keys = {4, 0, 10};
        int key = 0;

        for (int[] array : data) {
            System.err.println("I/P :"+ Arrays.toString(array)+", X : "+keys[key]+", O/P : "+findCeil(array, keys[key]));
            key++;
        }
    }

    private static int findCeil(int[] array, int key) {
        int n = 0;
        if (array != null && array.length > 0) {
            n = array.length;
        }

        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (array[mid] == key) {
                return mid;
            } else if (array[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
