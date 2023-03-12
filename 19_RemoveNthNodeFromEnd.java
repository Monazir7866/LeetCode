// Given the head of a linked list, remove the nth node from the end of the list and return its head.

 

// Example 1:


// Input: head = [1,2,3,4,5], n = 2
// Output: [1,2,3,5]
// Example 2:

// Input: head = [1], n = 1
// Output: []
// Example 3:

// Input: head = [1,2], n = 1
// Output: [1]


// solution


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
// class Solution {
//     public ListNode removeNthFromEnd(ListNode head, int n) {
//         ListNode curr = head, pre = head;
//         for (int i = 0; i < n; i++) {
//             curr = curr.next;
//         }
//         if (curr == null) {
//             return head.next;
//         }
//         while (curr.next != null) {
//             curr = curr.next;
//             pre = pre.next;
//         }
//         pre.next = pre.next.next;
//         return head;
//     }
// }