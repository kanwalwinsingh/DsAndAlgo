package expedia;

import LeetCode.ListNode;

public class AddOneTotheLinkedList {
    public ListNode addOne(ListNode head){
        if(head == null) return new ListNode(1);
        // Step 1 reverse the linked list
        ListNode reverseHead = reverse(head);

        //Step 2 : Add one to the reverese list
        ListNode current = reverseHead;
        int carry = 1; // we need to add 1
        ListNode prev = null;
        while (current != null && carry > 0){
            int sum = current.val + carry;
            current.val = sum %10;
            carry = sum/10;
            prev = current;
            current = current.next;
        }
        if(carry > 0){
            prev.next = new ListNode(carry);
        }

        //Step 3 : Reverse the list again
        return reverse(reverseHead);
    }

    //Helper method to reverse a linked list
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode current = head;
        while (current != null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        // Example usage
        // Create linked list 1 -> 2 -> 3 representing the number 321
        ListNode head = new ListNode(9);
        head.next = new ListNode(9);
        head.next.next = new ListNode(9);

        AddOneTotheLinkedList solution = new AddOneTotheLinkedList();
        ListNode newHead = solution.addOne(head);

        // Print result
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
        // Output should be 1 -> 2 -> 4 representing the number 324
    }
}
