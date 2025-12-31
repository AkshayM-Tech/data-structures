package org.akm.array;

import java.util.Arrays;

/*
    Write a program to remove duplicates from sorted array
    Ex :-
    #1
    I/P = {10,20,20,20,30,30,40}
    O/P = {10,20,30,40}
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] input = {10, 20, 20, 20, 30 ,30, 40};
        System.err.println("Unique Elements : "+removeDuplicates(input));
    }

    private static int removeDuplicates(int[] input) {
        System.err.println("Before Array : "+ Arrays.toString(input));

        int n = input.length;
        int idx = 0;

        if(n == 0)
            return 0;

        for (int i = 1; i < n; i++) {
            if (input[idx] != input[i]) {
                idx++;
                input[idx] = input[i];
            }
        }
        System.err.println("After Array : "+ Arrays.toString(input));

        return idx;
    }
}
