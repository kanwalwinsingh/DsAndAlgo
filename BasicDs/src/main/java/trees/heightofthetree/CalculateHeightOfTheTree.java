package main.java.trees.heightofthetree;

import main.java.trees.shortesteleminbst.BinarySearchTree;
import main.java.trees.shortesteleminbst.TreeNode;

public class CalculateHeightOfTheTree {
    public static int findHeight(TreeNode<Integer> root) {
        //Check if root exists, no root means 0 height of the tree
        if (root == null) {
            return 0;
        }
        // otherwise, recursively find the height of the tree
        else {
            //Finding the max height of both sub-trees
            int maxSubtreeHeight = Math.max(findHeight(root.left), findHeight(root.right));

            // Add 1 to max height and return
            return 1 + maxSubtreeHeight;
        }
    }

    // Driver code
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
            System.out.println((i + 1) + ".\tGiven Tree: ");
            inputTree.inOrderTraversal(inputTree.root);
            System.out.println("\n\tHeight of the Tree: " + findHeight(inputTree.root));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
