// Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

 

// Example 1:

// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2,2]
// Example 2:

// Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// Output: [4,9]
// Explanation: [9,4] is also accepted.

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int freq1[] = new int[1001];
        int freq2[] = new int[1001];
        for(int i=0;i<nums1.length;i++){
            freq1[nums1[i]]++;
        }
        for(int i=0;i<nums2.length;i++){
            freq2[nums2[i]]++;
        }
        int freqres[] = new int[1001];
        int size=0;
        for(int i=0;i<1001;i++){
            freqres[i] = Math.min(freq1[i],freq2[i]);
            size+=freqres[i];
        }
        int res[] = new int[size];
        int pointer = 0;
        for(int i=0;i<1001;i++){
            while(freqres[i]!=0){
                res[pointer] = i;
                pointer++;
                freqres[i]--;
            }
        }
        return res;
    }
}