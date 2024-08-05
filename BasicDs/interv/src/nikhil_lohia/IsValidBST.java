package nikhil_lohia;

import java.util.ArrayList;
import java.util.List;

public class IsValidBST {
    boolean chekBST(TreeNode root){
        List<Integer> result = new ArrayList<>();
        helper(root,result);
        for (int i = 1; i< result.size(); i++){
            if(result.get(i)<=result.get(i-1)){
                return false;
            }
        }
        return true;

    }

    public boolean isValidBSTOptimal(TreeNode root){
        return isValidBST(root,null,null);
    }

    private boolean isValidBST(TreeNode node, Integer min, Integer max) {
        if(node == null){
            return true;
        }

        //Check if the current node value is within the valid range
        if((min!= null && node.val<= min) ||(max != null && node.val>=max)){
            return true;
        }

        //Recursively check the left and right subtree with updated range
        return isValidBST(node.left, min,node.val) && isValidBST(node.right, node.val,max);
    }

    void helper(TreeNode root, List<Integer> result){
        if(root !=null) {
            helper(root.left, result);
            result.add(root.val);
            helper(root.right, result);
        }
    }
}
