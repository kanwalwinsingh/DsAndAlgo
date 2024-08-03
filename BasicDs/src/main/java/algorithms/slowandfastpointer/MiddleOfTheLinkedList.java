package main.java.algorithms.slowandfastpointer;

import main.java.PrintList;
import main.java.linkedlist.LinkedList;
import main.java.linkedlist.LinkedListNode;

public class MiddleOfTheLinkedList {
    public static LinkedListNode<Integer> middleNode(LinkedListNode<Integer> head){
        LinkedListNode<Integer> slowPointer = head;
        LinkedListNode<Integer> fastPointer = head;
        while (fastPointer!=null && fastPointer.next!=null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;
    }
    public static void main( String args[] ) {

        Integer[][] input = {{1, 2, 3, 4, 5}, {1, 2, 3, 4, 5, 6}, {3, 2, 1}, {10}, {1, 2}};

        for(int i=0; i<input.length; i++){
            System.out.print(i+1);
            LinkedList<Integer> list = new LinkedList<Integer>();
            list.createLinkedList(input[i]);
            System.out.print(".\tInput linked list:  ");
            PrintList.printListWithForwardArrow(list.head);
            System.out.print("\tMiddle of the linked list is:  " );
            System.out.println(middleNode(list.head).data);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
