package main.java.trees.findacestorofnodekinbinarytree;

import main.java.trees.shortesteleminbst.BinarySearchTree;
import main.java.trees.shortesteleminbst.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindAncestorsOfNodeKInBinaryTree {

    public static List<Integer> findAncestors(TreeNode<Integer> root, int k){
        List<Integer> result = new ArrayList<>();
        recFindAncestors(root,k,result); // recursively find ancestor
        return result; // return  a result of ancestors
    }
    public static boolean recFindAncestors(TreeNode<Integer> root, int k, List<Integer> result){
        if(root == null){
            return false;
        } else if (root.data == k) {
            return true;
        }
        boolean recLeft = recFindAncestors(root.left, k, result);
        if(recLeft){
            //If recursive find in either left or right subtree apend root value and return
            result.add(root.data);
            return true;
        }
        boolean recRight = recFindAncestors(root.right, k, result);
        if(recRight){
            result.add(root.data);
            return true;
        }
            return false;
    }
    public static void main(String[] args) {
        Integer inputs[][] = {
                {100, 50, 200, 25, 75, 150 , 350},
                {25, 15, 75, 8, 18, 50, 350},
                {350, -100, 450, -175, 125, 375, 500},
                {100},
                {23, 21, 27, 18, 22, 25, 29, 17, 19, 23,45,67,78, 85},
        };
        int k[] = {75, 8, 125, 100, 85};

        for (int i = 0; i < inputs.length; i++) {
            BinarySearchTree<Integer> inputTree = new BinarySearchTree<>(inputs[i]);
            System.out.println((i+1)+ "\tInput Tree: ");
            inputTree.inOrderTraversal(inputTree.root);
            System.out.println("\n\tk: " + k[i]);
            System.out.println("\n\tThe ancestors are : " + findAncestors(inputTree.root, k[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
