// Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.

 

// Example 1:

// Input: num = 38
// Output: 2
// Explanation: The process is
// 38 --> 3 + 8 --> 11
// 11 --> 1 + 1 --> 2 
// Since 2 has only one digit, return it.
// Example 2:

// Input: num = 0
// Output: 0


class Solution {
    public int addDigits(int num) {
        int temp = 0 ;
        temp = numnum(num);
        while(temp > 9){
           temp = numnum(temp);
        }
        return temp;
        
    }
    
    public int numnum(int num){
      int temp = 0;
      while(num > 9){
            temp += num % 10 ;
            num /= 10;
        }
        return temp + num;
    }
}