import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

// Notice that the solution set must not contain duplicate triplets.

 

// Example 1:

// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]
// Explanation: 
// nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
// nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
// nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
// The distinct triplets are [-1,0,1] and [-1,-1,2].
// Notice that the order of the output and the order of the triplets does not matter.
// Example 2:

// Input: nums = [0,1,1]
// Output: []
// Explanation: The only possible triplet does not sum up to 0.
// Example 3:

// Input: nums = [0,0,0]
// Output: [[0,0,0]]
// Explanation: The only possible triplet sums up to 0.

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for(int i=0;i<nums.length-2;i++){
           if(i==0 ||(i>0 && nums[i]!=nums[i-1])){
               int min=i+1;
               int max=nums.length-1;
               int sum=0-nums[i];
               while(min<max){
                   if(nums[min]+nums[max]==sum){
                       res.add(Arrays.asList(nums[i],nums[min],nums[max]));
                       while(min<max && nums[min]==nums[min+1])    min++;
                       while(min<max && nums[max]==nums[max-1])  max--;
                       min++;
                       max--;
                   }
                   else if(nums[min]+nums[max]<sum){
                       min++;
                   }
                   else{
                       max--;
                   }
               }
           }
       }
       return res; 
    }
}