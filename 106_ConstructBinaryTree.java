// Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

 

// Example 1:


// Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
// Output: [3,9,20,null,null,15,7]
// Example 2:

// Input: inorder = [-1], postorder = [-1]
// Output: [-1]




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
//     Map<Integer,Integer> map = new HashMap<>();
//     int index = 0;
    
//     private void generateMap(int[] inorder){
//         for(int i=0;i<inorder.length;i++){
//             map.put(inorder[i],i);
//         }
//         index=inorder.length-1;
//     }
//     private TreeNode solve(int[] inorder, int[] postorder,int start,int end){
//         if(start>end || index<0){
//             return null;
//         }
        
//         int e=postorder[index--];
//         TreeNode ans = new TreeNode(e);
//         int pos = map.get(e);
        
//         ans.right = solve(inorder,postorder,pos+1,end);
//         ans.left = solve(inorder,postorder,start,pos-1);
        
//         return ans;
//     }
    
//     public TreeNode buildTree(int[] inorder, int[] postorder) {
//         generateMap(inorder);
//         TreeNode ans = solve(inorder,postorder,0,postorder.length-1);
//         return ans;
//     }
// }