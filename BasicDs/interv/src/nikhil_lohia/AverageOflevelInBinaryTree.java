package nikhil_lohia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOflevelInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averageList = new ArrayList<>();
        if (root == null)
            return averageList;
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);
        while (!treeNodeQueue.isEmpty()){
            int size = treeNodeQueue.size();
            double sum = 0;
            for (int i =0; i<size; i++){
                TreeNode node = treeNodeQueue.poll();
                sum+=node.val;
                if (node.left != null) {
                    treeNodeQueue.add(node.left);
                }
                if(node.right != null){
                    treeNodeQueue.add(node.right);
                }
            }
            averageList.add(sum/size);
        }
        return averageList;
    }

    public List<Double> averageOfLevelsAlternative(TreeNode root) {
        Queue<TreeNode> levelQueue = new LinkedList<>();
        levelQueue.add(root);
        levelQueue.add(null);
        List<Double> avgList = new ArrayList<>();
        while(levelQueue.peek() != null){
            double sum =0;
            int nodes = 0;
            while (levelQueue.peek() != null){
                TreeNode node = levelQueue.poll();
                sum+= node.val;
                nodes++;
                if(node.left != null) levelQueue.add(node.left);
                if(node.right != null) levelQueue.add(node.right);
            }
            levelQueue.add(levelQueue.poll());
            avgList.add(sum/nodes);
        }
        return avgList;
    }

}
