import java.util.Stack;

// Given an encoded string, return its decoded string.

// The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

// You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

// The test cases are generated so that the length of the output will never exceed 105.

 

// Example 1:

// Input: s = "3[a]2[bc]"
// Output: "aaabcbc"
// Example 2:

// Input: s = "3[a2[c]]"
// Output: "accaccacc"
// Example 3:

// Input: s = "2[abc]3[cd]ef"
// Output: "abcabccdcdcdef"

class Solution {
    public String decodeString(String s) {
         Stack<Integer> stackNum = new Stack<>();
        Stack<String> stackString = new Stack<>();
        int k =0;

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c>=48 && c<=57)
                k = (k * 10) + (c - '0');
            else if(c=='['){
                stackNum.push(k);
                System.out.print(k);
                k = 0;
                stackString.push(String.valueOf(c));
            }
            else if(c>=97 && c<=122){
                stackString.push(String.valueOf(c));
            }
            else if (c==']'){
                String str = "";
                while(true){
                    String temp = stackString.pop();
                    if(temp.equals("["))
                        break;
                    str = temp+str;
                }
                int num = stackNum.pop();
                String s1 ="";
                for(int j=0;j<num;j++){
                    s1 +=str;
                }
                stackString.push(s1);
            }
        }
        String res="";
        while(!stackString.isEmpty()){
            res=stackString.pop()+res;
        }
        return res;

    }
}