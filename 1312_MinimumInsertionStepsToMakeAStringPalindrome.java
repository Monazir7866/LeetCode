// Given a string s. In one step you can insert any character at any index of the string.

// Return the minimum number of steps to make s palindrome.

// A Palindrome String is one that reads the same backward as well as forward.

 

// Example 1:

// Input: s = "zzazz"
// Output: 0
// Explanation: The string "zzazz" is already palindrome we do not need any insertions.
// Example 2:

// Input: s = "mbadm"
// Output: 2
// Explanation: String can be "mbdadbm" or "mdbabdm".
// Example 3:

// Input: s = "leetcode"
// Output: 5
// Explanation: Inserting 5 characters the string becomes "leetcodocteel".




class Solution {
    int [][] dp = new int[505][505];

    int solve(String s, int l, int r) {
        if(l >= r) return 0;
        if(dp[l][r] != -1) return dp[l][r];
        if(s.charAt(l) == s.charAt(r)) return dp[l][r] = solve(s, l + 1, r - 1);
        return dp[l][r] = 1 + Math.min(solve(s, l + 1, r), solve(s, l, r - 1));
    }

    public int minInsertions(String s) {
        for (int i = 0; i < 505; i++) {
            for (int j = 0; j < 505; j++) {
                dp[i][j] = -1;
            }
        }
        return solve(s, 0, s.length() - 1);
    }
}