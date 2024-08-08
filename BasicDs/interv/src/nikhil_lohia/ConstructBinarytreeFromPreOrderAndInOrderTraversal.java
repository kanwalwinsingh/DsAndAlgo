package nikhil_lohia;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/submissions/1345121116/
 */
public class ConstructBinarytreeFromPreOrderAndInOrderTraversal {

    private int preOrderIndex;
    private Map<Integer,Integer> inorderIndexMap;
    TreeNode buildTree(int[] preOrder, int[] inOrder){
        Map<Integer,Integer> inOrderIndexMap = new HashMap<>();
        for(int i =0; i<inOrder.length; i++){
            inOrderIndexMap.put(inOrder[i], i);
        }
        return splitTree(preOrder,inOrderIndexMap,0,0,inOrder.length-1);
    }
    private TreeNode splitTree(int[] preOrder, Map<Integer,Integer> inOrderIndexMap, int rootIndex, int left, int right){
        TreeNode root = new TreeNode(preOrder[rootIndex]);
        //Create left and right subtree
        int mid = inOrderIndexMap.get(preOrder[rootIndex]);
        if(mid>left){
            root.left = splitTree(preOrder,inOrderIndexMap,rootIndex+1, left, mid-1);
        }
        if(mid<right){
            root.right = splitTree(preOrder,inOrderIndexMap,rootIndex+(mid-left+1),mid+1,right);
        }
        return root;
    }

    //
    public TreeNode buildTreeOptimal(int[] preOrder, int[] inOrder){
        preOrderIndex = 0;
        inorderIndexMap = new HashMap<>();
        for(int i =0; i<inOrder.length; i++){
            inorderIndexMap.put(inOrder[i],i);
        }
        return buildTreeHelper(preOrder,0,inOrder.length-1);
    }

    private TreeNode buildTreeHelper(int[] preOrder, int left, int right) {
        if(left>right){
            return null;
        }
        int rootValue = preOrder[preOrderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // Build the left and right subtree
        // excluding inorderIndexMap[rootValue] element because it's the root
        root.left = buildTreeHelper(preOrder,left,inorderIndexMap.get(rootValue)-1);
        root.right = buildTreeHelper(preOrder,inorderIndexMap.get(rootValue)+1, right);
        return root;
    }
    public static void main(String[] args) {
        ConstructBinarytreeFromPreOrderAndInOrderTraversal solution = new ConstructBinarytreeFromPreOrderAndInOrderTraversal();

        // Example usage
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = solution.buildTreeOptimal(preorder, inorder);

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
