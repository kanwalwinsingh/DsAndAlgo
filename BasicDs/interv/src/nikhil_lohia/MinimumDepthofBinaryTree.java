package nikhil_lohia;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        if(root == null){
            return 0;
        }
        int depth = 1;
        treeNodeQueue.add(root);
        while (!treeNodeQueue.isEmpty()) {
            int size = treeNodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = treeNodeQueue.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    treeNodeQueue.add(node.left);
                }
                if (node.right != null) {
                    treeNodeQueue.add(node.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public int minDepthRecursive(TreeNode root){
        if(root == null){
            return 0;
        }
        //If left subtree is null, then we need to consider the depth of right subtree
        if(root.left == null){
            return minDepthRecursive(root.right) +1;
        }

        //If right subtree is null, then we need to consider the left subtree
        if(root.right == null){
            return minDepthRecursive(root.left)+1;
        }

        //If neither subtree is null find the minimum depth between the two
        return Math.min(minDepthRecursive(root.left), minDepthRecursive(root.right))+1;
    }


    public static void main(String[] args) {
        MinimumDepthofBinaryTree tree = new MinimumDepthofBinaryTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("The minimum depth of the binary tree is: " + tree.minDepthRecursive(root));
    }
}
