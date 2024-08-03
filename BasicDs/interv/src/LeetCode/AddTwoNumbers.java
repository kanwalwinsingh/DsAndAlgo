package LeetCode;

public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
     int carry = 0;
     ListNode l3 = new ListNode(0);
     ListNode current = l3;
     while (l1!=null || l2 != null){
         //Get value from current nodes, default to 0 if null
         int x = (l1 != null) ? l1.val : 0;
         int y = (l2 != null) ? l2.val : 0;
         int sum = carry + x+ y;
         carry = sum/10;
         sum = sum%10;
         current.next = new ListNode(sum);
         current = current.next;
         if (l1 != null) l1 = l1.next;
         if (l2 != null) l2 = l2.next;
     }
        if(carry>0){
            current.next = new ListNode(carry);
        }
        return l3.next;
    }

    /* Function to print ListNodes in a given linked list */
    public static void printList(ListNode ListNode)
    {
        while (ListNode != null) {
            System.out.print(ListNode.val + " ");
            ListNode = ListNode.next;
        }
    }

    public static void main(String args[])
    {
        int k = 3; // Number of linked lists
        int n = 4; // Number of elements in each list

        // an array of pointers storing the head ListNodes
        // of the linked lists
        ListNode arr[] = new ListNode[k];

        arr[0] = new ListNode(2);
        arr[0].next = new ListNode(4);
        arr[0].next.next = new ListNode(3);

        arr[1] = new ListNode(5);
        arr[1].next = new ListNode(6);
        arr[1].next.next = new ListNode(4);

        arr[2] = new ListNode(0);
        arr[2].next = new ListNode(9);
        arr[2].next.next = new ListNode(10);
        arr[2].next.next.next = new ListNode(11);

        // Merge all lists
        ListNode head = addTwoNumbers(arr[0], arr[1]);
        printList(head);
    }

}
