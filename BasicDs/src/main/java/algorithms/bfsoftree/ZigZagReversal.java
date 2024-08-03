package main.java.algorithms.bfsoftree;

import main.java.algorithms.dfsoftree.BinaryTree;
import main.java.algorithms.dfsoftree.TreeNode;

import java.util.*;

public class ZigZagReversal {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode<Integer> root){
        if(root == null){
            return new ArrayList<>();
        }
        Deque<TreeNode<Integer>> dq = new LinkedList<>();
        dq.add(root);
        List<List<Integer>> results = new ArrayList<>();
        boolean reverse = false;
        while (!dq.isEmpty()){
            int size = dq.size();
            results.add(new ArrayList<>());
            for (int i =0; i< size; i++){
                if(!reverse){
                    TreeNode<Integer> node = dq.pollFirst();
                    results.get(results.size()-1).add(node.data);
                    if(node.left != null) dq.addLast(node.left);
                    if(node.right != null) dq.addLast(node.right);
                }else{
                    TreeNode<Integer> node = dq.pollLast();
                    results.get(results.size()-1).add(node.data);
                    if(node.left != null) dq.addFirst(node.left);
                    if (node.right != null) dq.addFirst(node.right);
                }
            }
            reverse = !reverse;
        }
        return results;
    }
    // Driver code
    public static void main(String args[]){
        List<List<TreeNode<Integer>>> lists = Arrays.asList(

                Arrays.asList(new TreeNode<Integer>(100), new TreeNode<Integer>(50), new TreeNode<Integer>(200), new TreeNode<Integer>(25), new TreeNode<Integer>(75), new TreeNode<Integer>(350)),
                Arrays.asList(new TreeNode<Integer>(25), new TreeNode<Integer>(50), new TreeNode<Integer>(75), new TreeNode<Integer>(100), new TreeNode<Integer>(200), new TreeNode<Integer>(350)),
                Arrays.asList(new TreeNode<Integer>(350), new TreeNode<Integer>(200), new TreeNode<Integer>(100), new TreeNode<Integer>(75), new TreeNode<Integer>(50), new TreeNode<Integer>(25)),
                Arrays.asList(new TreeNode<Integer>(100)),
                Arrays.asList(new TreeNode<Integer>(null))
        );

        for (int i = 0; i < lists.size(); i++) {
            BinaryTree<Integer> t = new BinaryTree<Integer>(lists.get(i));
            System.out.println((i + 1) + ".\tBinary Tree");
           // Print.displayTree(t.root);
            System.out.println("\n\t The zigzag level order traversal is: " + zigzagLevelOrder(t.root));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
