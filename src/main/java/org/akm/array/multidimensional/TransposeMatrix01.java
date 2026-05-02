package org.akm.array.multidimensional;

import java.util.Arrays;

public class TransposeMatrix01 {
    public static void main(String[] args) {
        int[][] array = {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
        System.out.println("Before Array : "+Arrays.deepToString(array));
        int[][] transposedArray = transposeMatrix(array);
        System.out.println("After Array : "+Arrays.deepToString(array));
    }

    private static int[][] transposeMatrix(int[][] array) {
        int rows = array.length;
        int columns = array[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i < j) {
                    int temp = array[i][j];
                    array[i][j] = array[j][i];
                    array[j][i] = temp;
                }
            }
        }
        return array;
    }
}
