package main.java.algorithms.dfsoftree;

import javax.sound.midi.MidiFileFormat;
import java.util.Arrays;
import java.util.List;

public class FindDiameterOfTree {
    public static class Pair{
        int diameter;
        int height;
        public Pair(int diameter, int height){
            this.diameter = diameter;
            this.height = height;
        }
    }
    public static Pair diameterHelperFunc(TreeNode<Integer> node){
        if(node == null){
            return new Pair(0,0);
        }else {
            Pair lh = diameterHelperFunc(node.left);
            Pair rh = diameterHelperFunc(node.right);
            int height = Math.max(lh.height, rh.height)+1;
            int diameter = Math.max(lh.diameter, Math.max(rh.diameter, lh.height+ rh.height));
            return new Pair(diameter,height);
        }
    }

    public static int diameterOfBinaryTree(TreeNode<Integer> root){
        if(root == null){
            return  0;
        }
        Pair pair = diameterHelperFunc(root);
        return pair.diameter;
    }
    // Driver code
    public static void main(String args[]) {
        List<List<TreeNode<Integer>>> lists = Arrays.asList(
                Arrays.asList(new TreeNode<Integer>(2), new TreeNode<Integer>(1), new TreeNode<Integer>(4), new TreeNode<Integer>(3), new TreeNode<Integer>(5), new TreeNode<Integer>(6), new TreeNode<Integer>(7)),
                Arrays.asList(new TreeNode<Integer>(1), new TreeNode<Integer>(2), new TreeNode<Integer>(3), new TreeNode<Integer>(4), new TreeNode<Integer>(5), new TreeNode<Integer>(6), new TreeNode<Integer>(7), new TreeNode<Integer>(8), new TreeNode<Integer>(9)),
                Arrays.asList(new TreeNode<Integer>(45), new TreeNode<Integer>(32), new TreeNode<Integer>(23), new TreeNode<Integer>(21), new TreeNode<Integer>(19), new TreeNode<Integer>(18), new TreeNode<Integer>(1)),
                Arrays.asList(new TreeNode<Integer>(5), new TreeNode<Integer>(3), new TreeNode<Integer>(4), new TreeNode<Integer>(1), new TreeNode<Integer>(2), new TreeNode<Integer>(6), new TreeNode<Integer>(7), new TreeNode<Integer>(8), new TreeNode<Integer>(9)),
                Arrays.asList(new TreeNode<Integer>(9), new TreeNode<Integer>(7), null, null, new TreeNode<Integer>(1), new TreeNode<Integer>(8), new TreeNode<Integer>(10), null, new TreeNode<Integer>(12))
        );

        for (int i = 0; i < lists.size(); i++) {
            BinaryTree<Integer> t = new BinaryTree<Integer>(lists.get(i));
            System.out.println((i + 1) + ".\tBinary Tree");
            //Print.displayTree(t.root);
            System.out.println(
                    "\n\tDiameter of Tree: " + diameterOfBinaryTree(t.root));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

}
