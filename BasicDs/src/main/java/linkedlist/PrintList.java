package main.java.linkedlist;

// Template for printing the linked list with forward arrows
public  class PrintList<T>
{
    public void printListWithForwardArrow(LinkedListNode<T> head)
    {
        if(head==null){
            return;

            
        }
        LinkedListNode<T> temp = head;
        System.out.print("\t");
        while (temp != null) {
            System.out.print(temp.data); // print node value
            temp = temp.next;
            if (temp != null) {
                System.out.print(" → ");
            }
        }
        // if this is the last node, print null at the end
        System.out.print(" → null ");
    }
}