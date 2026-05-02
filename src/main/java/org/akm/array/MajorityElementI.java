package org.akm.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    --> Leet Code : 169 - Majority Element
    - Given an array nums of size n, return the majority element.
    - The majority element is the element that appears more than ⌊n / 2⌋ times.
        You may assume that the majority element always exists in the array.

    Ex:1 -
        I/P : [3,2,3]
        O/P : 3

    Ex:2 -
        I/P : [2,2,1,1,1,2,2]
        O/P : 2
*/
public class MajorityElementI {
    public static void main(String[] args) {
        int[][] data = {{3, 2, 3}, {2, 2, 1, 1, 1, 2, 2}};

        for (int[] array : data) {
            System.err.println("======================BRUTE FORCE=================================");
            bruteForceApproach(array);
            System.err.println("======================BETTER=================================");
            betterApproach(array);
            System.err.println("======================OPTIMAL=================================");
            optimalApproach(array);
        }
    }

    private static void bruteForceApproach(int[] array) {
        int n = array.length;
        int majority = n / 2;
        int count = 0;

        System.err.println("I/P : "+ Arrays.toString(array));
        System.err.println("Majority : " + majority);

        for (int i = 0; i < n; i++) {
            int currentElement = array[i];
            for (int j = 0; j < n; j++) {
                if (currentElement == array[j]) {
                    count++;
                }
            }
            if (count > majority) {
                System.err.println("O/P : "+currentElement);
                break;
            }
        }
    }

    private static void betterApproach(int[] array) {
        int n = array.length;
        int majority = n / 2;
        Map<Integer, Integer> map = new HashMap<>();

        System.err.println("I/P : "+ Arrays.toString(array));

        for (int i = 0; i < n; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i], map.get(array[i]) + 1);
            }else {
                map.put(array[i], 1);
            }

            if (map.get(array[i]) > majority) {
                System.err.println("O/P : "+array[i]);
                break;
            }
        }
    }

    private static void optimalApproach(int[] array) {
        int n = array.length;
        int count = 0;
        int candidate = -1;

        System.err.println("I/P : "+ Arrays.toString(array));

        for(int i = 0; i < n; i++){
            if(count == 0){
                candidate = array[i];
            }

            if (array[i] == candidate) {
                count++;
            }else  {
                count--;
            }
        }
        System.err.println("I/P : "+ candidate);
    }
}
