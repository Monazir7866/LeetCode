// Given the root of a binary tree, return the preorder traversal of its nodes' values.

 

// Example 1:


// Input: root = [1,null,2,3]
// Output: [1,2,3]
// Example 2:

// Input: root = []
// Output: []
// Example 3:

// Input: root = [1]
// Output: [1]



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
//     public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> integerList = new LinkedList<>();
//         integerList = preorderTraversal(root, integerList);
//         return integerList;
//     }

//     private List<Integer> preorderTraversal(TreeNode root, List<Integer> integerList) {
//         if (root == null) return integerList;

//         integerList.add(root.val);
//         preorderTraversal(root.left, integerList);
//         preorderTraversal(root.right, integerList);

//         return integerList;
//     }
// }