package org.akm.array.multidimensional;

import java.util.Arrays;

/*
    --> LeetCode : 2022. Convert 1D Array Into 2D Array
    - You are given a 0-indexed 1D integer array original, and two integers, m and n. You are tasked with creating a
    2D array with  m rows and n columns using all the elements from original.
    - Return an m x n 2D array constructed according to the above procedure, or an empty 2D array if it is impossible.

    Ex : 1
        I/P : [1,2,3,4], m = 2, n = 2
        O/P : [[1,2],[3,4]] --> The constructed 2D array should contain 2 rows and 2 columns.
    Ex : 2
        I/P : [1,2,3], m = 1, n = 3
        O/P : [[1,2,3]] --> The constructed 2D array should contain 1 row and 3 columns.
    Ex : 3
        I/P : [1,2], m = 1, n = 1
        O/P : [] --> There are 2 elements in original, but there is only space for 1 element in the constructed 2D array.
        Therefore, it is impossible to construct the 2D array, so we return an empty 2D array.
    Ex : 4
        I/P : [1,2,3,4,5,6], m = 2, n = 3
        O/P : [[1,2,3],[4,5,6]] --> The constructed 2D array should contain 2 rows and 3 columns.
*/
public class Convert1DInto2D {
    public static void main(String[] args) {
        Container[] input = {
                new Container(new int[]{1, 2, 3, 4}, 2, 2),
                new Container(new int[]{1, 2, 3}, 1, 3),
                new Container(new int[]{1, 2}, 1, 1),
                new Container(new int[]{1,2,3,4,5,6}, 2, 3)
        };

        for (Container container : input)
            System.out.println(Arrays.deepToString(construct2DArray(container.original, container.m, container.n)));
    }

    private static int[][] construct2DArray(int[] original, int m, int n) {
        if(original.length != m * n)
            return new int[][]{};

        int[][] result = new int[m][n];
        int index = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                result[i][j] = original[index++];
            }
        }
        return result;
    }
}

class Container{
    int[] original;
    int m;
    int n;

    public Container(int[] original, int m, int n) {
        this.original = original;
        this.m = m;
        this.n = n;
    }
}