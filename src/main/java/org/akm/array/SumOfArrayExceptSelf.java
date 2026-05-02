package org.akm.array;

import java.util.Arrays;

/*
    Write a program to get sum of array elements except self.
    - Given an integer array arr, return an array answer such that answer[i] is equal
      to the sum of all the elements of arr except arr[i].
    - Condition :- i.  Without using subtraction
                   ii. Using subtraction

    EX :
    #1 : I/P - [1,2,3,4]
         O/P - [9,8,7,6]
*/
public class SumOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] array = {1,2,3,4};

        //withoutSubtraction(array);
        withSubtraction(array);
    }

    private static void withoutSubtraction(int[] array) {
        int n = array.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 0);

        System.err.println("I/P : "+Arrays.toString(ans));

        int current = 0;
        for (int i = 0; i < n; i++){
            ans[i] = ans[i] + current;
            current = array[i] + current;
        }

        current = 0;
        for (int i = n - 1; i >= 0; i--){
            ans[i] = ans[i] + current;
            current = array[i] + current;
        }

        System.err.println("O/P : "+Arrays.toString(ans));
    }

    private static void withSubtraction(int[] array) {
        int n = array.length;
        int totalSum = Arrays.stream(array).sum();

        System.err.println("I/P : "+Arrays.toString(array));

        for (int i = 0; i < n; i++){
            array[i] = totalSum - array[i];
        }

        System.err.println("O/P : "+Arrays.toString(array));
    }
}
