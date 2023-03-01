// Given an array of integers nums, sort the array in ascending order and return it.

// You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.

 

// Example 1:

// Input: nums = [5,2,3,1]
// Output: [1,2,3,5]
// Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).
// Example 2:

// Input: nums = [5,1,1,2,0,0]
// Output: [0,0,1,1,2,5]
// Explanation: Note that the values of nums are not necessairly unique.


class Solution {
    public int[] sortArray(int[] nums) {
        quicksort(nums,0,nums.length-1);
        return nums;
    }
    public void quicksort(int[]nums,int l,int r){
        if(l<r){
            int pivot=quick(nums,l,r);
            quicksort(nums,l,pivot-1);
            quicksort(nums,pivot+1,r);
            
        }
    }
    public int quick(int[]arr,int low,int high){
        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (arr[i] <= pivot && i <= high - 1) {
                i++;
            }

            while (arr[j] > pivot && j >= low) {
                j--;
            }

            if (i < j){
                int t = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = t; 
            }
        }

        int t = arr[j]; 
        arr[j] = arr[low]; 
        arr[low] =t; 
        return j;
    }
}