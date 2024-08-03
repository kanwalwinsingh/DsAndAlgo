package blackrock;

import java.util.Stack;

public class ValidateATreeIsBST {

    public static class Node {
        public int data;
        public Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static Node prev;

    static boolean isBstUtil(Node root){
        // traverse the tree in inorder fashion and keep track of prev node
        if(root != null){
            if(!isBstUtil(root.left)){
                return false;
            }
            //Allows only distinct value nodes
            if(prev != null && root.data <= prev.data){
                return false;
            }
            prev = root;
            return isBstUtil(root.right);
        }
        return true;
    }

    static boolean isBST(Node root){
        return isBstUtil(root);
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(4);

        // Function call
        if (isBST(root))
            System.out.println("Is BST");
        else
            System.out.println("Not a BST");
    }

}
