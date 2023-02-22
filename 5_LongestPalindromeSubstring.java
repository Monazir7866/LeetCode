// Given a string s, return the longest 
// palindromic
 
// substring
//  in s.

 

// Example 1:

// Input: s = "babad"
// Output: "bab"
// Explanation: "aba" is also a valid answer.
// Example 2:

// Input: s = "cbbd"
// Output: "bb"

class Solution {
    public String longestPalindrome(String s) {
        String str ="";
        int longest = 0;
        for(int i=0;i<s.length();i++){
            int left =i;
            int right = i;
            while(left>=0 && right<s.length() && s.charAt(left)== s.charAt(right)){
               if(right-left +1 > longest){
                   longest = right-left+1;
                   str = s.substring(left,right+1);
               }
                left--;
                right++;
            }
            left = i;
            right = i+1;
              while(left>=0 && right<s.length() && s.charAt(left)== s.charAt(right)){
               if(right-left +1 > longest){
                   longest = right-left+1;
                   str = s.substring(left,right+1);
               }
                left--;
                right++;
            }
        }
        return str;
    }
}