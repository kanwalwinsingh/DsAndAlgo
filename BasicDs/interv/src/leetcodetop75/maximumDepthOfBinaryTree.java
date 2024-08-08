package leetcodetop75;

public class maximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        return maxDepthHelper(root);
    }

    public int maxDepthHelper(TreeNode node){
        if (node == null){
            return 0;
        }
        int left = maxDepthHelper(node.left);
        int right = maxDepthHelper(node.right);
        return Math.max(left,right)+1;
    }
}
