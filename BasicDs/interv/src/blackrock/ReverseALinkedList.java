package blackrock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseALinkedList {

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public Node head;

    public void insertAtHead(int data){
        Node node = new Node(data);
        if(head == null){
            head = node;
        }else {
            node.next = head;
            head = node;
        }
    }

    public Node reverseALinkedList(Node head){
        Node current = head;
        Node prev = null;
        Node next = head;
        while (current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public void printlist(Node head){
        Node tep = head;
        //System.out.print("null");
        while (tep!=null){

            System.out.print(tep.data+"-> ");
            tep = tep.next;
        }
        System.out.println();
        System.out.println("-------------------");
    }

    public static void main(String[] args) {
        ReverseALinkedList  list = new ReverseALinkedList();
        list.insertAtHead(4);
        list.insertAtHead(3);
        list.insertAtHead(2);
        list.insertAtHead(1);
        list.printlist(list.head);
        Node temp = list.reverseALinkedList(list.head);
        list.printlist(temp);
        final List<String> str = new ArrayList<String>(Arrays.asList("abc", "def", "ghi"));
        str.add("jkl");

    }
}

















