package org.akm.array;

import java.util.Arrays;

/*
    Write a program to reverse the array in group of k.
    I/P : arr = {1,2,3,4,5,6,7,8,9}
            k = 3 //Group value
    O/P : arr = {3,2,1,6,5,4,9,8,7}
*/
public class ReverseArrayInGroup {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        int k = 3;

        System.err.println("Before : "+ Arrays.toString(arr));
        for (int i = 0; i < arr.length; i += k){
            int low = i;
            int high = i + k - 1;

            /* This condition is applicable when last window does not contain k elements
                ex. arr = [1,2,3,4,5,6,7,8]
                      k = 3;
             */
            if (high > arr.length - 1)
                high = arr.length - 1;

            while (low < high){
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;

                low++; high--;
            }
        }
        System.err.println("After : "+ Arrays.toString(arr));
    }
}
