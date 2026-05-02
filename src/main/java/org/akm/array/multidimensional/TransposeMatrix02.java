package org.akm.array.multidimensional;

import java.util.Arrays;

/*
    Write a program to transpose given matrix.

    Ex : 1
        I/P : {{1, 2, 3}, {4, 5, 6}};
        O/P : {{1, 4}, {2, 5}, {3, 6}}
 */
public class TransposeMatrix02 {
    public static void main(String[] args) {
        int[][] array = {{1, 2, 3}, {4, 5, 6}};
        int rows = array.length;
        int cols = array[0].length;

        System.out.println("Input Array : "+Arrays.deepToString(array));
        transposeMatrix(array, rows, cols);
    }

    private static void transposeMatrix(int[][] array, int rows, int cols) {
        int[][] transposedArray = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposedArray[j][i] = array[i][j];
            }
        }
        System.out.println("Transposed Matrix : "+ Arrays.deepToString(transposedArray));
    }
}
