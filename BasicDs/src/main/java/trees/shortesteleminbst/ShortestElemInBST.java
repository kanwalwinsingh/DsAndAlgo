package main.java.trees.shortesteleminbst;

import com.sun.source.tree.Tree;
import main.java.trees.binarysearchtree.Node;

public class ShortestElemInBST {
    public static int findMin(TreeNode<Integer> root) {
        if (root == null) return -1;

        //Start from the root node;
        TreeNode<Integer> curr = root;

        //traverse left untill reaching the leftmost node
        while (curr.left != null) {
            curr = curr.left;
        }
        // return the data of the leftmost node which i minimum
        return curr.data;
    }

    public static int findMinRec(TreeNode<Integer> root){
        if(root == null) return -1;
        else if(root.left == null) return root.data;
        else return findMinRec(root.left);
    }

    public static void main(String[] args) {
        Integer[][] inputs = {
                {18, 15, 13, 19, 5, 14},
                {1, 2, 3, 4, 5, 6},
                {100, 200, 50, 40, 30, 80, 90},
                {10},
                {1, 2},
                {-10, -20, -30, -40, -50, -60, -70}
        };

        for (int i = 0; i < inputs.length; i++) {
            BinarySearchTree<Integer> inputTree = new BinarySearchTree<Integer>(inputs[i]);
            System.out.println((i+1)+ "\tInput Tree: ");
            preOrderTraversal(inputTree.root);
            System.out.println("\n\tSmallest element: " + findMinRec(inputTree.root));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    private static  void preOrderTraversal(TreeNode<Integer> root){
        if (root == null) return;
        System.out.print(root.data+", ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

}
