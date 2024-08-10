package LeetCode;

import java.util.List;

public class RemoveNthFromEnd {
    public static ListNode solution(ListNode head, int n){
        if(head == null){
            return head;
        }
        ListNode current = head;
        int count = 0;
        while (current!=null){
            count++;
            current = current.next;
        }
        if(count<n){
            return null;
        }
        if(count == n){
            return head.next;
        }
        current = head;
        for(int i = 0; i<(count-1)-n; i++){
           current = current.next;
        }
        current.next = current.next.next;
        return head;
    }



    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        ListNode n = solution(node,5);
        System.out.println(n);

    }

}
