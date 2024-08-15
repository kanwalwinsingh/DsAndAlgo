package leetcodetop75;

import LeetCode.ListNode;
//https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/submissions/1352113356/?envType=study-plan-v2&envId=leetcode-75
public class MaximumTwinSumOfLinkedList {
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        //Step 1: Find the middle of the linked list
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //Step 2: Reverse the second half of the linekd list
        ListNode prev = null;
        ListNode current = slow;
        while (current != null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        //Step 3: Calculate the twin sum and find the max
        current = head;
        int maxValue = Integer.MIN_VALUE;
        while (prev != null){
            int currentSum = prev.val+ current.val;
            maxValue = Math.max(maxValue,currentSum);
            current = current.next;
            prev = prev.next;
        }
        return maxValue;
    }
}
