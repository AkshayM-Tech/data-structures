package org.akm.array;

import java.util.Arrays;

/*
    Write a program to get product of array except self.
    - Given an integer array arr, return an array answer such that answer[i] is equal
      to the product of all the elements of arr except arr[i].
    - Condition :- You cant use division operation here.

    Ex :
    #1
        I/P : {1,2,3,4}
        O/P : {24,12,8,6}
        Explanation -
    #2
        I/P : {-1,1,0,-3,3}
        O/P : {0,0,9,0,0}
        Explanation - As it is having single '0' so for rest of the locations product
                      will be 0 and for 0'th location it will be some non-zero value.
    #3
        I/P : {-1,1,0,-3,3,0}
        O/P : {0,0,0,0,0,0}
        Explanation - As it is having two 0's so for all the locations product
                      will be 0.
 */
public class ProductOfArray {
    public static void main(String[] args) {
        int[][] input = {{1,2,3,4}, {-1,1,0,-3,3}, {-1,1,0,-3,3,0}};

        for (int[] array : input) {
            //withoutDivisionApproach01(array);
            //withoutDivisionApproach02(array);
            usingDivision(array);
        }
    }

    private static void withoutDivisionApproach01(int[] array) {
        if (array == null || array.length == 0)
            return;

        int n = array.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        int current = 1;
        for (int i = 0; i < n; i++){
            ans[i] = ans[i] * current;
            current = current * array[i];
        }

        current = 1;
        for (int i = n - 1; i >= 0; i--){
            ans[i] = ans[i] * current;
            current = current * array[i];
        }

        System.err.println("I/P : "+Arrays.toString(array));
        System.err.println("O/P : "+Arrays.toString(ans));
        System.err.println("--------------------------------------------------------------");
    }

    private static void withoutDivisionApproach02(int[] array) {
        if (array == null || array.length == 0)
            return;

        int n = array.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;

                ans[i] = ans[i] * array[j];
            }
        }

        System.err.println("I/P : "+Arrays.toString(array));
        System.err.println("O/P : "+Arrays.toString(ans));
        System.err.println("--------------------------------------------------------------");
    }

    private static void usingDivision(int[] array) {
        if (array == null || array.length == 0)
            return;

        int n = array.length;
        int[] ans = new int[n];

        int zeroIdx = -1;
        int zeroCount = 0;

        for (int i = 0; i < n; i++){
            if (array[i] == 0){
                zeroIdx = i;
                zeroCount++;
            }
        }

        if (zeroCount > 1){
            Arrays.fill(ans, 0);
        }else if (zeroCount == 1){
            int prod = getProduct(array);

            Arrays.fill(ans, 0);
            ans[zeroIdx] = prod;
        }else {
            int prod = getProduct(array);
            for (int i = 0; i < n; i++){
                ans[i] = prod / array[i];
            }
        }
        System.err.println("I/P : "+Arrays.toString(array));
        System.err.println("O/P : "+Arrays.toString(ans));
        System.err.println("--------------------------------------------------------------");
    }

    private static int getProduct(int[] array){
        int prod = 1;

        for (int num : array){
            if (num != 0)
                prod *= num;
        }
        return prod;
    }
}