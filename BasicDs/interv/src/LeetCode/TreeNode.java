package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public List<Integer> inOrderTraversal(TreeNode root){
     List<Integer> list = new ArrayList<>();
     inOrderTraversalHelper(root,list);
     return list;
    }
    public void inOrderTraversalHelper(TreeNode root, List<Integer> list){
     if(root == null){
      return;
     }
     inOrderTraversalHelper(root.left,list);
     list.add(root.val);
     inOrderTraversalHelper(root.right,list);
    }
}