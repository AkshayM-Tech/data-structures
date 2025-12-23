package org.akm.array;

import java.util.Arrays;

/*
    Given two sorted arrays nums1 and nums2 of size m and n respectively,
    return the median of the two sorted arrays.
    The overall run time complexity should be O(log (m+n)).

    Ex :
        Input: nums1 = [1,3], nums2 = [2]
        Output: 2.00000
        Explanation: merged array = [1,2,3] and median is 2.
        Example 2:

        Input: nums1 = [1,2], nums2 = [3,4]
        Output: 2.50000
        Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
*/
public class MedianOfTwoSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {1,3,5,6};
        int[] nums2 = {2,4};

        System.err.println(findMedianSortedArrays_01(nums1, nums2));
        System.err.println(findMedianSortedArrays_02(nums1, nums2));
    }

    private static double findMedianSortedArrays_01(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int[] mergedArray = new int[len];
        int idx = 0;

        for (int num : nums1){
            mergedArray[idx++] = num;
        }

        for (int num : nums2){
            mergedArray[idx++] = num;
        }

        System.err.println("Before Merged Array : "+Arrays.toString(mergedArray));
        Arrays.sort(mergedArray);
        System.err.println("After Merged Array : "+Arrays.toString(mergedArray));

        if (len % 2 == 0){
            return (double) (mergedArray[(len / 2) - 1] + mergedArray[len / 2]) / 2;
        } else {
            return mergedArray[len / 2];
        }
    }

    private static double findMedianSortedArrays_02(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int[] mergedArray = new int[len];
        int i = 0, j = 0, k = 0;

        while (i < m && j < n){
            if (nums1[i] < nums2[j]){
                mergedArray[k++] = nums1[i];
                i++;
            } else {
                mergedArray[k++] = nums2[j];
                j++;
            }
        }

        while (i < m) {
            mergedArray[k++] = nums1[i];
            i++;
        }

        while (j < n) {
            mergedArray[k++] = nums2[j];
            j++;
        }

        if (len % 2 == 0){
            return (double) (mergedArray[(len / 2) - 1] + mergedArray[len / 2]) / 2;
        }else {
            return mergedArray[len / 2];
        }
    }
}
