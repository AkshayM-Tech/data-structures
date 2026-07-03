package searching.binary;

import java.util.Arrays;

/*
    --> Leet Code : 162 - Find Peak Element
    - A peak element is an element that is strictly greater than its neighbors.
    - Given a 0-indexed integer array nums, find a peak element, and return its index.
      If the array contains multiple peaks, return the index to any of the peaks.

    Ex:1
        I/P : [1, 2, 3, 1]
        O/P : 2
        Explanation : 3 is a peak element and your function should return the index number 2.

    Ex:2
        I/P : [1, 2, 1, 3, 5, 6, 4]
        O/P : 5
        Explanation : Your function can return either index number 1 where the peak element is 2,
                        or index number 5 where the peak element is 6.
    Ex:3
        I/P : [1, 2]
        O/P : 1
        Explanation : Here if we check circular connection then 2 is the peak number which greater than its neighbors.

    Ex:4
        I/P : [1]
        O/P : 0
        Explanation : There is no elements left to compare its neighbor so 0th element will be the peak element.
 */
public class FindPeakElement {
    public static void main(String[] args) {
        int[][] data = {
                {1, 2, 3, 1},
                {1, 2, 1, 3, 5, 6, 4},
                {1, 2},
                {1}
        };

        for (int[] array : data) {
            System.err.println("I/P : "+ Arrays.toString(array)+" ,O/P : "+findPeakElement(array));
        }
    }

    private static int findPeakElement(int[] array) {
        int n = array.length;

        for (int i = 1; i < n; i++) {
            if (array[i] > array[i - 1] && array[i] > array[(i + 1) % n]) {
                return i;
            }
        }
        return 0;
    }
}
