package nikhil_lohia;

public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums){
      if(nums == null)
          return null;
      return buildBinaryTree(nums,0,nums.length-1);
    }

    public TreeNode buildBinaryTree(int[] nums, int left, int right){
        if(left>right) {
            return null;
        }

        int maxIndex = left;
        int maxNumber = nums[left];
        for(int i = left+1; i<=right; i++){

            if(nums[i]>maxNumber){
                maxIndex = i;
                maxNumber = nums[i];
            }
        }

        TreeNode root = new TreeNode(maxNumber);
        root.left = buildBinaryTree(nums,left,maxIndex-1);
        root.right = buildBinaryTree(nums,maxIndex+1, right);
        return root;
    }
    public static void main(String[] args) {
        MaximumBinaryTree solution = new MaximumBinaryTree();

        // Example usage
        int[] nums = {3, 2, 1, 6, 0, 5};

        TreeNode root = solution.constructMaximumBinaryTree(nums);

        // Print the tree (inorder traversal)
        printInorder(root);
    }

    // Helper function to print the inorder traversal of the tree
    private static void printInorder(TreeNode node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }
}
