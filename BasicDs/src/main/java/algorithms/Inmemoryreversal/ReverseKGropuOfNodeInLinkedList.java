package main.java.algorithms.Inmemoryreversal;

import main.java.PrintList;
import main.java.linkedlist.LinkedList;
import main.java.linkedlist.LinkedListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseKGropuOfNodeInLinkedList {
    public static LinkedListNode<Integer> reversekGroups(LinkedListNode<Integer> head, int k){
        LinkedListNode<Integer> dummy = new LinkedListNode<>(0);
        dummy.next = head;
        LinkedListNode<Integer> ptr = dummy;
        while (ptr != null){
            LinkedListNode<Integer> tracker = ptr;
            for(int i =0; i<k; i++){
                if(tracker == null){
                    break;
                }
                tracker = tracker.next;
            }
            if(tracker == null){
                break;
            }
            LinkedListNode<Integer>[] updatadNode = reverseALinkedList(ptr.next,k);
            LinkedListNode<Integer> prev = updatadNode[0];
            LinkedListNode<Integer> curr = updatadNode[1];

            LinkedListNode lastNodeOfReverseGroup = ptr.next;
            lastNodeOfReverseGroup.next = curr;
            ptr.next = prev;
            ptr = lastNodeOfReverseGroup;
        }
        return dummy.next;
    }

    static LinkedListNode[] reverseALinkedList(LinkedListNode<Integer> node, int k){
        LinkedListNode<Integer> prev = null;
        LinkedListNode<Integer> next = null;
        LinkedListNode<Integer> curr = node;

        for (int  i =0; i<k; i++){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return new LinkedListNode[]{prev,curr};
    }

    public static void main(String[] args) {
        Integer[][] input = {
                {1, 2, 3, 4, 5, 6, 7, 8},
                {3, 4, 5, 6, 2, 8, 7, 7},
        {1, 2, 3, 4, 5},
            {1, 2, 3, 4, 5, 6, 7},
                {1}
        };

        List<Integer> k = new ArrayList<>(Arrays.asList(3, 2, 1, 7, 1));

        for (int i = 0; i < input.length; ++i) {
            LinkedList<Integer> inputLinkedList = new LinkedList<>();
            inputLinkedList.createLinkedList(input[i]);

            System.out.print((i + 1) + ".\tLinked list: ");
            PrintList.printListWithForwardArrow(inputLinkedList.head);
            System.out.println();

            System.out.print("\n\tReversed linked list: ");
            LinkedListNode result = reversekGroups(inputLinkedList.head, k.get(i));
            PrintList.printListWithForwardArrow(result);
            System.out.println();

            String hyphens = new String(new char[100]).replace('\0', '-');
            System.out.println(hyphens);
        }
    }

}
