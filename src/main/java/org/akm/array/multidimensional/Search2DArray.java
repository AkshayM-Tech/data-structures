package org.akm.array.multidimensional;

/*
    Write a program to search an element in a 2D array. The program should take the 2D array and the element to be
    searched as input and return the indices of the element if found, or indicate that the element is not present
    in the array.

    Ex : 1
        I/P : [[1,2,3], [4,5,6], [7,8,9]], 5
        O/P : Element found at index : [1][1]
    Ex : 2
        I/P : [[1,2,3], [4,5,6], [7,8,9]], 10
        O/P : Element not found in the array.
 */
public class Search2DArray {
    public static void main(String[] args) {
        int[][] array = {{1,2,3}, {4,5,6}, {7,8,9}};
        int target = 10;

        searchElementIn2DArray(array, target);
    }

    private static void searchElementIn2DArray(int[][] array, int target) {
        int row = array.length, col = array[0].length;
        boolean found = false;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (array[i][j] == target) {
                    System.out.println("Element found at index : ["+i+"]["+j+"]");
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
            System.out.println("Element not found in the array.");
        }
    }
}
