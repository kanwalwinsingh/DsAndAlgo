package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BSTLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
          return   result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for(int i =0; i<levelSize; i++){
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);
                if(currentNode.left!=null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }

    public List<List<Integer>> levelOrderFaster(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        levelOrderTraversal(root,0,result);
        return result;
    }
    public void levelOrderTraversal(TreeNode root, int level, List<List<Integer>> result){
        if(level == result.size()){
            List<Integer> temp = new ArrayList<>();
            temp.add(root.val);
            result.add(temp);
        }else{
            List<Integer> temp = result.get(level);
            temp.add(root.val);
        }
        if(root.left!=null){
            levelOrderTraversal(root.left,level+1,result);
        }
        if(root.right!=null){
            levelOrderTraversal(root.right,level+1,result);
        }
    }

    public static void main(String[] args) {
        // Example usage
        BSTLevelOrderTraversal solution = new BSTLevelOrderTraversal();

        // Construct a binary tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = solution.levelOrderFaster(root);
        System.out.println(result);
    }
}
