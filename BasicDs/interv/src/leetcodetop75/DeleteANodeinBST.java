package leetcodetop75;

public class DeleteANodeinBST {
    public TreeNode deleteNode(TreeNode root, int key){
        //Base case: If the tree is empty
        if(root == null) return null;

        //Recur down the tree
        if(key< root.val){
            root.left = deleteNode(root.left, key);
        }else if(key> root.val){
            root.right = deleteNode(root.right, key);
        }else{
            //This is the node to be deleted
            if(root.left == null){
                return root.right; //Node with only child or no child
            } else if (root.right == null) {
                return root.left; //Node with only left child
            }

            //Node wit two children: Get the inOrder successor (smallest in the right subtree)
            TreeNode minNode = findMin(root.right);
            root.val = minNode.val; // Replace the value with the inorder successor
            root.right = deleteNode(root.right, minNode.val); // Delete the inorder successor
        }
        return root;
    }

    private TreeNode findMin(TreeNode node){
        while (node.left != null){
            node = node.left;
        }
        return node;
    }
    public static void main(String[] args) {
        // Create a sample binary search tree:
        //         5
        //        / \
        //       3   6
        //      / \   \
        //     2   4   7
        TreeNode root = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);

        root.left = node3;
        root.right = node6;
        node3.left = node2;
        node3.right = node4;
        node6.right = node7;

        DeleteANodeinBST solution = new DeleteANodeinBST();

        // Test case: Delete node with value 3
        root = solution.deleteNode(root, 3);
        printInOrder(root); // Expected output: 2 4 5 6 7
    }

    // Helper function to print the BST in-order
    private static void printInOrder(TreeNode root) {
        if (root != null) {
            printInOrder(root.left);
            System.out.print(root.val + " ");
            printInOrder(root.right);
        }
    }
}
