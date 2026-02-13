package org.akm.array;

public class MaxSumSubArray {
    public static void main(String[] args) {
        int[] array = {1, 4, 2, 10, 23, 3, 1, 0, 20};//{100,200,300,400};

        int ans = 0;
        int currentSum = 0;
        int k = 4; // group of value
        int n = array.length;

        for (int i = 0; i < n - 1; i += k) {
            int low = i;
            int high = i + k;

            while (low < high) {
                currentSum += array[low];
                low++;
            }

            System.err.println(i+" : "+currentSum);
            if (ans < currentSum)
                ans = currentSum;
        }

        System.err.println("Max Sum : "+ans);
    }
}
