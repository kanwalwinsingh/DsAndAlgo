package leetcodetop75;

public class LSTComonAncestorBinarytree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return root;
        }
        if(root == p || root == q){
            return root;
        }
        TreeNode lcaLeft = lowestCommonAncestor(root.left,p,q);
        TreeNode lcaRight = lowestCommonAncestor(root.right,p,q);
        if(lcaLeft != null && lcaRight != null){
            return root;
        }
        return lcaLeft != null ? lcaLeft : lcaRight;
    }
}
