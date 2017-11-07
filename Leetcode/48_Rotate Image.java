/*
You are given an n x n 2D matrix representing an image.
Rotate the image in place by 90 degrees (clockwise).
*/
class Solution {
    public void rotate(int[][] matrix) {
        int row1 = 0;
        int row2 = matrix.length-1;
        while(row1<row2){
            swapRows(matrix,row1,row2);
            row1++;
            row2--;
        }
        for(int i = 0; i<matrix.length-1;i++){
            for(int j = matrix[0].length-1; j>i;j--){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    private void swapRows(int[][]matrix, int row1, int row2){
        int[] temp = Arrays.copyOf(matrix[row1], matrix[row1].length);
        matrix[row1] = matrix[row2];
        matrix[row2] = temp;
    }
}