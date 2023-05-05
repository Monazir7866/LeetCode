// Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

// Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

 

// Example 1:

// Input: s = "abciiidef", k = 3
// Output: 3
// Explanation: The substring "iii" contains 3 vowel letters.
// Example 2:

// Input: s = "aeiou", k = 2
// Output: 2
// Explanation: Any substring of length 2 contains 2 vowels.
// Example 3:

// Input: s = "leetcode", k = 3
// Output: 2
// Explanation: "lee", "eet" and "ode" contain 2 vowels.



class Solution {
    private boolean isVowel(char c) {
      return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
  
    public int maxVowels(String s, int k) {
      int c = 0, max = 0;
  
      for (var i=0; i < s.length(); i++) {
        if (isVowel(s.charAt(i))) c++;
        if (i >= k && isVowel(s.charAt(i-k))) c--;
        
        max = Math.max(max, c);
      }
      return max;
    }
  }