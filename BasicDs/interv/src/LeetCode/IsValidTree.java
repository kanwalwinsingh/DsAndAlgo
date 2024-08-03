package LeetCode;

import java.util.List;

public class IsValidTree {
    public boolean isValidBSt(TreeNode root){
        return isValidBSTHelper(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private boolean isValidBSTHelper(TreeNode node, long min, long max){
        if(node == null) return true;

        //Check if current nodes value is within the valid range
        if (node.val<=min || node.val >=max){
            return false;
        }

        //recursively check the left subtree and the right subtree
        return isValidBSTHelper(node.left, min,node.val) &&
                isValidBSTHelper(node.right,node.val,max);

    }

    public static void main(String[] args) {
        IsValidTree solution = new IsValidTree();

        // Construct a binary tree
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);

        boolean validBST = solution.isValidBSt(root);
        System.out.println(validBST);
    }
}
