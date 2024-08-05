package nikhil_lohia;

public class SumOfTwoIntegersInLinkedlist {
    ListNode addSum(ListNode l1, ListNode l2){
        ListNode result = new ListNode();
        ListNode ptr = result;
        int carry  = 0;
        while (l1 != null && l2 != null){
            int sum = 0 + carry;
            if (l1 != null){
                sum+= l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                sum+= l2.val;
                l2 = l2.next;
            }
            carry = sum/10;
            sum = sum%10;
            ptr.next = new ListNode(sum);
            ptr = ptr.next;
        }
        if (carry == 1 ) ptr.next = new ListNode(1);
        return result.next;
    }
    public static void main(String[] args) {
        SumOfTwoIntegersInLinkedlist solution = new SumOfTwoIntegersInLinkedlist();

        // Create first linked list: 2 -> 4 -> 3 (represents 342)
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);


        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);

        // Add the two numbers
        ListNode result = solution.addSum(l1, l2);

        // Print the result (should represent 807: 7 -> 0 -> 8)
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
