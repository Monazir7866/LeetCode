import java.util.LinkedList;
import java.util.Queue;

// You are given an m x n grid where each cell can have one of three values:

// 0 representing an empty cell,
// 1 representing a fresh orange, or
// 2 representing a rotten orange.
// Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

// Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 

// Example 1:


// Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
// Output: 4
// Example 2:

// Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
// Output: -1
// Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
// Example 3:

// Input: grid = [[0,2]]
// Output: 0
// Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.


class Solution {
    class Pair{
        int row,col,time;
        Pair(int row,int col,int time){
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }
    public int orangesRotting(int[][] grid) {
          int n = grid.length;
        int m = grid[0].length;
        Queue < Pair > q = new LinkedList < > ();
        int[][] vis = new int[n][m];
        int cntFresh = 0;
    
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < m; j++) {
            if (grid[i][j] == 2) {
              q.add(new Pair(i, j, 0));
              vis[i][j] = 2;
            }
            else {
              vis[i][j] = 0;
            }
            if (grid[i][j] == 1) cntFresh++;
          }
        }
    
        int tm = 0;
        int drow[] = {-1, 0, +1, 0};
        int dcol[] = {0, 1, 0, -1}; 
        int cnt = 0;
        while (!q.isEmpty()) {
          int r = q.peek().row;
          int c = q.peek().col;
          int t = q.peek().time;
          tm = Math.max(tm, t);
          q.remove();
          for (int i = 0; i < 4; i++) {
            int nrow = r + drow[i];
            int ncol = c + dcol[i];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
              vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
              q.add(new Pair(nrow, ncol, t + 1));
              vis[nrow][ncol] = 2;
              cnt++;
            }
          }
        }
        if (cnt != cntFresh) return -1;
        return tm;
}
}