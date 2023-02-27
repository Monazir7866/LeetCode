// Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

// Letters are case sensitive, for example, "Aa" is not considered a palindrome here.

 

// Example 1:

// Input: s = "abccccdd"
// Output: 7
// Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
// Example 2:

// Input: s = "a"
// Output: 1
// Explanation: The longest palindrome that can be built is "a", whose length is 1.


class Solution {
    public int longestPalindrome(String s) {
        
        int[] c = new int[256];
        for(char ch : s.toCharArray()){
            c[ch]++;
        }
        boolean one = false;
        int length = 0;
        for(int i : c){
            if(i%2 == 0)
               length += i;
            else{
                length += i-1;
                one = true;
            }
        }
        if(one)
           return length+1;
           else 
           return length;
    }
}