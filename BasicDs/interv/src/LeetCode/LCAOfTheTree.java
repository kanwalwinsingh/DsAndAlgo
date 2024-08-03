package LeetCode;

public class LCAOfTheTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root!= null){
            //If both nodes are greater than root, then LCA lies in the right subtree
            if(p.val>root.val && q.val > root.val){
                root = root.right;
            }
            //if both node are smaller than root, then LCA lies in the left subtree;
            else if(p.val<root.val && q.val < root.val){
                root = root.left;
            }// If one node is on one side and the other is on the opposite side, then root is the LCA
            else {
                return root;
            }

        }
        return null;
    }
}
