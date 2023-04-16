// In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a new one with a different size r x c keeping its original data.

// You are given an m x n matrix mat and two integers r and c representing the number of rows and the number of columns of the wanted reshaped matrix.

// The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.

// If the reshape operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.

 

// Example 1:


// Input: mat = [[1,2],[3,4]], r = 1, c = 4
// Output: [[1,2,3,4]]
// Example 2:


// Input: mat = [[1,2],[3,4]], r = 2, c = 4
// Output: [[1,2],[3,4]]

class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int curr_r = mat.length;
        int curr_c = mat[0].length;
        if(curr_r*curr_c != r*c || curr_r == r && curr_c==c){
            return mat;
        }
            int[][] result = new int[r][c];
            int new_c =0;
            int new_r =0;
            for(int i=0;i<curr_r;i++){
                for(int j =0;j<curr_c;j++){
                    if(new_c == c ){
                        new_r++;
                        new_c=0;
                    }
                    result[new_r][new_c++] = mat[i][j];
                }
            }
            return result;
    }
}