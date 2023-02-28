// Given the root of a binary tree, return all duplicate subtrees.

// For each kind of duplicate subtrees, you only need to return the root node of any one of them.

// Two trees are duplicate if they have the same structure with the same node values.

 

// Example 1:


// Input: root = [1,2,3,4,null,2,4,null,null,4]
// Output: [[2,4],[4]]
// Example 2:


// Input: root = [2,1,1]
// Output: [[1]]
// Example 3:


// Input: root = [2,2,2,3,null,3,null]
// Output: [[2,3],[3]]


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
//     public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
//         List<TreeNode> list=new ArrayList<>();
//         HashMap<String,Integer> map=new HashMap<>();
//         helper(list,root,map);
//         return list;
//     }
//     public String helper(List<TreeNode> list,TreeNode root,HashMap<String,Integer> map){
//         if(root==null)
//             return "";
//         String left=helper(list,root.left,map);
//         String right=helper(list,root.right,map);
//         int currroot=root.val;
//         String stringformed=currroot+"$"+left+"$"+right;
//         if(map.getOrDefault(stringformed,0)==1){
//             list.add(root);
//         }
//         map.put(stringformed,map.getOrDefault(stringformed,0)+1);
//         return stringformed;
//     }
// }