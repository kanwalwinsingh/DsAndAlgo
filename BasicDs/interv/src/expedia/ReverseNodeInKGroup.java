package expedia;

import LeetCode.ListNode;

import java.util.List;

public class ReverseNodeInKGroup {

    public ListNode reverseKGroups(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy, prev = dummy, next = dummy;
        int count = 0;
        //Count the number of nodes in the linked list
        while (curr.next != null) {
            curr = curr.next;
            count++;
        }

        //Iterate over the linked list and reverse every k nodes
        while (count >= k) {
            curr = prev.next;
            next = curr.next;
            for (int i = 1; i < k; i++) {
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }
            prev = curr;
            count -= k;
        }
        return dummy.next;
    }

    public ListNode reverseKGroupRecursive(ListNode head, int k) {
        if (head == null) return null;
        ListNode current = head;
        int count = 0;

        //Count k nodes from the head
        while (count < k && current != null) {
            current = current.next;
            count++;
        }
        //If we counted k nodes, reverse them
        if (count == k) {
            ListNode reversedhead = reverse(head, k);

        // Recursively call for the next group and connect the reversed path to the result of next groups
        head.next = reverseKGroups(current, k);
        return reversedhead;
    }
        // if less than k nodes are remaining, return the head as is
        return head;
    }

    private ListNode reverse(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        while (k-- >0){
            ListNode next = curr.next;
            curr.next = prev;
            prev  = curr;
            curr = next;
        }
        return prev;
    }

    // Utility function to print the linked list
    public void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ReverseNodeInKGroup list = new ReverseNodeInKGroup();

        // Creating a linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        System.out.println("Original List:");
        list.printList(head);

        int k = 3;
        ListNode newHead = list.reverseKGroupRecursive(head, k);

        System.out.println("Reversed List in groups of " + k + ":");
        list.printList(newHead);
    }

}
