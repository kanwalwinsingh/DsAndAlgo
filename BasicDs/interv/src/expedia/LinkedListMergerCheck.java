package expedia;

import LeetCode.ListNode;

import java.util.List;

public class LinkedListMergerCheck {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        //Step 1: Calculate lengths of both linked list
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);

        // Step 2: Align the starting point
        ListNode longer = lengthA > lengthB ? headA : headB;
        ListNode shorter = lengthA > lengthB ? headB : headA;
        int lengthDif = Math.abs(lengthA -lengthB);
        ListNode tempA = longer;
        for(int i = 0; i< lengthDif; i++){
            tempA = tempA.next;
        }
        while (tempA != null && shorter != null){
            if(tempA == shorter){
                return tempA;
            }
            tempA = tempA.next;
            shorter = shorter.next;
        }
        return null;
    }

    private int getLength(ListNode head){
        int length = 0;
        while (head != null){
            length++;
            head = head.next;
        }
        return length;
    }

    public static void main(String[] args) {
        // Create two linked lists that intersect
        // List A: 1 -> 2 -> 3 -> 4 -> 5
        // List B: 9 -> 4 -> 5 (intersection starts at node with value 4)
        ListNode common = new ListNode(4);
        common.next = new ListNode(5);

        ListNode listA = new ListNode(1);
        listA.next = new ListNode(2);
        listA.next.next = new ListNode(3);
        listA.next.next.next = common;

        ListNode listB = new ListNode(9);
        listB.next = common;

        LinkedListMergerCheck checker = new LinkedListMergerCheck();
        ListNode intersection = checker.getIntersectionNode(listA, listB);

        if (intersection != null) {
            System.out.println("Lists intersect at node with value: " + intersection.val);
        } else {
            System.out.println("Lists do not intersect.");
        }
    }
}
