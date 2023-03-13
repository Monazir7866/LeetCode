// Given the head of a linked list, return the list after sorting it in ascending order.

 

// Example 1:


// Input: head = [4,2,1,3]
// Output: [1,2,3,4]
// Example 2:


// Input: head = [-1,5,3,4,0]
// Output: [-1,0,3,4,5]
// Example 3:

// Input: head = []
// Output: []



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
//     public ListNode merge(ListNode h1, ListNode h2){
//        if(h1 == null){
//            return h2;
//        }
//        if(h2 == null){
//            return h1;
//        }
       
//        if(h1.val < h2.val){
//            h1.next = merge(h1.next, h2);
//            return h1;
//        }
//        else{
//            h2.next = merge(h1, h2.next);
//            return h2;
//        }
       
//    }
   
//    public ListNode sortList(ListNode head) {
      
//        if(head == null){
//            return head;
//        }
//        if(head.next == null){
//            return head;
//        }
       
//        ListNode p1 = head;
//        ListNode p2 = head;
//        ListNode pre = head;
       
//        while(p2 != null && p2.next != null){
//            pre = p1;
//            p1 = p1.next;
//            p2 = p2.next.next;
//        }
//        pre.next = null;
       
//        ListNode h1 = sortList(head);
//        ListNode h2 = sortList(p1);
       
//        return merge(h1, h2);
//    }   
// }