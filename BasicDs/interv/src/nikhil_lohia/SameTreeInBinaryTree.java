package nikhil_lohia;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class SameTreeInBinaryTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(p);
        treeNodeQueue.add(q);
        while (!treeNodeQueue.isEmpty()){
            TreeNode first = treeNodeQueue.poll();
            TreeNode second = treeNodeQueue.poll();
            if(first == null && second == null){
                continue;
            }else if(first == null || second == null || first.val != second.val){
                return false;
            }
            treeNodeQueue.add(first.left);
            treeNodeQueue.add(second.left);
            treeNodeQueue.add(first.right);
            treeNodeQueue.add(second.right);
        }
        return true;
    }
}
