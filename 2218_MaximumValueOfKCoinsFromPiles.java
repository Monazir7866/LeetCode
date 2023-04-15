import java.util.List;

// There are n piles of coins on a table. Each pile consists of a positive number of coins of assorted denominations.

// In one move, you can choose any coin on top of any pile, remove it, and add it to your wallet.

// Given a list piles, where piles[i] is a list of integers denoting the composition of the ith pile from top to bottom, and a positive integer k, return the maximum total value of coins you can have in your wallet if you choose exactly k coins optimally.

 

// Example 1:


// Input: piles = [[1,100,3],[7,8,9]], k = 2
// Output: 101
// Explanation:
// The above diagram shows the different ways we can choose k coins.
// The maximum total we can obtain is 101.
// Example 2:

// Input: piles = [[100],[100],[100],[100],[100],[100],[1,1,1,1,1,1,700]], k = 7
// Output: 706
// Explanation:
// The maximum total can be obtained if we choose all coins from the last pile.


class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        
        int[][] dp = new int[piles.size()+1][k+1];
        for (int i = 1; i <= piles.size(); i++){
            for (int j = 1; j <= k; j++){
                int sum = 0;
               
                dp[i][j] = dp[i-1][j];
                
                for (int h = 0; h < Math.min(j, piles.get(i-1).size()); h++){
                    
                    sum += piles.get(i-1).get(h);
                    dp[i][j] = Math.max(dp[i][j], sum + dp[i-1][j-1-h]);
                }
            }
        }
        return dp[piles.size()][k]; 
    }
}