package org.akm.array.multidimensional;

/*
    - You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
    - You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
        DO NOT allocate another 2D matrix and do the rotation.

    Ex : 1
        I/P  : [[1,2,3],[4,5,6],[7,8,9]]
        O/P  : [[3,6,9],[2,5,8],[1,4,7]]
    Ex : 2
        I/P  : [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
        O/P  : [[11,10,7,16],[9,8,6,12],[1,4,3,14],[5,2,13,15]]

    Explanation:
        - To rotate the image by 90 degrees anti-clockwise, we can follow these steps:
            1. Transpose the matrix: Swap the elements at position (i, j) with the elements at position (j, i).
            2. Reverse each column: After transposing, reverse each column to get the final rotated image.
        - This approach allows us to rotate the image in-place without using any additional space for another matrix.
 */
public class RotateImageAntiClockwise {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int rows = matrix.length;
        int cols = matrix[0].length;

        System.out.println("Original Matrix : "+ java.util.Arrays.deepToString(matrix));
        transpose(matrix, rows, cols);
        reverseColumns(matrix, rows, cols);
        System.out.println("Result Matrix : "+ java.util.Arrays.deepToString(matrix));
    }

    private static void transpose(int[][] matrix, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private static void reverseColumns(int[][] matrix, int rows, int cols) {
        for (int i = 0; i < cols; i++) {
            int top = 0;
            int bottom = rows - 1;

            while (top < bottom) {
                int temp = matrix[top][i];
                matrix[top][i] = matrix[bottom][i];
                matrix[bottom][i] = temp;

                top++;
                bottom--;
            }
        }
    }
}
