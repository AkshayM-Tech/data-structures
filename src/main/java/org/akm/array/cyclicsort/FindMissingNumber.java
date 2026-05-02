package org.akm.array.cyclicsort;

import java.util.Arrays;

/*
    -> LeetCode : 268
    Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that
    is missing from the array.

    #Ex-1:
        Input: nums = [3,0,1]
        Output: 2
        Explanation:
            n = 3 since there are 3 numbers, so all numbers are in the range [0,3].
            2 is the missing number in the range since it does not appear in nums.
    #Ex-2:
        Input: nums = [0,1]
        Output: 2
        Explanation:
            n = 2 since there are 2 numbers, so all numbers are in the range [0,2].
            2 is the missing number in the range since it does not appear in nums.
    #Ex-3:
        Input: nums = [9,6,4,2,3,5,7,0,1]
        Output: 8
        Explanation:
            n = 9 since there are 9 numbers, so all numbers are in the range [0,9].
            8 is the missing number in the range since it does not appear in nums.
*/
public class FindMissingNumber {
    public static void main(String[] args) {
        int[][] input = {{3,0,1}, {0,1}, {9,6,4,2,3,5,7,0,1}};

        for (int[] array : input){
            System.err.println("(01) - I/P : "+Arrays.toString(array)+" O/P : "+findMissingNumber01(array));
            System.err.println("(02) - I/P : "+Arrays.toString(array)+" O/P : "+findMissingNumber02(array));
            System.err.println("(03) - I/P : "+Arrays.toString(array)+" O/P : "+findMissingNumber03(array));
            System.err.println("(04) - I/P : "+Arrays.toString(array)+" O/P : "+findMissingNumber04(array));
        }
    }

    /*
        In this approach we are putting each element at their exact index. i.e 0 at 0th index, 1 at 1st index,
        and so on...
        After that we are checking which element is missing it's index and that index is considered as missing number.
    */
    private static int findMissingNumber01(int[] array) {
        int n = array.length;
        int index = 0;

        while (index < n){
            int correctIndex = array[index];
            if (array[index] < n && array[index] != array[correctIndex]){
                int temp = array[index];
                array[index] = array[correctIndex];
                array[correctIndex] = temp;
            }else {
                index++;
            }
        }

        for (int i = 0; i < n; i++){
            if (array[i] != i) {
                return i;
            }
        }
        return n;
    }

    /*
        In this approach we are making use of sorting, First we will sort the array and then check which element is
        not at it's correct index and that index itself considered as missing number.
    */
    private static int findMissingNumber02(int[] array) {
        int n = array.length;
        Arrays.sort(array);

        for (int i = 0; i < n; i++){
            if (array[i] != i) {
                return i;
            }
        }
        return n;
    }

    /*
        In this approach we are calculating expected sum by running a for loop from 0 to n, and then
        run 2nd for loop to calculate actual sum of array elements.

        --> missingNumber = (expectedSum - actualSum)
    */
    private static int findMissingNumber03(int[] array) {
        int n = array.length;
        long expectedSum = 0;
        long actualSum = 0;

        for (int i = 0; i <= n; i++){
            expectedSum += i;
        }

        for (int j : array) {
            actualSum += j;
        }
        return (int) (expectedSum - actualSum);
    }

    /*
        In this solution we are using mathematical formula to get the sum of array elements.

        NOTE :- This trick works only if array contains numbers from 0 - N (no missing numbers).
    */
    private static int findMissingNumber04(int[] array) {
        int n = array.length;
        long expectedSum = (long) n * (n + 1) / 2;
        long actualSum = 0;

        for (int i : array) {
            actualSum += i;
        }
        return (int) (expectedSum - actualSum);
    }
}
