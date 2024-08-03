package LeetCode;

public class CycleInLinkedList {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow!= fast){
            if(fast == null || fast.next==null){
                return false;
            }
            slow =slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        CycleInLinkedList c = new CycleInLinkedList();
        System.out.println(c.hasCycle(l));
    }
}
