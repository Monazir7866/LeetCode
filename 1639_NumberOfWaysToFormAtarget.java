// You are given a list of strings of the same length words and a string target.

// Your task is to form target using the given words under the following rules:

// target should be formed from left to right.
// To form the ith character (0-indexed) of target, you can choose the kth character of the jth string in words if target[i] = words[j][k].
// Once you use the kth character of the jth string of words, you can no longer use the xth character of any string in words where x <= k. In other words, all characters to the left of or at index k become unusuable for every string.
// Repeat the process until you form the string target.
// Notice that you can use multiple characters from the same string in words provided the conditions above are met.

// Return the number of ways to form target from words. Since the answer may be too large, return it modulo 109 + 7.

 

// Example 1:

// Input: words = ["acca","bbbb","caca"], target = "aba"
// Output: 6
// Explanation: There are 6 ways to form target.
// "aba" -> index 0 ("acca"), index 1 ("bbbb"), index 3 ("caca")
// "aba" -> index 0 ("acca"), index 2 ("bbbb"), index 3 ("caca")
// "aba" -> index 0 ("acca"), index 1 ("bbbb"), index 3 ("acca")
// "aba" -> index 0 ("acca"), index 2 ("bbbb"), index 3 ("acca")
// "aba" -> index 1 ("caca"), index 2 ("bbbb"), index 3 ("acca")
// "aba" -> index 1 ("caca"), index 2 ("bbbb"), index 3 ("caca")
// Example 2:

// Input: words = ["abba","baab"], target = "bab"
// Output: 4
// Explanation: There are 4 ways to form target.
// "bab" -> index 0 ("baab"), index 1 ("baab"), index 2 ("abba")
// "bab" -> index 0 ("baab"), index 1 ("baab"), index 3 ("baab")
// "bab" -> index 0 ("baab"), index 2 ("baab"), index 3 ("baab")
// "bab" -> index 1 ("abba"), index 2 ("baab"), index 3 ("baab")

class Solution {
    public int numWays(String[] words, String target) {
        int N = words.length;
        int W = words[0].length(); 
        int T = target.length();
        int[][] freq = new int[W][26];
        for (int i = 0; i < W; i++) {
            for (int j = 0; j < N; j++) {
                int let = words[j].charAt(i) - 'a';
                freq[i][let]++;
            }
        }
        long[][] dp = new long[T + 1][W + 1];
        for (int i = 0; i <= W; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < T; i++) {
            char tar = target.charAt(i);
            for (int j = 0; j < W; j++) {
                int num = freq[j][tar - 'a'];
                dp[i + 1][j + 1] = (dp[i + 1][j] + (dp[i][j] * num) % 1000000007) % 1000000007;
            }
        }
        return (int)dp[T][W];
    }
}