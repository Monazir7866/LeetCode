// Given two strings s and t, determine if they are isomorphic.

// Two strings s and t are isomorphic if the characters in s can be replaced to get t.

// All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

 

// Example 1:

// Input: s = "egg", t = "add"
// Output: true
// Example 2:

// Input: s = "foo", t = "bar"
// Output: false
// Example 3:

// Input: s = "paper", t = "title"
// Output: true

class Solution {
    public boolean isIsomorphic(String s, String t) {

        int bag1[]=new int[200];
        int bag2[]=new int[200];

        if(s.length()!=t.length())
            return false;

        for(int i=0;i<s.length();i++)
        {
            if(bag1[s.charAt(i)]!=bag2[t.charAt(i)])
                return false;
            bag1[s.charAt(i)]=i+1;
            bag2[t.charAt(i)]=i+1;
        }
        return true;
    }
}