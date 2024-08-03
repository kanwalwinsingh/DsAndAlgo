package main.java.trees.findkfromroot;

import main.java.trees.shortesteleminbst.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class BinaryTree<T> {
    TreeNode<T> root;

    // Constructor accepting an array of generic type T
    BinaryTree(T[] ListOfNodes) {
        root = createBinaryTree(ListOfNodes);
    }

    private TreeNode<T> createBinaryTree(T[] ListOfNodes) {
        if (ListOfNodes.length == 0) {
            return null;
        }

        // Create the root node of the binary tree
        TreeNode<T> root = new TreeNode<>(ListOfNodes[0]);

        // Create a queue and add the root node to it
        Queue<TreeNode<T>> q = new LinkedList<>();
        q.add(root);

        // Start iterating over the list of ListOfNodes starting from the second node
        int i = 1;
        while (i < ListOfNodes.length) {
            // Get the next node from the queue
            TreeNode<T> curr = q.remove();

            // If the node is not null and not equal to Integer.MAX_VALUE,
            // create a new TreeNode object for its left child,
            // set it as the left child of the current node, and add it to the queue
            if (ListOfNodes[i]!=null) {
                curr.left = new TreeNode<>(ListOfNodes[i]);
                q.add(curr.left);
            }

            i++;

            // If there are more ListOfNodes in the list and the next node is not null and not equal to Integer.MAX_VALUE,
            // create a new TreeNode object for its right child, set it as the right child
            // of the current node, and add it to the queue
            if (i < ListOfNodes.length && ListOfNodes[i]!=null) {
                curr.right = new TreeNode<>(ListOfNodes[i]);
                q.add(curr.right);
            }

            i++;
        }

        // Return the root of the binary tree
        return root;
    }
}