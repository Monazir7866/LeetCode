import java.util.ArrayList;
import java.util.List;

// Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

// Example 1:

// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// Example 2:

// Input: nums = [0,1]
// Output: [[0,1],[1,0]]
// Example 3:

// Input: nums = [1]
// Output: [[1]]




class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>res=new ArrayList<>();
        solve(0,nums,res);
        return res;
    }
    public void solve(int ind,int[] nums,List<List<Integer>>res){
        if(ind==nums.length){
            ArrayList<Integer>arr=new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                arr.add(nums[i]);
            }
            res.add(new ArrayList<>(arr));
            return;
        }

        for(int i=ind;i<nums.length;i++){
            swap(i,ind,nums);
            solve(ind+1,nums,res);
            swap(i,ind,nums);
        }
    }

    public void swap(int i,int j,int[]nums){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

}