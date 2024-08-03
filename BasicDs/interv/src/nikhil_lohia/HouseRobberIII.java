package nikhil_lohia;

public class HouseRobberIII {
    public int rob(TreeNode root) {
        int[] options = travel(root);
        return Math.max(options[0],options[1]);
    }

    private int[] travel(TreeNode root){
        if(root == null){
            return new int[2];
        }
        int[] left_node_choice  = travel(root.left);
        int[] right_node_choice = travel(root.right);
        int[] options = new int[2];
        options[0] = root.val+left_node_choice[1] +right_node_choice[1];
        options[1] = Math.max(left_node_choice[0],left_node_choice[1])+Math.max(right_node_choice[0],right_node_choice[1]);
        return options;
    }
    // Driver code to test the solution
    public static void main(String[] args) {
        HouseRobberIII robber = new HouseRobberIII();

        // Example tree:
        //      3
        //     / \
        //    2   3
        //     \   \
        //      3   1
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);

        System.out.println("The maximum amount of money the thief can rob is: " + robber.rob(root)); // Output: 7
    }
}
