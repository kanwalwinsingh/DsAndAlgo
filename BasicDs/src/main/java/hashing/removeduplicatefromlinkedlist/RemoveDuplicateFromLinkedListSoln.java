package main.java.hashing.removeduplicatefromlinkedlist;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateFromLinkedListSoln {
    public static LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head){
        Set<Integer> hashSet = new HashSet<>();
        LinkedListNode<Integer> prev = head;
        LinkedListNode<Integer> temp = head;
        while (temp != null){
            if(hashSet.contains(temp.data)){
                prev.next = temp.next;
            }else{
                hashSet.add(temp.data);
                prev = temp;
            }
            temp = temp.next;
        }
        return head;
    }
    public static void main(String args[]) {
        Integer[][] inputs = {
                {50, 10, 50, 10, 50},
                {-3, -4, 3, -3, -4, -7},
                {20, 20, 20, 20},
                {100, 100},
                {200}
        };

        for (int i = 0; i < inputs.length; i++) {
            LinkedList<Integer> inputLinkedList = new LinkedList<>();
            PrintList<Integer> printLinkedList = new PrintList<Integer>();
            inputLinkedList.createLinkedList(inputs[i]);

            System.out.print((i + 1) + ".\tInput linked list: ");
            printLinkedList.printListWithForwardArrow(inputLinkedList.head);

            System.out.print("\n\tLinked list without duplicates: ");
            printLinkedList.printListWithForwardArrow(removeDuplicates(inputLinkedList.head));
            System.out.println("\n"+ new String(new char[100]).replace('\0', '-'));
        }
    }
}
