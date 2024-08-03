package main.java.algorithms.bfsoftree;

import main.java.algorithms.dfsoftree.BinaryTree;
import main.java.algorithms.dfsoftree.TreeNode;

import java.util.*;

public class LevelOrderTraversalOfTree {
    public static String levelOrderTraversal(TreeNode<Integer> root) {
        StringBuilder result = new StringBuilder();
        if (root == null) {
            return "None";
        }
        ArrayList<Queue<TreeNode<Integer>>> queues = new ArrayList<>();
        queues.add(new ArrayDeque<>());
        queues.add(new ArrayDeque<>());

        Queue<TreeNode<Integer>> currentQueue = queues.get(0);
        Queue<TreeNode<Integer>> nextQueue = queues.get(1);

        currentQueue.add(root);
        int levelNumber = 0;
        while (!currentQueue.isEmpty()) {
            TreeNode<Integer> temp = currentQueue.poll();
            result.append(String.valueOf(temp.data));

            if (temp.left != null) {
                nextQueue.add(temp.left);
            }
            if (temp.right != null) {
                nextQueue.add(temp.right);
            }
            if (currentQueue.isEmpty()) {
                ++levelNumber;
                if (!nextQueue.isEmpty()) {
                    result = result.append(" : ");
                }
                currentQueue = queues.get(levelNumber % 2);
                nextQueue = queues.get((levelNumber + 1) % 2);
            } else {
                result.append(", ");
            }

        }
        return result.toString();
    }

    public static String levelOrderTraversalUsingSingleDeque(TreeNode<Integer> root){
        List<String> result = new ArrayList<>();
        if(root == null){
            return "None";
        }
        Queue<TreeNode<Integer>> currentQueue = new ArrayDeque<>();
        currentQueue.add(root);
        while (!currentQueue.isEmpty()){
            int levelSize = currentQueue.size();
            List<String> levelNodes = new ArrayList<>();
            for(int i =0; i< levelSize; i++){
                TreeNode<Integer> temp = currentQueue.poll();
                levelNodes.add(String.valueOf(temp.data));
                if(temp.left != null){
                    currentQueue.add(temp.left);
                }
                if(temp.right != null){
                    currentQueue.add(temp.right);
                }
            }
            result.add(String.join(",", levelNodes));
        }
        return String.join(" : ",result);
    }

    public static void main(String[] argv) {
        List<TreeNode<Integer>> testCasesRoots = new ArrayList<>();

        List<TreeNode<Integer>> input1 = Arrays.asList(
                new TreeNode<>(100),
                new TreeNode<>(50),
                new TreeNode<>(200),
                new TreeNode<>(25),
                new TreeNode<>(75),
                new TreeNode<>(350)
        );
        BinaryTree<Integer> tree1 = new BinaryTree<>(input1);
        testCasesRoots.add(tree1.root);

        List<TreeNode<Integer>> input2 = Arrays.asList(
                new TreeNode<>(25),
                new TreeNode<>(50),
                null,
                new TreeNode<>(100),
                new TreeNode<>(200),
                new TreeNode<>(350)
        );
        BinaryTree<Integer> tree2 = new BinaryTree<>(input2);
        testCasesRoots.add(tree2.root);

        List<TreeNode<Integer>> input3 = Arrays.asList(
                new TreeNode<>(350),
                null,
                new TreeNode<>(100),
                null,
                new TreeNode<>(50),
                new TreeNode<>(25)
        );
        BinaryTree<Integer> tree3 = new BinaryTree<>(input3);
        testCasesRoots.add(tree3.root);

        BinaryTree<Integer> tree4 = new BinaryTree<>(Arrays.asList(new TreeNode<>(100)));
        testCasesRoots.add(tree4.root);

        testCasesRoots.add(null);

        for (int i = 0; i < testCasesRoots.size(); i++) {
            if (i > 0) {
                System.out.println("\n");
            }
            System.out.println(i + 1 + ".\tBinary Tree");
           // Print.displayTree(testCasesRoots.get(i));
            System.out.print("\n\tLevel order traversal: ");
            System.out.println(levelOrderTraversalUsingSingleDeque(testCasesRoots.get(i)) + "\n");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
