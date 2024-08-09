package leetcodetop75;

import com.sun.source.tree.Tree;

public class TreeZigZagPathSolution
{
    private int maxZigZag;
    private int maxZigZag(TreeNode root){
        maxZigZag = 0;
        dfs(root,true,0); // start with the right directions
        dfs(root,false,0); // start with the left directions
        return maxZigZag;
    }

    private void dfs(TreeNode node, boolean isRight, int length){
        if(node == null) return;

        //Update the maximum length found
        maxZigZag = Math.max(maxZigZag, length);
        //If the current direction is right, move to the left child and change direction
        if(isRight) {
            dfs(node.left,false,length+1);
            //Also try the right child with the same direction
            dfs(node.right,true,1);
        }else{
            //If the current direction is left, move to the right child and changes the direction
            dfs(node.right, true, length+1);
            // Also try the left child with the same direction
            dfs(node.left, false,1);
        }
    }

    public static void main(String[] args) {
        // Create a sample binary tree:
        //         1
        //        / \
        //       2   3
        //        \
        //         4
        //        / \
        //       5   6
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(5);
        root.left.right.right = new TreeNode(6);

        TreeZigZagPathSolution solution = new TreeZigZagPathSolution();
        int result = solution.maxZigZag(root);
        System.out.println("Longest ZigZag Path Length: " + result); // Expected output: 3
    }
}
