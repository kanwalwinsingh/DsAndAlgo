package expedia;

import LeetCode.TreeNode;

import  java.util.*;

public class ZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if(root == null){
            return results;
        }
        boolean isleftToRight = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> intList = new LinkedList<>();
            int levelSize = queue.size();
            for (int i =0; i<levelSize; i++) {
                TreeNode currentNode = queue.poll();
                    if(isleftToRight){
                        intList.add(currentNode.val);  // add to the end of the list;
                      //  intList.addLast(currentNode.val);
                    }else{
                        intList.add(0,currentNode.val); // add to the begining;
                       // intList.addFirst(currentNode.val);
                    }
                // Enqueue child nodes of the current node
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            isleftToRight = !isleftToRight;
            results.add(intList);
        }
        return results;
    }

    public static void main(String[] args) {
        // Construct the binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        // Create an instance of the Solution class
        ZigZagTraversal solution = new ZigZagTraversal();

        // Get the zigzag level order traversal
        List<List<Integer>> result = solution.zigzagLevelOrder(root);

        // Print the result
        System.out.println("Zigzag Level Order Traversal:");
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
}
