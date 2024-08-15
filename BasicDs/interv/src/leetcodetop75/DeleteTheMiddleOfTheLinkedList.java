package leetcodetop75;

import LeetCode.ListNode;

/**
 * https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/?envType=study-plan-v2&envId=leetcode-75
 */
public class DeleteTheMiddleOfTheLinkedList {
    public ListNode deleteMiddle(ListNode head) {
        //Edge case if there only one node, return null
        if(head == null || head.next == null){
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        while (fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        //Delete the middle node by skipping it
        prev.next = slow.next;
        return head;
    }
}
