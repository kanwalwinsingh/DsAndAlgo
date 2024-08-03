package nikhil_lohia;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode current = dummy;
        while (current.next !=null){
            if(current.next.val == val){
                current.next = current.next.next;
            }else {
                current = current.next;
            }
        }
        return dummy.next;
    }
    // Utility function to print the linked list
    public void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        RemoveLinkedListElements re = new RemoveLinkedListElements();

        // Creating a linked list: 1 -> 2 -> 6 -> 3 -> 4 -> 5 -> 6
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        System.out.println("Original List:");
        re.printList(head);

        // Removing all nodes with value 6
        head = re.removeElements(head, 6);

        System.out.println("Modified List:");
        re.printList(head);
    }

}
