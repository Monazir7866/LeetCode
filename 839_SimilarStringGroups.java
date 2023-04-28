// Two strings X and Y are similar if we can swap two letters (in different positions) of X, so that it equals Y. Also two strings X and Y are similar if they are equal.

// For example, "tars" and "rats" are similar (swapping at positions 0 and 2), and "rats" and "arts" are similar, but "star" is not similar to "tars", "rats", or "arts".

// Together, these form two connected groups by similarity: {"tars", "rats", "arts"} and {"star"}.  Notice that "tars" and "arts" are in the same group even though they are not similar.  Formally, each group is such that a word is in the group if and only if it is similar to at least one other word in the group.

// We are given a list strs of strings where every string in strs is an anagram of every other string in strs. How many groups are there?

 

// Example 1:

// Input: strs = ["tars","rats","arts","star"]
// Output: 2
// Example 2:

// Input: strs = ["omv","ovm"]
// Output: 1



class Solution {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        boolean[] visited = new boolean[n];
        int groups = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, strs, visited);
                groups++;
            }
        }
        return groups;
    }
    
    private void dfs(int i, String[] strs, boolean[] visited) {
        visited[i] = true;
        String s = strs[i];
        for (int j = 0; j < strs.length; j++) {
            if (!visited[j] && isSimilar(s, strs[j])) {
                dfs(j, strs, visited);
            }
        }
    }
    
    private boolean isSimilar(String s1, String s2) {
        int n = s1.length();
        int diff = 0;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
                if (diff > 2) {
                    return false;
                }
            }
        }
        return true;
    }
}