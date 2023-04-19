

// You are given the root of a binary tree.

// A ZigZag path for a binary tree is defined as follow:

// Choose any node in the binary tree and a direction (right or left).
// If the current direction is right, move to the right child of the current node; otherwise, move to the left child.
// Change the direction from right to left or from left to right.
// Repeat the second and third steps until you can't move in the tree.
// Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).

// Return the longest ZigZag path contained in that tree.

 

// Example 1:


// Input: root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]
// Output: 3
// Explanation: Longest ZigZag path in blue nodes (right -> left -> right).
// Example 2:


// Input: root = [1,1,1,null,1,null,null,1,1,null,1]
// Output: 4
// Explanation: Longest ZigZag path in blue nodes (left -> right -> left -> right).
// Example 3:

// Input: root = [1]
// Output: 0


// Solution




/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

//  class Solution {
//     int MAX;
//     Map<TreeNode, int []> dp;
//     public int longestZigZag(TreeNode root) {
        
      
//         dp = new HashMap<>();
//         dfs(root);
//         return MAX;
//     }
//     private void dfs(TreeNode root){
//         if(root == null) return;

//         if(root.left == null && root.right == null){
//             dp.put(root, new int[]{0,0});
//             return;
//         }
      
//         dfs(root.left);
//         dfs(root.right);

//         int left = 0, right = 0;

//         if(dp.get(root.left) != null)
//             left = 1 + dp.get(root.left)[1]; 
        
//         if(dp.get(root.right) != null)
//             right = 1 + dp.get(root.right)[0]; 
//         dp.put(root, new int[]{left, right});
//         MAX = Math.max(MAX, Math.max(left,right));
//     }
// }