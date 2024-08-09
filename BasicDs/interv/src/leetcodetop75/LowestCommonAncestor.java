package leetcodetop75;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestorhelper(TreeNode node, TreeNode p, TreeNode q){
        if(node == null || node == p || node == q){
            return node;
        }

        //Recursively find the lca
        TreeNode leftLCA = lowestCommonAncestorhelper(node.left,p,q);
        TreeNode rightLCA = lowestCommonAncestorhelper(node.right,p,q);

        if(leftLCA != null && rightLCA != null){
            return node;
        }

        return leftLCA !=null ? leftLCA : rightLCA;
    }
    public static void main(String[] args) {
        // Create a sample binary tree:
        //         3
        //        / \
        //       5   1
        //      / \ / \
        //     6  2 0  8
        //       / \
        //      7   4
        TreeNode root = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);

        root.left = node5;
        root.right = node1;
        node5.left = node6;
        node5.right = node2;
        node1.left = node0;
        node1.right = node8;
        node2.left = node7;
        node2.right = node4;

        LowestCommonAncestor solution = new LowestCommonAncestor();
        TreeNode lca;// = solution.lowestCommonAncestor(root, node5, node1);
//        System.out.println("LCA of 5 and 1: " + lca.val); // Expected output: 3

        lca = solution.lowestCommonAncestorhelper(root, node5, node4);
        System.out.println("LCA of 5 and 4: " + lca.val); // Expected output: 5
    }
}
