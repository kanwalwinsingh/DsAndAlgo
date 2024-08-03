package LeetCode;

public class RemoveNthFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        //Initialize two pointers, both starting at dummy node
        ListNode current = dummy;
        ListNode prev = dummy;
        for(int i =0; i<=n; i++){
            current = current.next;
        }

        while (current!=null){
            current = current.next;
            prev = prev.next;

        }
        prev.next = prev.next.next;
        return head;
    }

    public static void main(String[] args) {
        RemoveNthFromEndOfList removeNthFromEndOfList = new RemoveNthFromEndOfList();
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);
        System.out.println(removeNthFromEndOfList.removeNthFromEnd(l,2));
    }
}
