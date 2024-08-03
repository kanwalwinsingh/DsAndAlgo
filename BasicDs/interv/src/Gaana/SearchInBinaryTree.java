package Gaana;

import java.util.LinkedList;
import java.util.Queue;

public class SearchInBinaryTree {
    public static TreeNode findNodeDFS(TreeNode root, int x){
        if(root == null){
            return null;
        }
        if(root.value == x){
            return root;
        }
        TreeNode leftResult = findNodeDFS(root.left,x);
        if(leftResult!=null) return leftResult;
        return findNodeDFS(root.right,x);
    }

    public static TreeNode findNodeBFS(TreeNode root, int x){
        if(root == null)
            return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.value == x){
                return node;
            }
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // Example binary tree
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(25);

        int x = 7;
        TreeNode result = findNodeDFS(root, x);
        if (result != null) {
            System.out.println("Node with value " + x + " found.");
        } else {
            System.out.println("Node with value " + x + " not found.");
        }
    }
}
