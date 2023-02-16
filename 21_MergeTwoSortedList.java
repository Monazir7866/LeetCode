// You are given the heads of two sorted linked lists list1 and list2.

// Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

// Return the head of the merged linked list.

 

// Example 1:


// Input: list1 = [1,2,4], list2 = [1,3,4]
// Output: [1,1,2,3,4,4]
// Example 2:

// Input: list1 = [], list2 = []
// Output: []
// Example 3:

// Input: list1 = [], list2 = [0]
// Output: [0]



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

//  solution
// class Solution {
//     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
          
//         ListNode head = new ListNode(0);
        
//         if(list1 == null && list2 == null){
//            return null;
//         } 
//         if(list1 == null) {
//             return list2;
//         }
//         if(list2 == null){ 
//             return list1;
//         }
//         if(list1.val > list2.val) { 
//             head = list2;
//             list2 = list2.next;
//         }
//         else {
//             head = list1;
//             list1 = list1.next;
//         }
        
//         head.next = mergeTwoLists(list1, list2);
//         return head;
//     }

//     @Override
//     public String toString() {
//         return "Solution []";
//     }
// }