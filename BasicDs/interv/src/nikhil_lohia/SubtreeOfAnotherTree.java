package nikhil_lohia;

public class SubtreeOfAnotherTree {
    public boolean isSubTree(TreeNode root, TreeNode subRoot){
        String fullTree = preOrderTraversalHelper(root);
        String subTree = preOrderTraversalHelper(subRoot);
        return fullTree.contains(subTree);
     }

    public String preOrderTraversalHelper(TreeNode root){
        if (root == null){
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder("^");
        stringBuilder.append(root.val);
        stringBuilder.append(preOrderTraversalHelper(root.left));
        stringBuilder.append(preOrderTraversalHelper(root.right));
        return stringBuilder.toString();
    }

    public boolean isSubtreeOptimal(TreeNode root, TreeNode subRoot){
        if(root == null){
            return false;
        }
        if(isSameTree(root,subRoot)){
            return true;
        }
        return isSubtreeOptimal(root.left,subRoot) || isSubtreeOptimal(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode s, TreeNode t){
        if(s == null && t == null){
            return true;
        }
        if(s == null || t== null){
            return false;
        }
        if(s.val != t.val){
            return false;
        }
        return isSameTree(s.left,t.left) && isSameTree(s.right, t.right);
    }
    public static void main(String[] args) {
        SubtreeOfAnotherTree checker = new SubtreeOfAnotherTree();

        // Example tree 1
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        // Example tree 2 (subtree)
        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);

        System.out.println(checker.isSubTree(root, subRoot)); // Should print true
    }

}
