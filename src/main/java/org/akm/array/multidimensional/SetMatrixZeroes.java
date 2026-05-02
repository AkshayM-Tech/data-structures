package org.akm.array.multidimensional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
    --> LeetCode - 73 : Set Matrix Zeroes
    - Given an m x n integer matrix, if an element is 0, set its entire row and column to 0's.
    - You must do it in place.

    Ex:1
        I/P : [[1, 1, 1], [1, 0, 1], [1, 1, 1]]
        O/P : [[1, 0, 1], [0, 0, 0], [1, 0, 1]]
        Explanation: The element at position (1, 1) is 0, so we set its entire row and column to 0's.
 */
public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] arr01 = {{1, 1, 1}, {1, 0, 1}}; // {{1, 0, 0}, {1, 1, 1}, {1, 1, 0}};
        int[][] arr02 = {{1, 1, 1}, {1, 0, 1}}; // {{1, 0, 0}, {1, 1, 1}, {1, 1, 0}};
        int[][] arr03 = {{0,1,2,0},{3,4,5,2},{1,3,1,5}}; // {{1, 1, 1}, {1, 0, 1}}; // {{1, 0, 0}, {1, 1, 1}, {1, 1, 0}};

        // using set to store the row and column index which has 0, then set the entire row and column to 0
        setMatrixZeroesBruteForce01(arr01);

        // using two arrays to store the row and column index which has 0, then set the entire row and column to 0
        setMatrixZeroesBruteForce02(arr02);

        /* using the first row and first column of the matrix itself to store the row and column index which has 0,
            then set the entire row and column to 0 */
        setMatrixZeroesOptimal(arr03);
    }

    private static void setMatrixZeroesBruteForce01(int[][] arr) {
        System.err.println("******************************************************************");
        System.err.println("Original Array-01 : "+Arrays.deepToString(arr));
        int rows = arr.length;
        int cols = arr[0].length;

        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }

        System.err.println("Row Set-01 : "+rowSet);
        System.err.println("Col Set-01 : "+colSet);

        for (int row : rowSet) {
            int i = 0;
            while (i < cols) {
                arr[row][i] = 0;
                i++;
            }
        }

        for (int col : colSet) {
            int j = 0;
            while (j < rows) {
                arr[j][col] = 0;
                j++;
            }
        }

        System.err.println("Result Array-01 : "+Arrays.deepToString(arr));
        System.err.println("******************************************************************");
    }

    private static void setMatrixZeroesBruteForce02(int[][] arr) {
        System.err.println("******************************************************************");
        System.err.println("Original Array-02 : "+Arrays.deepToString(arr));

        int rows = arr.length;
        int cols = arr[0].length;
        int[] row = new int[rows];
        int[] col = new int[cols];

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if(arr[i][j] == 0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        System.err.println("row-02 : "+Arrays.toString(row));
        System.err.println("col-02 : "+Arrays.toString(col));

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    arr[i][j] = 0;
                }
            }
        }
        System.err.println("Result Array-02 : "+Arrays.deepToString(arr));
        System.err.println("******************************************************************");
    }

    private static void setMatrixZeroesOptimal(int[][] arr) {
        System.err.println("******************************************************************");
        System.err.println("Original Array-03 : "+Arrays.deepToString(arr));

        int rows = arr.length;
        int cols = arr[0].length;
        boolean firstRow = false;
        boolean firstColumn = false;

        // Check if the first row has any zero
        for (int i = 0; i < cols; i++) {
            if(arr[0][i] == 0) {
                firstRow = true;
                break;
            }
        }

        // Check if the first column has any zero
        for (int j = 0; j < rows; j++){
            if(arr[j][0] == 0) {
                firstColumn = true;
                break;
            }
        }

        // Use the first row and column to mark the zeroes
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (arr[i][j] == 0) {
                    arr[i][0] = 0;
                    arr[0][j] = 0;
                }
            }
        }

        // Set 0's based on markers
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (arr[i][0] == 0 || arr[0][j] == 0) {
                    arr[i][j] = 0;
                }
            }
        }

        // Handle first row
        if (firstRow) {
            for (int i = 0; i < cols; i++) {
                arr[0][i] = 0;
            }
        }

        // Handle first column
        if (firstColumn) {
            for (int j = 0; j < rows; j++) {
                arr[j][0] = 0;
            }
        }

        System.err.println("Result Array-03 : "+Arrays.deepToString(arr));
        System.err.println("******************************************************************");
    }
}
