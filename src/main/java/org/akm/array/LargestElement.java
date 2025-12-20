package org.akm.array;

/*
    Write a java program to find the largest element in a given array.
 */
public class LargestElement {
    public static void main(String[] args) {
        int[] array = {1,4,8,4,9,10,40,30,22};
        int largestElement = array[0];
        int index = 0;
        for (int i = 1; i < array.length; i++){
            if (array[i] > largestElement) {
                largestElement = array[i];
                index = i;
            }
        }
        System.err.println("Largest Element : "+largestElement);
        System.err.println("Largest Element Idx : "+index);
    }
}
