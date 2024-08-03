package LeetCode;

import blackrock.ReverseALinkedList;

public class MergeKSortedList {


    public static ListNode mergeKLists(ListNode[] lists){
        int n = lists.length;
        if(n == 0 ) return null;
        return mergeKLists(lists,n-1);
    }

    public static ListNode sortedMerge(ListNode a, ListNode b){
        ListNode result = null;
        if(a == null){
            return b;
        }else if(b == null){
            return a;
        }
        // pick either a or b and rec
        if(a.val < b.val){
            result = a;
            result.next = sortedMerge(a.next,b);
        }else {
            result = b;
            result.next = sortedMerge(a,b.next);
        }
        return result;
    }

    public static ListNode mergeKLists(ListNode[] listListNodes, int last){
        //repeat only one list is left
        while (last!=0){
            int i =0, j = last;
            //(i,j) forms a pair
            while (i<j){
                //merge List i in with list j and store merge list in list i
                listListNodes[i] = sortedMerge(listListNodes[i],listListNodes[j]);
                //comsider next pair
                i++;
                j--;

                //If all pairs are merged, update last
                if(i>=j){
                    last = j;
                }
            }
        }
        return listListNodes[0];
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

        // Merge all lists
        ListNode head = mergeKLists(arr, k - 1);
        printList(head);
    }
}
