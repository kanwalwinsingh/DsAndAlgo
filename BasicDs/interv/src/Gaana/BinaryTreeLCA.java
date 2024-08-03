package Gaana;

public class BinaryTreeLCA {
   public static TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q){
       if(root == null){
           return null;
       }
       //If either p or q value matches with the root value return the root value
       if(root == p || root == q){
           return root;
       }

       //Search for LCA in left and right subtree
       TreeNode leftLCA = findLCA(root.left,p,q);
       TreeNode rightLCA = findLCA(root.right,p,q);

       //If both lefft and right subtree contains one of p or q, root is lca
       if(leftLCA != null && rightLCA != null){
           return root;
       }

       //Othewise, return the non-null child
       return (leftLCA != null) ? leftLCA : rightLCA;
   }
    public static void main(String[] args) {
        // Example binary tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode p = root.left; // Node with value 5
        TreeNode q = root.left.right.right; // Node with value 4

        TreeNode lca = findLCA(root, p, q);
        if (lca != null) {
            System.out.println("LCA of " + p.value + " and " + q.value + " is " + lca.value);
        } else {
            System.out.println("LCA does not exist.");
        }
    }
}
