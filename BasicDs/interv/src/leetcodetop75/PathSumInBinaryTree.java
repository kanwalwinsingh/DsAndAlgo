package leetcodetop75;

import java.util.HashMap;
import java.util.Map;

public class PathSumInBinaryTree {
    public int pathSum(TreeNode root, int targetSum){
        Map<Long,Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0L,1); //Default prefix sum for the root node
        return dfs(root, 0, targetSum,prefixSumCount);
    }

    private int dfs(TreeNode node, long currSum, int targetSum, Map<Long, Integer> prefixSumCount){
        if(node == null){
            return 0;
        }

        //Update the current sum
        currSum += node.val;

        //Get the number of valid path ending at the current sum
        int numPathsToOccur = prefixSumCount.getOrDefault(currSum-targetSum, 0);

        //Update the prefix sum count map
        prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum,0)+1);

        int result = numPathsToOccur + dfs(node.left, currSum,targetSum,prefixSumCount)
                        +dfs(node.right,currSum,targetSum,prefixSumCount);

                        //Backtrack: remove the current sum from the map to avoid affecting other paths
        prefixSumCount.put(currSum,prefixSumCount.get(currSum) -1);
        return result;
    }

    public static void main(String[] args) {
        PathSumInBinaryTree sol = new PathSumInBinaryTree();

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);

        int targetSum = 8;
        System.out.println(sol.pathSum(root, targetSum));  // Output: 3
    }
}
