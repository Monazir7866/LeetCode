// Given the root of a binary tree, return the maximum width of the given tree.

// The maximum width of a tree is the maximum width among all levels.

// The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level are also counted into the length calculation.

// It is guaranteed that the answer will in the range of a 32-bit signed integer.

 

// Example 1:


// Input: root = [1,3,2,5,3,null,9]
// Output: 4
// Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).
// Example 2:


// Input: root = [1,3,2,5,null,null,9,6,null,7]
// Output: 7
// Explanation: The maximum width exists in the fourth level with length 7 (6,null,null,null,null,null,7).
// Example 3:


// Input: root = [1,3,2,5]
// Output: 2
// Explanation: The maximum width exists in the second level with length 2 (3,2).




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
//     public int widthOfBinaryTree(TreeNode root) {
//         Queue<TreeNode> q=new LinkedList<>();
//         root.val=1;
//         int ans=1;
//         q.add(root);
//         while(!q.isEmpty()){
//             Queue<TreeNode> q2=new LinkedList<>();
//             int f=-1,l=-1;
//             while(!q.isEmpty()){
//                 TreeNode ft=q.poll();
//                 if(f==-1)f=ft.val;
//                 l=ft.val;
//                 if(ft.left!=null){
//                     ft.left.val=ft.val*2;
//                     q2.add(ft.left);
//                 }
//                 if(ft.right!=null){
//                     ft.right.val=ft.val*2+1;
//                     q2.add(ft.right);
//                 }
//             }
//             q=q2;
//             ans=Math.max(ans,l-f+1);
//         }
//         return ans;
//     }
// }