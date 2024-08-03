package LeetCode;

public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode node = new ListNode();
        ListNode current = node;
        while (list1!=null && list2!=null){
            if (list1.val <=list2.val){
                current.next = list1;
                list1 = list1.next;
            }else{
                current.next =  list2;
                list2 = list2.next;
            }
            current = current.next;
        }while (list1!=null){
            current.next =  list1;
            list1 = list1.next;
            current = current.next;
        }while (list2!=null){
            current.next = list2;
            list2 = list2.next;
            current = current.next;
        }
        return node.next;
    }

    void printList(ListNode n){
        while (n!=null){
            System.out.println(n.val);
            n = n.next;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(4);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);
        MergeTwoSortedList m = new MergeTwoSortedList();
        ListNode n = m.mergeTwoLists(node1,node2);
        m.printList(n);
    }
}
