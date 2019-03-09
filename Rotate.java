package com.ap;

public class Rotate {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3,10},
                {4, 5, 6,11},
                {7, 8, 9,12},
                {13, 14, 15,16}
        };

        rotate(matrix);
    }

    /**
     * 解题思路，从最外层开始转，从4个角开始，每次转4个点，一层一层的转即可
     * @param matrix
     */
    public static void rotate(int[][] matrix) {
        int t;
        int n = matrix.length;
        for(int i = 0; i < n / 2; i++)
            for(int j = i; j < n - i - 1; j++){
                t = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 -j];
                matrix[n - 1 - i][n - 1 -j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = t;
            }
    }
}
