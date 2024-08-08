package nikhil_lohia;

import com.sun.source.tree.BinaryTree;
import com.sun.source.tree.Tree;

import java.util.HashMap;

public class BinaryTreeFromPostAndInOrderTraversal {
    private int postOrderIndex;
    private HashMap<Integer,Integer> inOrderIndexMap;

    public TreeNode buildTree(int[] inOrder, int[] postOrder){
        postOrderIndex = postOrder.length -1;
        inOrderIndexMap = new HashMap<>();

        for(int i =0; i< inOrder.length; i++){
            inOrderIndexMap.put(inOrder[i],i);
        }
        return buildTreeHelper(postOrder,0,inOrder.length-1);

    }

    private TreeNode buildTreeHelper(int[] postOrder, int left, int right){
        if(left > right){
            return null;
        }

        int rootvalue = postOrder[postOrderIndex--];
        TreeNode root = new TreeNode(rootvalue);

        //Build the right and left subtree
        //excluding inOrderIndexMap[rootValue] element because it's the root
        root.right = buildTreeHelper(postOrder, inOrderIndexMap.get(rootvalue)+1, right);
        root.left = buildTreeHelper(postOrder,left,inOrderIndexMap.get(rootvalue)-1);
        return root;
    }
    public static void main(String[] args) {
        BinaryTreeFromPostAndInOrderTraversal solution = new BinaryTreeFromPostAndInOrderTraversal();

        // Example usage
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        TreeNode root = solution.buildTree(inorder, postorder);

        // Print the tree (inorder traversal)
        printInorder(root);
    }

    // Helper function to print the inorder traversal of the tree
    private static void printInorder(TreeNode node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }
}
