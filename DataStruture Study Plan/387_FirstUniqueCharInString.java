// Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

 

// Example 1:

// Input: s = "leetcode"
// Output: 0
// Example 2:

// Input: s = "loveleetcode"
// Output: 2
// Example 3:

// Input: s = "aabb"
// Output: -1


class Solution {
    public int firstUniqChar(String s) {
        int l=s.length();
        int flag=0;
       for(int i=0;i<l;i++)
       {
           flag=0;
           char ch=s.charAt(i);
           for(int j=0;j<l;j++)
           {
               if(i==j)
                continue;
               if(ch==s.charAt(j))
                {
                    flag=1;
                    break;
                }
           }
           if(flag==0)
            return i;
       } 
       return -1;
    }
}