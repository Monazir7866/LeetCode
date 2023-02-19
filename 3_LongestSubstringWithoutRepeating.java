// Given a string s, find the length of the longest 
// substring
//  without repeating characters.

 

// Example 1:

// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.
// Example 2:

// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
// Example 3:

// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        int left =0,right=0;
        int res=0;
        int stringLength = s.length();
        while(right<stringLength)
        { 
           char ch = s.charAt(right);
            if(map.containsKey(ch))
            left = Math.max(map.get(ch)+1,left);
            map.put(ch,right);
            res=Math.max(res,(right-left+1));
            right++;
        }
        return res;
    }
}