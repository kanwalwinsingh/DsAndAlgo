package leetcodetop75;

public class SearchInBinaryTree {
    public TreeNode searchBST(TreeNode root, int val){
       //Base case : If the root is null or the root's value matches the target value
        if(root == null || root.val == val){
            return root;
        }
        //If the value is less than the root's value, search in the left subtree
        if(val < root.val){
            return searchBST(root.left,val);
        }
        //if the value is greater than the root value, search in the right subtree
        return searchBST(root.right, val);
    }


    public static void main(String[] args) {
        // Create a sample binary search tree:
        //         4
        //        / \
        //       2   7
        //      / \
        //     1   3
        TreeNode root = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node7 = new TreeNode(7);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);

        root.left = node2;
        root.right = node7;
        node2.left = node1;
        node2.right = node3;

        SearchInBinaryTree solution = new SearchInBinaryTree();
        TreeNode result = solution.searchBST(root, 2);
        if (result != null) {
            System.out.println("Node found with value: " + result.val);
            // Further operations on the subtree rooted at 'result' can be performed here.
        } else {
            System.out.println("Node with the given value does not exist in the BST.");
        }
    }
}
