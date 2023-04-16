// Given the root of a binary search tree and an integer k, return true if there exist two elements in the BST such that their sum is equal to k, or false otherwise.

 

// Example 1:


// Input: root = [5,3,6,2,4,null,7], k = 9
// Output: true
// Example 2:


// Input: root = [5,3,6,2,4,null,7], k = 28
// Output: false


// solution



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
//     public boolean findTarget(TreeNode root, int k) {
//         if (root == null) return false;
//         List<Integer> list = new ArrayList<>();
//         inorder(root, list);
//         int i = 0, j = list.size() - 1;
//         while (i < j) {
//             int sum = list.get(i) + list.get(j);
//             if (sum == k) return true;
//             else if (sum < k) i++;
//             else j--;
//         }
//         return false;
//     }
    
//     private void inorder(TreeNode root, List<Integer> list) {
//         if (root == null) return;
//         inorder(root.left, list);
//         list.add(root.val);
//         inorder(root.right, list);
//     }
// }