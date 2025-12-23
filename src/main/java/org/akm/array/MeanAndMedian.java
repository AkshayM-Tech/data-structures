package org.akm.array;

import java.util.Arrays;

/*
    Write a program to find MEAN & MEDIAN of given array. Where mean is the average value of
    the given array, median is the average of the two middle elements.

    Note: Return the floor value of mean and median.

    EX : -
    #1 --->
    Input: arr[] = [1, 2, 19, 28, 5]
    Output: 11 5
    Explanation: mean is (1 + 2 + 19  + 28  + 5)/5 = 11.
                 median is 5 (middle element after sorting)

    #2 --->
    Input: arr[] = [2, 8, 3, 4]
    Output: 4 3
    Explanation: mean is floor ((2 + 8 + 3 + 4)/4) = 4.
                 median is floor ((3 + 4)/2) = 3
*/
public class MeanAndMedian {
    public static void main(String[] args) {
        int[][] input = {{1, 2, 19, 28, 5}, {2, 8, 3, 4}};

        for (int[] array : input){
            System.err.println("Mean : "+mean(array));
            System.err.println("Median : "+median(array));
        }
    }

    private static int mean(int[] arr) {
        return Arrays.stream(arr).sum() / arr.length;
    }

    private static int median(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int median = 0;

        if (n % 2 == 0) {
            median = (arr[(n / 2) - 1] + arr[n / 2]) / 2;
        }else {
            median = arr[n / 2];
        }
        return median;
    }
}
