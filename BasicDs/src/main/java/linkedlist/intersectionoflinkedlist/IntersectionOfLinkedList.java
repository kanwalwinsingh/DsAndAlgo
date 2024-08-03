package main.java.linkedlist.intersectionoflinkedlist;

import main.java.linkedlist.LinkedList;
import main.java.linkedlist.LinkedListNode;
import main.java.linkedlist.PrintList;

import java.util.HashSet;

public class IntersectionOfLinkedList {
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

//            System.out.println("\n\n\tUnion: ");
//            LinkedListNode<Integer> unionResult = union(inputLinkedList1.head, inputLinkedList3.head);
//            printLinkedList.printListWithForwardArrow(unionResult);

            System.out.println("\n\tIntersection: ");
            LinkedListNode<Integer> intersectionResult = intersection(inputLinkedList2.head, inputLinkedList3.head);
            printLinkedList.printListWithForwardArrow(intersectionResult);

            System.out.println("\n\tIntersection using hashing: ");
            LinkedListNode<Integer> intersectionResult1 = intersectionUsingHashing(inputLinkedList2.head, inputLinkedList3.head);
            printLinkedList.printListWithForwardArrow(intersectionResult1);

            System.out.println("\n");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    private static <T> LinkedListNode<T> intersectionUsingHashing(LinkedListNode<T> head1, LinkedListNode<T> head2) {
        LinkedListNode<T> result = null;
        LinkedListNode<T> tempNode1 = head1;

        while (tempNode1!=null){
            LinkedListNode<T> tempNode2 = head2;
            while (tempNode2!=null){
                if(tempNode1.data.equals(tempNode2.data) && !existInResult(tempNode1.data,result)){
                    result = insertAtHead(result, tempNode1.data);
                }
                tempNode2 = tempNode2.next;
            }
            tempNode1 = tempNode1.next;
        }
        return result;
    }

    public static <T> boolean existInResult(T data, LinkedListNode<T> head1){
        LinkedListNode<T> current = head1;
        while (current!=null){
            if(current.data.equals(data))
                return true;
            current = current.next;
        }
        return false;
    }

    public static <T> LinkedListNode<T> insertAtHead(LinkedListNode<T> head, T data){
        LinkedListNode<T> newNode = new LinkedListNode<>(data);
        newNode.next = head;
        return newNode;
    }

    static LinkedListNode<Integer> intersection(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2){
        LinkedListNode<Integer> result = null;
        HashSet<Integer> visitedNode = new HashSet<>();
        while (head1!=null){
            visitedNode.add(head1.data);
            head1 = head1.next;
        }
        while (head2!=null){
            if(visitedNode.contains(head2.data)){
                result = insertAtHead(result, head2.data);
                visitedNode.remove(head2.data);
            }
            head2 = head2.next;
        }
        return result;
    }
}
