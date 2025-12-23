package org.akm.array;

/*
    Write a program to check whether given array is sorted or not in increasing order

    Ex. :-
    Input : 20 21 45 89 89 90
    Output : Yes

    Input : 20 20 45 89 89 90
    Output : Yes

    Input : 20 20 78 98 99 97
    Output : No
*/
public class IsArraySorted {
    public static void main(String[] args) {
        int[][] input = {{20, 21, 45, 89, 89, 90},
                         {20, 20, 45, 89, 89, 90},
                         {20, 20, 78, 98, 99, 97}};

        for (int[] array : input)
            System.err.println(isSortedArray(array));
    }

    private static boolean isSortedArray(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++){
            if (array[i] > array[i + 1])
                return false;
        }
        return true;
    }
}
