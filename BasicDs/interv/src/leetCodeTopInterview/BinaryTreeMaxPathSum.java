package leetCodeTopInterview;

import LeetCode.TreeNode;

public class BinaryTreeMaxPathSum {
    private int maxPathSum;
    public int maxPathSum(TreeNode root) {
        maxPathSum = Integer.MIN_VALUE;
         maxPathSumHelper(root);
         return maxPathSum;

    }
   public int maxPathSumHelper(TreeNode node){
        if(node == null){
            return 0;
        }
        //Calculate the maximum gain from left and right subtree
        int leftGain = Math.max(maxPathSumHelper(node.left),0);
        int rightGain = Math.max(maxPathSumHelper(node.right),0);

        // Calculate the price of the current path (node + left + right)
        int priceNewPath = node.val +leftGain+rightGain;

        // Update the global maximum sum if the current path is better
        maxPathSum = Math.max(priceNewPath,maxPathSum);

        // Return the maximum gain to be used by the parent node (node + max of left or right)
        return node.val + Math.max(leftGain,rightGain);
    }

    public static void main(String[] args) {
       BinaryTreeMaxPathSum binaryTreeMaxPathSum = new BinaryTreeMaxPathSum();
       TreeNode root = new TreeNode(-10);
        TreeNode nine = new TreeNode(9);
        TreeNode twenty = new TreeNode(20);
        TreeNode fifteen = new TreeNode(15);
        TreeNode seven = new TreeNode(7);
        root.left = nine;
        root.right = twenty;
        twenty.left = fifteen;
        twenty.right = seven;
        int k = binaryTreeMaxPathSum.maxPathSum(root);
        System.out.println(k);
    }
}
