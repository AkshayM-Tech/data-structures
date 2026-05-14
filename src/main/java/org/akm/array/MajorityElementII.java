package org.akm.array;

import java.util.*;

/*
    --> Leet Code: 229 - Majority Element II
    - Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

    Ex:1 -
        I/P : [3,2,3]
        O/P : [3]

    Ex:2 -
        I/P : [1]
        O/P : [1]

    Ex:3 -
        I/P : [1,2]
        O/P : [1,2]
 */
public class MajorityElementII {
    public static void main(String[] args) {
        int[][] data = {{3, 2, 3}, {1}, {1, 2}, {2, 1, 1, 3, 1, 4, 5, 6}};

        for (int[] array : data) {
            System.err.println("=============================BRUTE FORCE===============================");
            System.err.println("I/P : "+ Arrays.toString(array)+" ----> O/P : "+bruteForceApproach(array));
            System.err.println("=============================BETTER===============================");
            System.err.println("I/P : "+ Arrays.toString(array)+" ----> O/P : "+betterApproach(array));
            System.err.println("=============================OPTIMAL===============================");
            System.err.println("I/P : "+ Arrays.toString(array)+" ----> O/P : "+optimalApproach(array));
        }
    }

    private static List<Integer> bruteForceApproach(int[] array) {
        int n =  array.length;
        int majority = n / 3;
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (array[i] == array[j]) {
                    count++;
                }
            }

            if (count > majority && !(ans.contains(array[i]))) {
                ans.add(array[i]);
            }
        }
        return ans;
    }

    private static List<Integer> betterApproach(int[] array) {
        int n = array.length;
        int majority = n / 3;
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);

            if (map.getOrDefault(array[i], 0) > majority) {
                ans.add(array[i]);
            }
        }
        return ans;
    }

    private static List<Integer> optimalApproach(int[] array) {
        int n = array.length;
        int majority = n / 3;
        int count01 = 0;
        int count02 = 0;
        int candidate01 = Integer.MIN_VALUE;
        int candidate02 = Integer.MIN_VALUE;
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (count01 == 0 && array[i] != candidate02) {
                count01++;
                candidate01 = array[i];
            }else if (count02 == 0 && array[i] != candidate01) {
                count02++;
                candidate02 = array[i];
            }else if (array[i] == candidate01) {
                count01++;
            }else if (array[i] == candidate02) {
                count02++;
            }else {
                count01--; count02--;
            }
        }

        int counter01 = 0;
        int counter02 = 0;

        for (int element : array) {
            if (element == candidate01) {
                counter01++;
            }
            if (element == candidate02) {
                counter02++;
            }
        }

        if (counter01 > majority) {
            ans.add(candidate01);
        }
        if (counter02 > majority) {
            ans.add(candidate02);
        }
        return ans;
    }
}
