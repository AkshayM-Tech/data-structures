package org.akm.array.multidimensional;

/**
    Write a program to find the sum of all the elements in a 2D array.

    Ex : 1
        I/P : [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
        O/P : 45
    Ex : 2
        I/P : [[1, 2], [3, 4], [5, 6]]
        O/P : 21
 */
public class SumOf2DArray {
    public static void main(String[] args) {
        int[][][] input = {{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, {{1, 2}, {3, 4}, {5, 6}}};

        for (int[][] array : input) {
            System.out.println("Sum of 2D Array : " + sumOf2DArray(array));
        }
    }

    private static int sumOf2DArray(int[][] array) {
        int rows = array.length;
        int columns = array[0].length;
        int sum = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sum += array[i][j];
            }
        }
        return sum;
    }
}
