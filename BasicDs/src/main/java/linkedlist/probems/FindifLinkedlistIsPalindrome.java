package main.java.linkedlist.probems;


import java.util.Stack;

public class FindifLinkedlistIsPalindrome {

    public static void main(String args[])
    {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(3);
        Node six = new Node(2);
        Node seven = new Node(1);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        boolean condition = isPalindromeUsingTwoPtr(one);
        System.out.println("isPalidrome :" + condition);
    }

    public static boolean isPalindromeUsingTwoPtr(Node head){
        Node slowptr = head, fastPtr = head;
        Node secondHalf;
        Node prevOfSlowptr = head;
        Node midNode = null; // To handle odd size list;
        boolean res = false; // initalize result
        if(head != null && head.next != null){
            while (fastPtr != null && fastPtr.next != null){
                fastPtr = fastPtr.next.next;
                prevOfSlowptr = slowptr;
                slowptr = slowptr.next;

            }
            /* fastPtr would become null when there are even element int the list
            and not null for odd ptr. we need to skip the middle node for odd case and store
            it somewhere so that we can restore it later
            *
            * */
            if(fastPtr != null){
                midNode = slowptr;
                slowptr = slowptr.next;
            }
            //Now reverse the second half and compare it with the firs half
            secondHalf = slowptr;
            prevOfSlowptr.next = null;
            secondHalf = reverse(secondHalf);
            res = compareList(head,secondHalf);
            // again revese the sowptr to make the original list
            secondHalf = reverse(secondHalf);
            if(midNode != null){
                prevOfSlowptr.next = midNode;
                midNode.next = secondHalf;
            }else{
                prevOfSlowptr = secondHalf;
            }
        }
        return res;
    }

    static Node reverse(Node head){
        Node prev = null, next = null;
        Node curr = head;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;

    }

    static boolean compareList(Node head1, Node head2){
        Node temp1 = head1;
        Node temp2 = head2;
        while (temp1 != null && temp2 != null){
            if(temp1.data != temp2.data)
                return false;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return true;
    }

    static boolean isPalindrome(Node head){
       Node slow = head;
       boolean isPalin = false;
        Stack<Integer> stack = new Stack<>();
        while (slow!=null){
            stack.push(slow.data);
            slow = slow.next;
        }
        while (head != null){
            int i = stack.pop();
            if(head.data != i){
                return  false;
            }
            head = head.next;
        }
        return true;
    }

    static class Node{
        int data;
        Node next;
        Node(int d){
            this.data = d;
            next = null;
        }
    }
}
