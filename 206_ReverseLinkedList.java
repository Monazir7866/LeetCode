// Given the head of a singly linked list, reverse the list, and return the reversed list.

 

// Example 1:


// Input: head = [1,2,3,4,5]
// Output: [5,4,3,2,1]
// Example 2:


// Input: head = [1,2]
// Output: [2,1]
// Example 3:

// Input: head = []
// Output: []


//Solution

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
//     public ListNode reverseList(ListNode head) {
//            if (head == null) {
//                 return null;
//                   }

//            ListNode node = head,
//             prev = null,
//             reverse= null;

//          while (node != null) {
//             final ListNode next = node.next;

//           if (node.next == null) {
//             reverse = node;
//              }
//             node.next = prev;
//             prev = node;
//             node = next;
//          }

//            return reverse;
//     }
// }