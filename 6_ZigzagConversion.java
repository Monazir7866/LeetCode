// The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

// P   A   H   N
// A P L S I I G
// Y   I   R
// And then read line by line: "PAHNAPLSIIGYIR"

// Write the code that will take a string and make this conversion given a number of rows:

// string convert(string s, int numRows);
 

// Example 1:

// Input: s = "PAYPALISHIRING", numRows = 3
// Output: "PAHNAPLSIIGYIR"
// Example 2:

// Input: s = "PAYPALISHIRING", numRows = 4
// Output: "PINALSIGYAHRPI"
// Explanation:
// P     I    N
// A   L S  I G
// Y A   H R
// P     I
// Example 3:

// Input: s = "A", numRows = 1
// Output: "A"


class Solution {
    public String convert(String s, int numRows) {
        int size = s.length();
        if(size == 1 || numRows == 1 || numRows >= size) return s;
        StringBuffer res = new StringBuffer("");
        int diff1 = 2*(numRows - 1);
        int diff2 = 0;
        for(int i = 0; i<numRows; i++){
            int curr = i;
            boolean fst = true;
            while(curr < size){
                res.append(s.charAt(curr));
                if(fst && diff1 != 0 || !fst && diff2 == 0){
                    fst = !fst;
                    curr += diff1;
                } else {
                    fst = !fst;
                    curr += diff2;
                }
            }
            diff1 -= 2;
            diff2 += 2;
        }
        return res.toString();
    }
}