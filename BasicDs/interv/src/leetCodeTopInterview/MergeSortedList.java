package leetCodeTopInterview;

import LeetCode.ListNode;

public class MergeSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(n == 0){
            return null;
        }
        return mergeKLists(lists,n-1);
    }

    public ListNode sortedMerge(ListNode list1, ListNode list2){
        ListNode result = null;
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val<= list2.val){
            result = list1;
            result.next = sortedMerge(list1.next,list2);
        }else{
            result = list2;
            result.next = sortedMerge(list2.next,list1);
        }
        return result;
    }

    public ListNode mergeKLists(ListNode[] listNodes, int last){
        // loop through all the list until there is only list left
        while (last != 0){
            int i = 0, j = last;
            while (i<j){
                listNodes[i] = sortedMerge(listNodes[i],listNodes[j]);
                i++;
                j--;

                if(i>=j){
                    last = j;
                }
            }
        }
        return listNodes[0];
    }

    /* Function to print ListNodes in a given linked list */
    public static void printList(ListNode ListNode)
    {
        while (ListNode != null) {
            System.out.print(ListNode.val + " ");
            ListNode = ListNode.next;
        }
    }

    public static void main(String args[])
    {
        int k = 3; // Number of linked lists
        int n = 4; // Number of elements in each list

        // an array of pointers storing the head ListNodes
        // of the linked lists
        ListNode arr[] = new ListNode[k];

        arr[0] = new ListNode(1);
        arr[0].next = new ListNode(3);
        arr[0].next.next = new ListNode(5);
        arr[0].next.next.next = new ListNode(7);

        arr[1] = new ListNode(2);
        arr[1].next = new ListNode(4);
        arr[1].next.next = new ListNode(6);
        arr[1].next.next.next = new ListNode(8);

        arr[2] = new ListNode(0);
        arr[2].next = new ListNode(9);
        arr[2].next.next = new ListNode(10);
        arr[2].next.next.next = new ListNode(11);

        MergeSortedList m = new MergeSortedList();
        // Merge all lists
        ListNode head = m.mergeKLists(arr, k - 1);
        printList(head);
    }
}
