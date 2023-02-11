// Write a function to find the longest common prefix string amongst an array of strings.

// If there is no common prefix, return an empty string "".

 

// Example 1:

// Input: strs = ["flower","flow","flight"]
// Output: "fl"
// Example 2:

// Input: strs = ["dog","racecar","car"]
// Output: ""
// Explanation: There is no common prefix among the input strings.

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
             return "";
        } 
        String pre = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            int c = 0;
            while (c < pre.length()) {
                if (str.length() <= c || str.charAt(c) != pre.charAt(c)) {
                    pre = pre.substring(0, c);
                    break;
                }
                c++;
            }
        }
        return pre;
    }
}