package main.java.trees.shortesteleminbst;

import main.java.trees.binarysearchtree.Node;

public class BinarySearchTree<T extends Comparable<T>> {
    public TreeNode<T> root;

    public BinarySearchTree(T[] values) {
        this.root = createBinaryTree(values);
    }

    private TreeNode<T> createBinaryTree(T[] values) {
        if (values.length == 0) {
            return null;
        }
        //Create the root of the binary tree
        TreeNode<T> root = new TreeNode<>(values[0]);

        //Start iterating over the array of values strarting from the second value
        for (int i = 1; i < values.length; i++) {
            TreeNode<T> node = new TreeNode<>(values[i]);
            TreeNode<T> curr = root;
            while (true) {
                // If the value is less than or equal to the current node's value, move to the left child
                if (node.data.compareTo(curr.data) <= 0) {
                    if (curr.left == null) {
                        curr.left = node;
                        break;
                    } else {
                        curr = curr.left;
                    }
                } else {
                    if (curr.right == null) {
                        curr.right = node;
                        break;
                    } else {
                        curr = curr.right;
                    }
                }
            }
        }
        return root;
    }

    public void inOrderTraversal(TreeNode<Integer> root){
        if(root == null) return;

        inOrderTraversal(root.left);
        System.out.print(root.data+", ");
        inOrderTraversal(root.right);

    }
}
