package expedia;

import LeetCode.TreeNode;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInBST {
    private int count = 0;
    private int result = -1;
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> results = new ArrayList<>();
        inOrderTraversal(results,root);
        if(k>=1) {
            return results.get(k - 1);
        }
        return -1;
    }

    public void inOrderTraversal(List<Integer> result, TreeNode node){
        if(node == null){
            return;
        }
        inOrderTraversal(result,node.left);
        result.add(node.val);
        inOrderTraversal(result,node.right);
    }

    public int kthSmallestOptimized(TreeNode root, int k){
        inOrderTraversalOptimized(root,k);
        return result;
    }

    private void inOrderTraversalOptimized(TreeNode node, int k){
        if(node == null){
            return;
        }

        //Traverse the left subtree
        inOrderTraversalOptimized(node.left, k);

        //visit the node
        if(count == k){
            result = node.val;
            return;
        }

        //Traverse the right subtee
        inOrderTraversalOptimized(node.right,k);
    }


    public static void main(String[] args) {
        KthSmallestElementInBST solution = new KthSmallestElementInBST();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        int k = 1;
        System.out.println("The " + k + "th smallest element is " + solution.kthSmallest(root, k)); // Output: 1
    }
}
