// Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

 

// Example 1:


// Input: root = [1,2,2,3,4,4,3]
// Output: true
// Example 2:


// Input: root = [1,2,2,null,3,null,3]
// Output: false




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
// class Solution {
//     public boolean isSymmetric(TreeNode root) {
//        if (root == null){
//            return true;
//        }
//        return check(root.left, root.right);
//    }

//    boolean check(TreeNode node1, TreeNode node2) {
//        if (node1 == null && node2 == null){
//            return true;
//        }
//        if (node1 == null || node2 == null || node1.val != node2.val){
//            return false;
//        }
//        return check(node1.left, node2.right) && check(node1.right, node2.left);
//    }
// }