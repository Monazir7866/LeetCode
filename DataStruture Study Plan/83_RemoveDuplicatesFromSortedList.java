// Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

 

// Example 1:


// Input: head = [1,1,2]
// Output: [1,2]
// Example 2:


// Input: head = [1,1,2,3,3]
// Output: [1,2,3]



// Solution



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

//  class Solution {
//     public ListNode deleteDuplicates(ListNode head) {
//         if (head == null)
//             return null;
//         ListNode tmp = head;
//         ListNode tmpT = head;
//         while (tmp.next != null)
//         {
//             if (tmp.next.val == tmp.val) {
//                 tmpT = tmp;
//                 while (tmpT.next != null && tmpT.next.val == tmpT.val)
//                     tmpT = tmpT.next;
//                 tmp.next = tmpT.next;
//             }
//             if (tmp.next != null) tmp = tmp.next;
//         }

//         return head;
//     }
// }