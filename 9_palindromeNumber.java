
// https://leetcode.com/problems/palindrome-number/description/

// Given an integer x, return true if x is a 
// palindrome
// , and false otherwise.


class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
       int num=x; 
       int sum=0;
       while(x!=0){
           sum=(sum*10)+(x%10);
           x=x/10;
       }
       return (sum==num);

    }
}
