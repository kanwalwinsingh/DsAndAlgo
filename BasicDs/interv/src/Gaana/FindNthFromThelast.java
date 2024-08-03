package Gaana;

public class FindNthFromThelast {
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Creating a linked list 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Linked List:");
        printList(head);

        int n = 2; // Find the 2nd node from the end
        ListNode result = findNthFromEnd(head, n);
        if (result != null) {
            System.out.println("The " + n + "-th node from the end is: " + result.value);
        } else {
            System.out.println("The list has fewer than " + n + " elements.");
        }
    }

    private static ListNode findNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }
        ListNode firstPointer = head;
        ListNode secondPointer = head;
        for(int i =0; i< n; i++){
            if(firstPointer == null){
                return null;
            }
            firstPointer = firstPointer.next;
        }
        while (firstPointer != null){
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
        }
        return secondPointer;
    }
}
