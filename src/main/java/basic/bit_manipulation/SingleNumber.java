package basic.bit_manipulation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    --> LeetCode : 136
    Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
    You must implement a solution with a linear runtime complexity and use only constant extra space.

    Ex-1 :
        I/P : [2,2,1]
        O/P : 1

    Ex-2 :
        I/P : [4,1,2,1,2]
        O/P : 4

    Ex-3 :
        I/P : [1]
        O/P : 1

    Ex-4 :
        I/P : [1, 3, 2, 3, 1]
        O/P : 2
*/
public class SingleNumber {
    public static void main(String[] args) {
        int[][] input = {{2, 2, 1}, {4, 1, 2, 1, 2}, {1}, {1, 3, 2, 3, 1}};

        for (int[] array : input) {
            System.err.println("O/P-BIT : "+usingBitManipulation(array));
            System.err.println("O/P-MAP : "+usingHashMap(array));
            System.err.println("O/P-BRUTE : "+usingBruteForce(array));
        }
    }

    private static int usingBitManipulation(int[] array) {
        System.err.println("*****************************************************");
        System.err.println("I/P-BIT : "+ Arrays.toString(array));
        int n = array.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans = ans ^ array[i];
            System.err.println(i+" : "+ans);
        }
        return ans;
    }

    private static int usingHashMap(int[] array) {
        System.err.println("*****************************************************");
        System.err.println("I/P-MAP : "+ Arrays.toString(array));
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], 1);
            }else {
                map.put(array[i], map.get(array[i])+1);
            }
        }

        return map.entrySet().stream().filter(e -> e.getValue() == 1).findFirst().get().getKey();
    }

    private static int usingBruteForce(int[] array) {
        System.err.println("*******************************************************");
        System.err.println("I/P-BRUTE : "+ Arrays.toString(array));

        int n = array.length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (array[i] == array[j]) {
                    count++;
                }
            }
            if (count == 1) {
                return array[i];
            }
        }
        return 0;
    }
}
