package nikhil_lohia;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
 */
public class RemoveDuplicatesFromTheLinkedlist {
    public ListNode deleteDuplicates(ListNode head){
        if(head == null){
            return null;
        }
        ListNode temp = head;
        while (temp != null && temp.next != null){
            if(temp.val == temp.next.val){
                temp.next = temp.next.next;
            }else{
            temp = temp.next;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        RemoveDuplicatesFromTheLinkedlist solution = new RemoveDuplicatesFromTheLinkedlist();

        // Create a sorted linked list: 1 -> 1 -> 2 -> 3 -> 3
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);

        // Delete duplicates
        ListNode result = solution.deleteDuplicates(head);

        // Print the result: 1 -> 2 -> 3
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }}
}
