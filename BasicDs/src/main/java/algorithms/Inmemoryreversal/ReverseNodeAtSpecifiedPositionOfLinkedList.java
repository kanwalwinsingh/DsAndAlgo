package main.java.algorithms.Inmemoryreversal;

import main.java.PrintList;
import main.java.linkedlist.LinkedList;
import main.java.linkedlist.LinkedListNode;

import java.util.Collections;


public class ReverseNodeAtSpecifiedPositionOfLinkedList {
    //Function to reverse the sublist within the linked list
    public static LinkedListNode<Integer> reverseBetween(LinkedListNode<Integer> head, int left, int right){
        if(head == null || left == right){
            return head;
        }
        LinkedListNode<Integer> dummy = new LinkedListNode<>(0);
        dummy.next = head;
        LinkedListNode<Integer> prev = dummy;
        for(int i = 0; i< left-1; i++){
            prev = prev.next;
        }
        LinkedListNode<Integer> curr = prev.next;
        for(int i =0; i< right-left; i++){
            LinkedListNode<Integer> nextNode = curr.next;
            curr.next = nextNode.next;
            nextNode.next = prev.next;
            prev.next = nextNode;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        Integer[][] input = {
                {1, 2, 3, 4, 5, 6, 7},
                {6, 9, 3, 10, 7, 4, 6},
                {6, 9, 3, 4},
                {6, 2, 3, 6, 9},
                {6, 2}
        };
        int[] left = {1, 3, 2, 1, 1};
        int[] right = {5, 6, 4, 3, 2};
        for(int i=0; i<input.length; i++){
            System.out.print(i+1);
            LinkedList<Integer> list = new LinkedList<Integer>();
            list.createLinkedList(input[i]);
            System.out.print(".\tOriginal linked list:  ");
            PrintList.printListWithForwardArrow(list.head);
            System.out.print("\tLeft: " + left[i] + ", Right: " + right[i] + "\n\n");
            System.out.print("\tReversed linked list:  " );
            PrintList.printListWithForwardArrow(reverseBetween(list.head,left[i],right[i]));
            System.out.println(Collections.nCopies(100,"-"));
        }
    }
}
