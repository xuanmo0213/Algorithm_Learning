/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?

*/

//use two pointers and equation L_cycle = L_precycle + L_incycle, when two pointers first meet, slow pointer 
//already go L_precycle + L_incycle, so need L_precycle to reach the starting point of cycle.

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                ListNode dummy = head;
                while (dummy != slow){
                    slow = slow.next;
                    dummy = dummy.next;
                }
                return slow;
            }
        }
        return null;
        
    }
}
