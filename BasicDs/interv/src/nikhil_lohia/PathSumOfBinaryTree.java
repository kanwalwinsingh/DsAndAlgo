package nikhil_lohia;

import java.util.Stack;

public class PathSumOfBinaryTree {
    public static boolean haspathSum(TreeNode root, int sum){
        if(root == null){
            return false;
        }
        Stack<TreeNode> path = new Stack<>();
        Stack<Integer> sumPath = new Stack<>();

        path.push(root);
        sumPath.push(root.val);

        while (!path.isEmpty()){
            TreeNode temp = path.pop();
            int tempVal = sumPath.pop();
            //If a child node and we find the sum total, return true
            if(temp.left == null && temp.right == null && tempVal == sum){
                return true;
            }
            if(temp.right != null){
                path.push(temp.right);
                sumPath.push(temp.right.val + tempVal);
            }
            if(temp.left != null){
                path.push(temp.left);
                sumPath.push(temp.left.val+tempVal);
            }
        }
        return false;
    }

    public boolean haPathSumRecursion(TreeNode root, int targetSum){
        if(root == null){
            return false;
        }
        //If we reach a leaf node, check if the targetSum equals the leafs value
        if(root.left == null && root.right == null){
            return root.val == targetSum;
        }

        //Subtract the current node's value from the target sum
        targetSum -= root.val;

        return haPathSumRecursion(root.left, targetSum ) || haPathSumRecursion(root.right, targetSum);
    }

    public static void main(String[] args) {
        // Create a binary tree
        //      5
        //     / \
        //    4   8
        //   /   / \
        //  11  13  4
        // /  \      \
        //7    2      1

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);

        PathSumOfBinaryTree solution = new PathSumOfBinaryTree();

        // Check if there is a path sum equals to 22
        System.out.println(solution.haPathSumRecursion(root, 22));  // Output: true
    }
}
