package leetCodeTopInterview;

import LeetCode.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
 */
public class Codec {

    //Encodes a tree to a single String
    public String serialize(TreeNode root){
        StringBuilder sb = new StringBuilder();
        serializeHelper(root,sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder sb){
        if(node == null){
            sb.append("#,");
            return;
        }
        sb.append(node.val).append(",");
        serializeHelper(node.left,sb);
        serializeHelper(node.right,sb);
    }

    //Decodes your encoded data to tree
    public TreeNode deserialize(String data){
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(nodes);

    }
    private TreeNode deserializeHelper(Queue<String> nodes){
        String val = nodes.poll();
        if(val.equals("#")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserializeHelper(nodes);
        node.right = deserializeHelper(nodes);
        return node;
    }

    public static void main(String[] args) {
        // Construct the binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        // Instantiate Codec to serialize and deserialize
        Codec codec = new Codec();

        // Serialize the binary tree
        String serializedData = codec.serialize(root);
        System.out.println("Serialized Tree: " + serializedData);

        // Deserialize the string back to the binary tree
        TreeNode deserializedRoot = codec.deserialize(serializedData);

        // Print the deserialized tree to verify correctness
        System.out.print("Deserialized Tree (Preorder Traversal): ");
        printPreorder(deserializedRoot);
    }

    // Helper function to print the tree in Preorder to verify correctness
    public static void printPreorder(TreeNode root) {
        if (root == null) {
            System.out.print("# ");
            return;
        }
        System.out.print(root.val + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }
}
