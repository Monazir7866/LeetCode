// Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

// Note that after backspacing an empty text, the text will continue empty.

 

// Example 1:

// Input: s = "ab#c", t = "ad#c"
// Output: true
// Explanation: Both s and t become "ac".
// Example 2:

// Input: s = "ab##", t = "c#d#"
// Output: true
// Explanation: Both s and t become "".
// Example 3:

// Input: s = "a#c", t = "b"
// Output: false
// Explanation: s becomes "c" while t becomes "b".

class Solution {
    public boolean backspaceCompare(String s, String t) {
        return backspace(t).equals(backspace(s));
    }
  
    public String backspace(String s){
        StringBuilder sb = new StringBuilder(s);
        int index = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '#') {
                index = Math.max(i - 2, -1);
                if (i == 0) sb.delete(0, 1);
                    else sb.delete(i - 1, i + 1);
                i = index;
            }
        }
        return sb.toString();
    }
}