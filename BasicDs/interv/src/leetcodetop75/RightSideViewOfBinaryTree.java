package leetcodetop75;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideViewOfBinaryTree {
    public List<Integer> rightSideView(TreeNode root) {
       List<Integer> result = new ArrayList<>();
       if(root == null){
           return result;
       }
        Queue<TreeNode> queue = new LinkedList<>();
       queue.offer(root);
       while (!queue.isEmpty()){
           int size = queue.size();
           Integer rightMostvalue = null;
           for(int i =0; i<size; i++){
               TreeNode node = queue.poll();
               rightMostvalue = node.val; // update the rightmost value

               if(node.left != null) queue.offer(node.left);
               if (node.right != null) queue.offer(node.right);
           }
           // Add the rightmost value of this level to the result
           result.add(rightMostvalue);
       }
       return result;
    }

    public static void main(String[] args) {
        // Create a sample binary tree:
        //         3
        //        / \
        //       5   1
        //      / \ / \
        //     6  2 0  8
        //       / \
        //      7   4
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
//        TreeNode node0 = new TreeNode(0);
//        TreeNode node8 = new TreeNode(8);
//        TreeNode node7 = new TreeNode(7);
//        TreeNode node4 = new TreeNode(4);

        root.left = node2;
        root.right = node3;
        node3.right = node4;

        RightSideViewOfBinaryTree rightSideViewOfBinaryTree = new RightSideViewOfBinaryTree();
        rightSideViewOfBinaryTree.rightSideView(root);
        System.out.println("");
    }

    }
