package leetcodetop75;

public class PathSum111 {
    public int pathSum(TreeNode root, int targetSum) {
        int count = 0;
        pathSumHelper(root,targetSum,count);
        return count;
    }
    public void pathSumHelper(TreeNode node, int targetSum,int count){
        if(targetSum == 0){
            count++;
            return;
        }
        if(node == null){
            return;
        }
        targetSum -=node.val;
        pathSumHelper(node.left,targetSum,count);
        pathSumHelper(node.right,targetSum,count);
    }
    public static void main(String[] args) {
        PathSum111 sol = new PathSum111();

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
