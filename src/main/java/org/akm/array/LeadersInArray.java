package org.akm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
    Write a program to print all the LEADERS in the array.
    An element is a leader if it is greater than all the elements to its right side.
    And the rightmost element is always a leader.

    Ex :
        #1
        I/P : [16, 17, 4, 3, 5, 2]
        O/P : [17, 5, 2]

        #2
        I/P : [10, 4, 2, 4, 1]
        O/P : [10, 4, 4, 1]

        #3
        I/P : [5, 10, 20, 40]
        O/P : [40]

        #4
        I/P : [30, 10, 10, 5]
        O/P : [30, 10, 10, 5]
 */
public class LeadersInArray {
    public static void main(String[] args) {
        int[][] input = {{16, 17, 4, 3, 5, 2}, {10, 4, 2, 4, 1}, {5, 10, 20, 40}, {30, 10, 10, 5}};

        for (int[] array : input) {
            System.err.println("I/P : " + Arrays.toString(array) + " || O/P : " + Arrays.toString(getLeadersBruteForce(array)));
            System.err.println("I/P : " + Arrays.toString(array) + " || O/P : " + Arrays.toString(getLeadersOptimalSolution(array)));
        }
    }

    private static int[] getLeadersBruteForce(int[] array) {
        int n = array.length;
        int[] ans = new int[n];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            boolean status = true;
            for (int j = i + 1; j < n; j++) {
                if (array[j] > array[i]){
                    status = false;
                    break;
                }
            }
            if (status)
                ans[idx++] = array[i];
        }
        return Arrays.copyOfRange(ans, 0, idx);
    }

    private static int[] getLeadersOptimalSolution(int[] array) {

        int n = array.length;
        int[] ans = new int[n];
        ArrayList<Integer> list = new ArrayList<Integer>(n);
        int currentLeader = array[n - 1];
        ans[n - 1] = currentLeader;
        list.add(currentLeader);
        int idx = n - 2;

        for (int i = n - 2; i >= 0; i--) {
            if (array[i] >= currentLeader){
                ans[idx] = array[i];
                list.add(array[i]);
                currentLeader = array[i];
                idx--;
            }
        }
        Collections.reverse(list);
        System.err.println("List : "+list);
        return Arrays.copyOfRange(ans, idx + 1, n);
    }
}
