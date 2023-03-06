import java.util.HashMap;

// You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

// Return the length of the longest substring containing the same letter you can get after performing the above operations.

 

// Example 1:

// Input: s = "ABAB", k = 2
// Output: 4
// Explanation: Replace the two 'A's with two 'B's or vice versa.
// Example 2:

// Input: s = "AABABBA", k = 1
// Output: 4
// Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
// The substring "BBBB" has the longest repeating letters, which is 4.

class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer>map=new HashMap<>();
        int start=0;
        int maxCountRepeatingCh=0;
        int maxLength=0;
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            maxCountRepeatingCh=Math.max(maxCountRepeatingCh,map.get(s.charAt(i)));

            while(i-start+1-maxCountRepeatingCh>k){
                map.put(s.charAt(start),map.get(s.charAt(start))-1);
                start++;
            }
            maxLength=Math.max(maxLength,i-start+1);

        }
        return maxLength;
    }
}