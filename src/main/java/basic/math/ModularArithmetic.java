package basic.math;

import java.util.Arrays;

/*
    --> Leet Code : 1497
    - Given an array of integers arr of even length n and an integer k.
        We want to divide the array into exactly n / 2 pairs such that the sum of each pair is divisible by k.
        Return true If you can find a way to do that or false otherwise.

    Ex:1 -
        I/P : [1,2,3,4,5,10,6,7,8,9], k = 5
        O/P : true
        Explanation : Pairs are (1,9),(2,8),(3,7),(4,6) and (5,10).

    Ex:2 -
        I/P : [1,2,3,4,5,6], k = 7
        O/P : true
        Explanation : Pairs are (1,6),(2,5) and(3,4).

    Ex:3 -
        I/P : [1,2,3,4,5,6], k = 10
        O/P : false
        Explanation: You can try all possible pairs to see that there is no way to divide arr into 3 pairs each
        with sum divisible by 10.
*/
public class ModularArithmetic {
    public static void main(String[] args) {
        int[][] data = {{-1, -1, -1, -1, 2, 2, -2, -2}};
        int[] k = {3};
        int i = 0;

        for (int[] array : data) {
            System.err.println(Arrays.toString(array)+" - "+findPairs(array, k[i++]));
        }
    }

    private static boolean findPairs(int[] array, int k) {
        int[] freq = new  int[k];
        for (int num : array) {
            int rem =  num % k;
            if (rem < 0) {
                rem = (rem + k) % k;
            }
            freq[rem]++;
        }

        if (freq[0] % 2 != 0)
            return false;

        for (int i = 1; i <= k / 2; i++) {
            if (freq[i] != freq[k - i])
                return false;
        }
        return true;
    }
}
