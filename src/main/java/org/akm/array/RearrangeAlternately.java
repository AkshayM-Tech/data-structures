package org.akm.array;

import java.util.Arrays;

/*
    Given an array of positive integers. Your task is to rearrange the array elements alternatively
    i.e. first element should be the max value, the second should be the min value,
    the third should be the second max, the fourth should be the second min, and so on.

    Ex :
        #1
        I/P : [1, 2, 3, 4, 5, 6]
        O/P : [6, 1, 5, 2, 4, 3]

        #2
        I/P : [10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110]
        O/P : [110, 10, 100, 20, 90, 30, 80, 40, 70, 50, 60]

        #3
        I/P : [1]
        O/P : [1]
*/
public class RearrangeAlternately {
    public static void main(String[] args) {
        int[][] input = {{1, 2, 3, 4, 5, 6}, {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110},
                         {1}, {1, 2}, {1, 2, 3, 4, 5}};
        for (int[] array : input) {
            //rearrangeArrayBruteForce01(array);
            //rearrangeArrayBruteForce02(array);
            rearrangeArrayBruteForce02(array);
            //rearrangeArrayOptimalSolution(array);
        }
    }

    private static void rearrangeArrayBruteForce01(int[] array) {
        System.err.println("I/P : "+ Arrays.toString(array));

        int n = array.length;
        if (n < 2) {
            System.err.println("O/P : " + Arrays.toString(array));
            return;
        }

        int firstHalfSize = n / 2;
        int[] firstHalf = Arrays.copyOfRange(array, 0, firstHalfSize);
        int[] secondHalf = Arrays.copyOfRange(array, firstHalfSize, n);
        int[] ans = new int[n];

        merge(ans, firstHalf, secondHalf);
    }

    private static void merge(int[] ans, int[] firstHalf, int[] secondHalf) {
        int m = firstHalf.length;
        int n = secondHalf.length;
        int i = 0, j = n - 1, k = 0;


        while (i < m && j >= 0) {
            ans[k++] = secondHalf[j];
            ans[k++] = firstHalf[i];

            i++; j--;
        }

        while (i < m) {
            ans[k++] = firstHalf[i];
            i++;
        }

        while (j >= 0) {
            ans[k++] = secondHalf[j];
            j--;
        }
        System.err.println("O/P : "+Arrays.toString(ans));
    }

    private static void rearrangeArrayBruteForce02(int[] array) {
        System.err.println("I/P : "+Arrays.toString(array));

        int n = array.length;
        if (n < 2){
            System.err.println("O/P : "+Arrays.toString(array));
            return;
        }

        int maxIdx = n - 1;
        int minIdx = 0;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++){
            if (i % 2 == 0) {
                ans[i] = array[maxIdx];
                maxIdx--;
            }else {
                ans[i] = array[minIdx];
                minIdx++;
            }
        }
        System.err.println("O/P : "+Arrays.toString(ans));
    }

    private static void rearrangeArrayBruteForce03(int[] array) {
        System.err.println("I/P : "+Arrays.toString(array));

        int n = array.length;
        if (n < 2){
            System.err.println("O/P : "+Arrays.toString(array));
            return;
        }

        int minIdx = 0;
        int maxIdx = n - 1;
        int[] ans = new int[n];
        for (int i = 0; i < n / 2; i++){
            ans[i * 2] = array[maxIdx];
            maxIdx--;
            ans[i * 2 + 1] = array[minIdx];
            minIdx++;
        }
        System.err.println("O/P : "+Arrays.toString(ans));
    }

    // Encoding & Decoding technique
    private static void rearrangeArrayOptimalSolution(int[] array){
        System.err.println("I/P : "+Arrays.toString(array));

        int n = array.length;
        if (n < 2){
            System.err.println("O/P : "+Arrays.toString(array));
            return;
        }

        int minIdx = 0;
        int maxIdx = n - 1;
        // base value, As array elements are not in the rang of 0 to n-1
        int maxVal = array[n - 1] + 1;

        // Encode array to place 2 values at same index
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) { // Place max element at even index
                int newVal = array[maxIdx] % maxVal;
                array[i] = array[i] + (newVal * maxVal);
                maxIdx--;
            }else { // Place min element at odd index
                int newVal = array[minIdx] % maxVal;
                array[i] = array[i] + (newVal * maxVal);
                minIdx++;
            }
        }

        // Decode array to get actual result
        for (int i = 0; i < n; i++) {
            array[i] = array[i] / maxVal;
        }
        System.err.println("O/P : "+Arrays.toString(array));
    }
}
