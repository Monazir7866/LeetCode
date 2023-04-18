// You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.

// Return the merged string.

 

// Example 1:

// Input: word1 = "abc", word2 = "pqr"
// Output: "apbqcr"
// Explanation: The merged string will be merged as so:
// word1:  a   b   c
// word2:    p   q   r
// merged: a p b q c r
// Example 2:

// Input: word1 = "ab", word2 = "pqrs"
// Output: "apbqrs"
// Explanation: Notice that as word2 is longer, "rs" is appended to the end.
// word1:  a   b 
// word2:    p   q   r   s
// merged: a p b q   r   s
// Example 3:

// Input: word1 = "abcd", word2 = "pq"
// Output: "apbqcd"
// Explanation: Notice that as word1 is longer, "cd" is appended to the end.
// word1:  a   b   c   d
// word2:    p   q 
// merged: a p b q c   d



class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder out = new StringBuilder();
        // declare pointers for both strings
        int p1 = 0;
        int p2 = 0;

        while (p1 < word1.length() || p2 < word2.length()) {
            // traverse and append to the output
            if (p1 < word1.length()) out.append(word1.charAt(p1));
            if (p2 < word2.length()) out.append(word2.charAt(p2));
            p1++;
            p2++;
        }

        return out.toString();
    }
}