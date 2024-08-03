package main.java.linkedlist.unionoflinkedlist;

import main.java.linkedlist.LinkedList;
import main.java.linkedlist.LinkedListNode;
import main.java.linkedlist.PrintList;

import java.util.HashSet;


public class UnionOfLinkedList {
    //Function for union of linkedList
    public static <T> LinkedListNode<T> union(LinkedListNode<T> head1, LinkedListNode<T> head2){
        if(head1 == null) return head2;
        if(head2 == null) return head1;
        LinkedListNode<T> current = head1;
        while (current.next !=null){
            current = current.next;
        }
        current.next = head2;
        removeDuplicates(head1);
        return head1;
    }

    public static <T> void removeDuplicates(LinkedListNode<T> head1){
        LinkedListNode<T> outerNode = head1;
        while (outerNode!=null){
            LinkedListNode<T> innerNode = outerNode;
            while (innerNode.next != null){
                if(outerNode.data.equals(innerNode.next.data)){
                    innerNode.next = innerNode.next.next;
                }else{
                    innerNode = innerNode.next;
                }
            }
            outerNode = outerNode.next;
        }
    }

    static LinkedListNode<Integer> unionUsingHashing(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2){
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        HashSet<Integer> visitedNode = new HashSet<>();
        LinkedListNode<Integer> result = null;
        while (head1 != null){
            visitedNode.add(head1.data);
            head1 = head1.next;
        }
        while (head2 != null){
            visitedNode.add(head2.data);
            head2 = head2.next;
        }
        for(int x : visitedNode){
            result = insertAtHead(result,x);
        }
        return result;
    }

    public static <T> LinkedListNode<T> insertAtHead(LinkedListNode<T> head, T data){
        LinkedListNode<T> newNode = new LinkedListNode<>(data);
        newNode.next = head;
        return newNode;
    }
    // Main method to run the program
    public static void main(String[] args) {
        Integer[][] unionList = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 1, 2, 2, 3, 3, 4, 4, 5},
                {-45, 34, -54, 45, -65, 54},
                {12},
                {0, 1, 2},
        };

        Integer[][] intersectionList = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 1, 2, 2, 3, 3, 4, 4, 5},
                {-45, 34, -54, 45, -65, 54},
                {12},
                {0, 1, 2},
        };

        Integer[][] inputList2 = {
                {7, 8, 9, 10, 11, 12, 13, 14},
                {1, 2, 3, 4, 5, 6},
                {3, 2, 1},
                {12},
                {3, 4, 5},
        };

        for (int i = 0; i < unionList.length; i++) {
            LinkedList<Integer> inputLinkedList1 = new LinkedList<>();
            LinkedList<Integer> inputLinkedList2 = new LinkedList<>();
            LinkedList<Integer> inputLinkedList3 = new LinkedList<>();

            PrintList<Integer> printLinkedList = new PrintList<Integer>();

            inputLinkedList1.createLinkedList(unionList[i]);
            inputLinkedList2.createLinkedList(intersectionList[i]);
            inputLinkedList3.createLinkedList(inputList2[i]);


            System.out.println((i + 1) + ".\tInput linked list 1: ");
            printLinkedList.printListWithForwardArrow(inputLinkedList1.head);

            System.out.println("\n\tInput linked list 2: ");
            printLinkedList.printListWithForwardArrow(inputLinkedList3.head);

            System.out.println("\n\n\tUnion: ");
            LinkedListNode<Integer> unionResult = unionUsingHashing(inputLinkedList1.head, inputLinkedList3.head);
            printLinkedList.printListWithForwardArrow(unionResult);

            System.out.println("\n\tIntersection: ");
//            LinkedListNode<Integer> intersectionResult = intersection(inputLinkedList2.head, inputLinkedList3.head);
//            printLinkedList.printListWithForwardArrow(intersectionResult);

            System.out.println("\n");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
