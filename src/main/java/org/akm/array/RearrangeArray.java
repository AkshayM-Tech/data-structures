package org.akm.array;

import java.util.Arrays;

/*
    Given an array arr[] of size n where every element is in the range from 0 to n-1.
    Rearrange the given array so that the transformed array arrT[i] becomes arr[arr[i]].

    Ex :
    Input: arr[] = [4,0,2,1,3]
    Output: [3, 4, 2, 0, 1]
    Explanation: arr[arr[0]] = arr[4] = 3,
                 arr[arr[1]] = arr[0] = 4,
                 arr[arr[2]] = arr[2] = 2,
                 arr[arr[3]] = arr[1] = 0,
                 arr[arr[4]] = arr[3] = 1 and so on so, arr becomes [3, 4, 2, 0, 1]
 */
public class RearrangeArray {
    public static void main(String[] args) {
        int[] arr = {4,0,2,1,3};
        int n = arr.length;

        System.err.println("Before Array : "+ Arrays.toString(arr));
        for (int i = 0; i < n; i++){
            int newValue = arr[arr[i]] % n;
            arr[i] = arr[i] + (newValue * n);
        }

        for (int i = 0; i < n; i++){
            arr[i] = arr[i] / n;
        }
        System.err.println("After Array : "+ Arrays.toString(arr));
    }
}
