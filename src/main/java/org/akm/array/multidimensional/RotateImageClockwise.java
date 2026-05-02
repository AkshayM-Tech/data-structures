package org.akm.array.multidimensional;

import java.util.Arrays;

/*
    --> LeetCode: 48. Rotate Image
    - You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
    - You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
        DO NOT allocate another 2D matrix and do the rotation.

    Ex : 1
        I/P : [[1,2,3],[4,5,6],[7,8,9]]
        O/P : [[7,4,1],[8,5,2],[9,6,3]]
    Ex : 2
        I/P : [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
        O/P : [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

    Explanation:
        - To rotate the image by 90 degrees clockwise, we can follow these steps:
            1. Transpose the matrix: Swap the elements at position (i, j) with the elements at position (j, i).
            2. Reverse each row: After transposing, reverse each row to get the final rotated image.
        - This approach allows us to rotate the image in-place without using any additional space for another matrix.
*/
public class RotateImageClockwise {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int rows = matrix.length;
        int cols = matrix[0].length;

        System.out.println("Original Matrix : "+ Arrays.deepToString(matrix));
        transpose(matrix, rows, cols);
        reverseRows(matrix, rows, cols);
        System.out.println("Result Matrix : "+ Arrays.deepToString(matrix));
    }

    private static void transpose(int[][] matrix, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = i + 1; j < cols; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private static void reverseRows(int[][] matrix, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            int low = 0;
            int high = cols - 1;

            while (low < high) {
                int temp = matrix[i][low];
                matrix[i][low] = matrix[i][high];
                matrix[i][high] = temp;
                low++;
                high--;
            }
        }
    }
}
