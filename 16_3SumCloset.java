import java.util.Arrays;

// Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

// Return the sum of the three integers.

// You may assume that each input would have exactly one solution.

 

// Example 1:

// Input: nums = [-1,2,1,-4], target = 1
// Output: 2
// Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
// Example 2:

// Input: nums = [0,0,0], target = 1
// Output: 0
// Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).



class Solution
{
    public int threeSumClosest(int[] nums, int target) 
    {
        Arrays.sort(nums);
        int sum=0;
        int temp=0;
        int max = Integer.MAX_VALUE;
        int res=Integer.MAX_VALUE;
        int out=0;
        for (int i = 0; i < nums.length-1; i++)
        {
           int j=i+1;
           int k= nums.length-1;
           while(j<k)
           {
                sum = nums[i] + nums[j] + nums[k];
               temp = Math.abs((sum - target));
               if (temp < res)
               {
                   res = temp;
                   out = sum; 
               }
               if (max<temp)
               {
                   j++;
                   k= nums.length-1;
                   max=Integer.MAX_VALUE;
               }
               else
               {
                   k--;
                   max = temp;
               }
           }
           if (out==target) break;  
        }
        return out;  
    }
}