package nikhil_lohia;

public class SwapTwoNodesInLInkedList {
    public ListNode swapPairs(ListNode head){
        ListNode dummy  = new ListNode(0);
        dummy.next = head;
        ListNode ptr = dummy;
        while (ptr.next != null && ptr.next.next != null){
            ListNode swap1 = ptr.next;
            ListNode swap2 = ptr.next.next;

            swap1.next = swap2.next;
            swap2.next = swap1;
            ptr.next = swap2;
            ptr = swap1;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        SwapTwoNodesInLInkedList solution = new SwapTwoNodesInLInkedList();

        // Create a linked list: 1 -> 2 -> 3 -> 4
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        // Swap pairs
        ListNode result = solution.swapPairs(head);

        // Print the result (should be 2 -> 1 -> 4 -> 3)
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
