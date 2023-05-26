// public Alice and Bob continue their games with piles of stones.  There are a number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].  The objective of the game is to end with the most stones. 

// Alice and Bob take turns, with Alice starting first.  Initially, M = 1.

// On each player's turn, that player can take all the stones in the first X remaining piles, where 1 <= X <= 2M.  Then, we set M = max(M, X).

// The game continues until all the stones have been taken.

// Assuming Alice and Bob play optimally, return the maximum number of stones Alice can get.

 

// Example 1:

// Input: piles = [2,7,9,4,4]
// Output: 10
// Explanation:  If Alice takes one pile at the beginning, Bob takes two piles, then Alice takes 2 piles again. Alice can get 2 + 4 + 4 = 10 piles in total. If Alice takes two piles at the beginning, then Bob can take all three piles left. In this case, Alice get 2 + 7 = 9 piles in total. So we return 10 since it's larger. 
// Example 2:

// Input: piles = [1,2,3,4,5,100]
// Output: 104 



class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] prefixSum = new int[n];
        prefixSum[n - 1] = piles[n - 1];
        
        for (int i = n - 2; i >= 0; i--) {
            prefixSum[i] = prefixSum[i + 1] + piles[i];
        }
        
        int[][] memo = new int[n][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        
        return dfs(piles, prefixSum, memo, 0, 1);
    }
     private int dfs(int[] piles, int[] prefixSum, int[][] memo, int i, int M) {
        if (i == piles.length) {
            return 0;
        }
        
        if (2 * M >= piles.length - i) {
            return prefixSum[i];
        }
        
        if (memo[i][M] != -1) {
            return memo[i][M];
        }
        
        int maxStones = 0;
        for (int x = 1; x <= 2 * M; x++) {
            int remainingStones = prefixSum[i] - dfs(piles, prefixSum, memo, i + x, Math.max(M, x));
            maxStones = Math.max(maxStones, remainingStones);
        }
        
        memo[i][M] = maxStones;
        return maxStones;
    }
}