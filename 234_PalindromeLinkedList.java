// Given the head of a singly linked list, return true if it is a 
// palindrome
//  or false otherwise.

 

// Example 1:


// Input: head = [1,2,2,1]
// Output: true
// Example 2:


// Input: head = [1,2]
// Output: false



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
// class Solution {
//     public ListNode Middle(ListNode head){
//         ListNode slow = head;
//         ListNode fast = head;
//         while(fast!=null && fast.next != null){
//             slow = slow.next;
//             fast = fast.next.next;
//         }
//         return slow;
//     }
//     public boolean isPalindrome(ListNode head) {
//         if(head == null|| head.next == null){
//             return true;
//         }
//         ListNode mid = Middle(head);
//         ListNode curr= mid;
//         ListNode prev = null;
//         ListNode next;
//         while(curr!=null){
//             next = curr.next;
//             curr.next = prev;
//             prev = curr;
//             curr = next;
//         }
//         ListNode right = prev;
//         ListNode left = head;
//         while(right !=null){
//             if(left.val != right.val){
//                 return false;
//             }
//             right = right.next;
//             left = left.next;
//         }
//         return true;
//     }
// }