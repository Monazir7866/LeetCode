// Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

 

// Example 1:


// Input: root = [3,9,20,null,null,15,7]
// Output: [[3],[9,20],[15,7]]
// Example 2:

// Input: root = [1]
// Output: [[1]]
// Example 3:

// Input: root = []
// Output: []


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
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         List<List<Integer>> mainlist = new LinkedList<List<Integer>>();
//         Queue<TreeNode> list= new LinkedList<>();
//         if(root==null){
//             return mainlist;
//         }
//         list.add(root);
//         while(!list.isEmpty()){
//             int n=list.size();
//             List<Integer> l=new LinkedList<Integer>();
//             for(int i=0;i<n;i++){
//                 TreeNode cur=list.poll();
//                 l.add(cur.val);
//                 if(cur.left!=null){
//                     list.add(cur.left);
//                 }
//                 if(cur.right!=null){
//                     list.add(cur.right);
//                 }
//             }
//             mainlist.add(l);
//         }
//         return mainlist;        
//     }
// }