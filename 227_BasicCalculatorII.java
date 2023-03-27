import java.util.Stack;

// Given a string s which represents an expression, evaluate this expression and return its value. 

// The integer division should truncate toward zero.

// You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].

// Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

 

// Example 1:

// Input: s = "3+2*2"
// Output: 7
// Example 2:

// Input: s = " 3/2 "
// Output: 1
// Example 3:

// Input: s = " 3+5 / 2 "
// Output: 5


class Solution {
    public int calculate(String s) {

        Stack<Integer> stack = new Stack<>();
        int curNum = 0;
        char op = '+';

        for (int i = 0; i < s.length(); i++) {

            char chr = s.charAt(i);
            if (Character.isDigit(chr)) curNum = curNum * 10 + (chr-'0');

            if (!Character.isDigit(chr) && chr != ' ' || s.length()-1 == i) {
                if (op == '-') stack.push(-curNum);
                else if (op == '+') stack.push(curNum); 
                else if (op == '*') stack.push(stack.pop()*curNum);
                else if (op == '/') stack.push(stack.pop()/curNum);
                
                op = chr;
                curNum = 0;
            }
        }

        int res = 0;
        while (!stack.empty()) res += stack.pop();
        return res;
    }
}