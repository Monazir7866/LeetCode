// Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.

// Return the kth positive integer that is missing from this array.

 

// Example 1:

// Input: arr = [2,3,4,7,11], k = 5
// Output: 9
// Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
// Example 2:

// Input: arr = [1,2,3,4], k = 2
// Output: 6
// Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.


class Solution {
    public int findKthPositive(int[] arr, int k) {
        int max = arr.length - 1;
        int min = 0;
        int res = -1;
        while (max >= min) {
            int mid = (max + min) / 2;
            if (arr[mid] - mid - 1 >= k) {
                res = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        if (res == -1) {
            return arr[arr.length - 1] + (k - (arr[arr.length - 1] - arr.length));
        } else {
            return arr[res] - ((arr[res] - res - 1) - k + 1);
        }
    }
}