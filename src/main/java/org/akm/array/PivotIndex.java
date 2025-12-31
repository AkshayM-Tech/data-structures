package org.akm.array;

import java.util.Arrays;

/*
    Write a program to find pivot index of given array.
    - The pivot index is the index where the sum of all the left side elements is equal to
    right side elements sum.
    - If the index is on the left edge of the array, then the left sum is '0', Because there
    are no elements to the left.
    - Ex :
    #1
        I/P = {1,7,3,6,5,6}
        O/P = 3
        Explanation - Left sum till 3 is 11 & Right sum from 4 to 5 (n-1) is 11.
    #2
        I/P = {1,2,3}
        O/P = -1
        Explanation - There is no index that satisfy above condition.
    #3
        I/P = {2,1,-1}
        O/P = 0
        Explanation - Left sum till 0 is 0 & Right sum from 1 to 2 (n-1) is 0.
*/
public class PivotIndex {
    public static void main(String[] args) {
        int[][] input = {{1,7,3,6,5,6}, {1,2,3}, {2,1,-1}};

        for (int[] array : input)
            System.err.println("Pivot index from the input "+ Arrays.toString(array) +" is : "+getPivotIndex(array));
    }

    private static int getPivotIndex(int[] array) {
        int n = array.length;
        int leftSum = 0;
        int rightSum = 0;

        for (int k : array) {
            rightSum += k;
        }

        for (int j = 0; j < n; j++){
            rightSum -= array[j];

            if (leftSum == rightSum)
                return j;

            leftSum += array[j];
        }
        return -1;
    }
}
