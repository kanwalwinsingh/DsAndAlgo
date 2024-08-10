package microsoft;

public class DeepCopyLinkedList {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // Step 1: Clone the nodes
        Node current = head;
        while (current != null) {
            Node clonedNode = new Node(current.val);
            clonedNode.next = current.next;
            current.next = clonedNode;
            current = clonedNode.next;
        }

        // Step 2: Set the random pointers for the cloned nodes
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        // Step 3: Restore the original list and extract the cloned list
        current = head;
        Node dummyHead = new Node(0);
        Node cloneCurrent = dummyHead;
        while (current != null) {
            cloneCurrent.next = current.next;
            cloneCurrent = cloneCurrent.next;
            current.next = current.next.next;
            current = current.next;
        }

        return dummyHead.next;
    }
    public static void main(String[] args) {
        // Create a linked list with nodes
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        // Set up next pointers
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        // Set up random pointers
        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        // Instantiate the DeepCopyLinkedList class
        DeepCopyLinkedList deepCopy = new DeepCopyLinkedList();

        // Call the method to copy the linked list
        Node clonedListHead = deepCopy.copyRandomList(node1);

        // Print original list
        System.out.println("Original List:");
        printList(node1);

        // Print cloned list
        System.out.println("\nCloned List:");
        printList(clonedListHead);
    }

    // Helper function to print the linked list
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print("Node value: " + current.val + ", Random points to: ");
            if (current.random != null) {
                System.out.print(current.random.val);
            } else {
                System.out.print("null");
            }
            System.out.println();
            current = current.next;
        }
    }
}