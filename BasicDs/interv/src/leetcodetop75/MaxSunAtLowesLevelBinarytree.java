package leetcodetop75;


import java.util.LinkedList;
import java.util.Queue;

public class MaxSunAtLowesLevelBinarytree {
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int maxSum = Integer.MIN_VALUE;
        int minLevel = 1;
        int currentLevel = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int levelSum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelSum += node.val;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            if (levelSum > maxSum) {
                maxSum = levelSum;
                minLevel = currentLevel;
            }
            currentLevel++;
        }
        return minLevel;
    }

    public static void main(String[] args) {


        // Create a sample binary tree:
        //         1
        //        / \
        //       7   0
        //      / \   \
        //     7  -8   1
        TreeNode root = new TreeNode(1);
        TreeNode node7a = new TreeNode(7);
        TreeNode node0 = new TreeNode(0);
        TreeNode node7b = new TreeNode(7);
        TreeNode nodeMinus8 = new TreeNode(-8);
        TreeNode node1 = new TreeNode(1);

        root.left = node7a;
        root.right = node0;
        node7a.left = node7b;
        node7a.right = nodeMinus8;
        node0.right = node1;

        MaxSunAtLowesLevelBinarytree solution = new MaxSunAtLowesLevelBinarytree();
        int result = solution.maxLevelSum(root);
        System.out.println("Level with maximum sum: " + result); // Expected output: 2
    }
}
