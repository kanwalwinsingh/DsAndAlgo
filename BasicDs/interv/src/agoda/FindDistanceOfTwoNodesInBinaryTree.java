package agoda;

import LeetCode.TreeNode;

public class FindDistanceOfTwoNodesInBinaryTree {

    TreeNode findLCA(TreeNode node, int p, int q){
        if(node == null){
            return node;
        }
        if(node.val == p || node.val == q){
            return  node;
        }

        TreeNode lcaLeft = findLCA(node.left, p,q);
        TreeNode lcaRight = findLCA(node.right,p,q);

        if(lcaLeft != null && lcaRight != null){
            return node;
        }
        return (lcaLeft != null) ? lcaLeft : lcaRight;
    }

    public int findDistance(TreeNode root, int p, int q){
        TreeNode lca = findLCA(root,p,q);
        int d1 = findDistanceFromRoot(lca,p,0);
        int d2 = findDistanceFromRoot(lca,q,0);

        return d1 +d2;
    }

    public int findDistanceFromRoot(TreeNode lca, int p, int level){
        if(lca == null){
            return -1;
        }
        if(lca.val == p){
            return level;
        }

        int left = findDistanceFromRoot(lca.left,p,level+1);
        if(left == -1){
            return  findDistanceFromRoot(lca.right,p,level+1);
        }
        return left;
    }

    public static void main(String[] args) {
        FindDistanceOfTwoNodesInBinaryTree fd = new FindDistanceOfTwoNodesInBinaryTree();
        TreeNode tree = new TreeNode();
        tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);

        int n1 = 4, n2 = 5;
        System.out.println("Distance between " + n1 + " and " + n2 + " is: "
                + fd.findDistance(tree, n1, n2));

        n1 = 4;
        n2 = 6;
        System.out.println("Distance between " + n1 + " and " + n2 + " is: "
                + fd.findDistance(tree, n1, n2));

        n1 = 3;
        n2 = 4;
        System.out.println("Distance between " + n1 + " and " + n2 + " is: "
                + fd.findDistance(tree, n1, n2));

        n1 = 2;
        n2 = 4;
        System.out.println("Distance between " + n1 + " and " + n2 + " is: "
                + fd.findDistance(tree, n1, n2));
    }
}
