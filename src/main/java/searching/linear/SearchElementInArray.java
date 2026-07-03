package searching.linear;

import java.util.Arrays;

/*
    - You have given a array and a target element called 'key', Your task is to find out the key in array and return
        index of that key otherwise return -1.

    Ex:1 -
        I/P : [1,2,3,4,5,6,7,8,9]
        Key : 7
        O/P : 6 (index)

    Ex:2 -
        I/P : [1,2,3,4,5,6,7,8,9]
        Key : 11
        O/P : -1 (index)
*/
public class SearchElementInArray {
    public static void main(String[] args) {
        int[][] data = {{1, 2, 3, 4, 5, 6, 7, 8, 9}, {6, 4, 2, 8, 9, 5, 6}, {11, 2, 5, 8, 72}};
        int[] keys = {7, 4, 9};
        int key = 0;

        for (int[] array : data) {
            System.err.println(Arrays.toString(array)+" : "+searchKey(array, keys[key++]));
        }
    }

    /*
        - T.C : O(n) & S.C : O(1)
    */
    private static int searchKey(int[] array, int key) {
        int n = array.length;
        if (n == 0)
            return -1;

        for (int i = 0; i < n; i++) {
            if (array[i] == key)
                return i;
        }
        return -1;
    }
}
