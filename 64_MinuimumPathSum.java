import java.util.Arrays;

// Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

// Note: You can only move either down or right at any point in time.

 

// Example 1:


// Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
// Output: 7
// Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
// Example 2:

// Input: grid = [[1,2,3],[4,5,6]]
// Output: 12

class Solution {
    public int f(int i , int j , int[][] grid,int n , int m , int[][] dp) {
        if(i == n-1 && j == m-1) return grid[i][j]; 
        if(i == n || j== m) return (int)1e9;
        if(dp[i][j] != -1) return dp[i][j];
        int right = grid[i][j] + f(i,j+1,grid,n,m,dp);
        int down = grid[i][j] + f(i+1,j,grid,n,m,dp);
        return dp[i][j] = Math.min(right,down);

    }
    public int minPathSum(int[][] grid) {
        int n = grid.length,m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int[] d : dp) Arrays.fill(d,-1);
        return f(0,0,grid,n,m,dp);
    }
}