package nikhil_lohia;

public class IsLinkedListContainsPalindrome {
    public boolean isPalindrome(ListNode head){
        if(head == null || head.next == null){
            return true;
        }

        //Step 1: Find the middle of the linked list
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //Step2: Reverse the second half of the linked list
        ListNode secondHalf = reverseList(slow);
        ListNode firstHalf = head;

        //Step 3: Compare the first half and the reverse second half;
        while (secondHalf != null){
            if(firstHalf.val != secondHalf.val){
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode head){
        ListNode prev = null;
        while (head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        IsLinkedListContainsPalindrome solution = new IsLinkedListContainsPalindrome();

        // Create a palindrome linked list: 1 -> 2 -> 2 -> 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(2);
        head1.next.next.next.next = new ListNode(1);
        System.out.println(solution.isPalindrome(head1));  // Output: true

        // Create a non-palindrome linked list: 1 -> 2
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        System.out.println(solution.isPalindrome(head2));  // Output: false
    }
}
