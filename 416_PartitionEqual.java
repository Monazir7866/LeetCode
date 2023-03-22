// Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.

 

// Example 1:

// Input: nums = [1,5,11,5]
// Output: true
// Explanation: The array can be partitioned as [1, 5, 5] and [11].
// Example 2:

// Input: nums = [1,2,3,5]
// Output: false
// Explanation: The array cannot be partitioned into equal sum subsets.


class Solution {
    Boolean mem[][];
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        
        for(int i : nums) sum+=i;
        
        if(sum%2!=0) return false;
        
        sum /= 2;
        
        mem = new Boolean[n+1][sum+1];
        
        return subsetSum(nums,0,sum);
    }
    
    boolean subsetSum(int[] nums, int pos, int sum){
        if(sum==0) return true;
        
        else if(pos>=nums.length || sum<0) return false;
        
        if(mem[pos][sum]!=null) return mem[pos][sum];
        
        return mem[pos][sum] = subsetSum(nums,pos+1,sum-nums[pos]) ||
                                subsetSum(nums,pos+1,sum);  
    }
}