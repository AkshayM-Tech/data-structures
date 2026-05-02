package org.akm.array;

import java.util.Arrays;
import java.util.List;

/*
    -> GFG : Frequencies in a Limited Array
    You are given an array arr[] containing positive integers. The elements in the array arr[] range from  1 to n
    (where n is the size of the array), and some numbers may be repeated or absent. Your have to count the frequency
    of all numbers in the range 1 to n and return an array of size n such that result[i] represents the frequency
    of the number i (1-based indexing).

    Ex:1
        I/P : [2, 3, 2, 3, 5]
        O/P : [0, 2, 2, 0, 1]
        Explanation: We have: 1 occurring 0 times, 2 occurring 2 times, 3 occurring 2 times, 4 occurring 0 times,
                     and 5 occurring 1 time.

    Ex:2
        I/P : [3, 3, 3, 3]
        O/P : [0, 0, 4, 0]
        Explanation: We have: 1 occurring 0 times, 2 occurring 0 times, 3 occurring 4 times, and 4 occurring 0 times.

    Ex:3
        I/P : [1]
        O/p : [1]
        Explanation: We have: 1 occurring 1 time, and there are no other numbers between 1 and the size of the array.
*/
public class FrequenciesLimitedArray {
    public static void main(String[] args) {
        int[][] input = {{2, 3, 2, 3, 5}, {3, 3, 3, 3}, {1}};

        for (int[] array : input) {
            System.out.println("I/P : "+ Arrays.toString(array)+" -> O/P : "+frequencyCount(array));
        }
    }

    private static List<Integer> frequencyCount(int[] array) {
        int n = array.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int index = array[i] - 1;
            ans[index] += 1;
        }
        return Arrays.stream(ans).boxed().toList();
    }
}
