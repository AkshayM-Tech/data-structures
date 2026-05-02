package org.akm.array;

import java.util.Arrays;

/*
    You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and
    negative integers.
    You should return the array of nums such that the array follows the given conditions:
    - Every consecutive pair of integers have opposite signs.
    - For all integers with the same sign, the order in which they were present in nums is preserved.
    - The rearranged array begins with a positive integer.

    EX :
    #1
        Input  : [3,1,-2,-5,2,-4]
        Output : [3,-2,1,-5,2,-4]
    #2
        Input  : [-1,1]
        Output : [1,-1]
 */
public class RearrangeArrayElementsBySign {
    public static void main(String[] args) {
        int[][] input = {{3,1,-2,-5,2,-4,9}, {-1,1}};

        for (int[] array : input) {
            System.err.println("Input : "+Arrays.toString(array));
            //rearrangeArrayBruteForce01(array, array.length);
            rearrangeArrayBruteForce02(array, array.length);
        }
    }

    /*
        TC = O(n) & SC = O(n), But here we are using 2 for loops 1 is to separate +ve & -ve elements and 2nd is to
        rearrange them into ans[]

        NOTE : This solution will work only for input of even length.
    */
    private static void rearrangeArrayBruteForce01(int[] array, int length) {
        int[] ans = new int[length];
        int[] positive = new int[length/2];
        int[] negative = new int[length/2];
        int positiveIdx = 0, negativeIdx = 0;

        for (int element : array){
            if (element >= 0){
                positive[positiveIdx] = element;
                positiveIdx++;
            }else {
                negative[negativeIdx] = element;
                negativeIdx++;
            }
        }

        int m = positive.length;
        int n = negative.length;
        int i = 0, j = 0, k = 0;

        while (i < m && j < n){
            ans[k++] = positive[i++];
            ans[k++] = negative[j++];
        }

        while (i < m){
            ans[k++] = positive[i++];
        }

        while (j < n){
            ans[k++] = negative[j++];
        }

        System.out.println("Output : "+ Arrays.toString(ans));
    }

    /*
        This approach will be the same as 1st one but the difference is here we are doing it in sing pass
        (means using only one for loop to rearrange elements)

        NOTE : This solution will work for both even & odd length inputs.
     */
    private static void rearrangeArrayBruteForce02(int[] array, int length) {
        int[] ans = new int[length];
        int positiveIdx = 0, negativeIdx = 1;

        for (int element : array){
            if (element < 0){
                ans[negativeIdx] = element;
                negativeIdx += 2;
            }else {
                ans[positiveIdx] = element;
                positiveIdx += 2;
            }
        }
        System.out.println("Output : "+ Arrays.toString(ans));
    }
}
