package org.akm.array;

import java.util.Arrays;

/*
    GFG : Stock Buy and Sell
    You are given an array denoting the cost of a stock on each day.
    You need to find the maximum total profit that if we can buy and sell the stocks any number of times.
    Note: We can only sell a stock which we have bought earlier and we cannot hold multiple stocks on any day.

    Ex:1
        I/P : [7, 1, 5, 3, 6, 4]
        O/P : 7
        Explanation: Byu stock on day 2 (price = 1) and sell it on day 3 (price = 5), profit = 5-1 = 4.
                     Then buy stock on day 4 (price = 3) and sell it on day 5 (price = 6), profit = 6-3 = 3.
                     Total profit is 4 + 3 = 7.
 */
public class StockBuySell {
    public static void main(String[] args) {
        int[][] input = {
                {7, 1, 5, 3, 6, 4},
                {4, 2, 2, 2, 4},
                {4, 2},
                {1, 5, 3, 8, 12},
                {40, 30, 20, 10},
                {10, 20, 30, 40}
        };

        for (int[] arr : input)
            System.out.println("I/P : "+ Arrays.toString(arr) +" -> O/P : "+maxProfit(arr));
    }

    private static int maxProfit(int[] arr) {
        int n = arr.length;
        int maxProfit = 0;

        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                maxProfit += arr[i] - arr[i - 1];
            }
        }
        return maxProfit;
    }
}
