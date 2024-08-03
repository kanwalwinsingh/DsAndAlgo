package main.java.algorithms.recursion;

import main.java.trees.binarysearchtree.Node;

public class BinarySearchInsertionExample {

    //Variables
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public static class Node {
        int data;
        Node left;
        Node right;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        Node(int data) {
            this.data = data;
        }
    }

    public Node recursiveInsert(Node currentNode, int value) {
        //Base case
        if (currentNode == null) {
            return new Node(value);
        }
        if(value<currentNode.getData()){
            currentNode.setLeft(recursiveInsert(currentNode.getLeft(),value));
        } else if (value > currentNode.getData()) {
            currentNode.setRight(recursiveInsert(currentNode.getRight(),value));
        }else {
            return currentNode;
        }
        return currentNode;
    }

    public boolean insert(int value){
        root = recursiveInsert(this.root,value);
        return true;
    }

    public void printTree(Node current){
        if(current == null) return;
        System.out.println(current.getData()+",");
        printTree(current.getLeft());
        printTree(current.getRight());
    }

    public static void main(String args[]) {

        BinarySearchInsertionExample bsT = new BinarySearchInsertionExample();
        bsT.insert(6);
        bsT.insert(4);
        bsT.insert(8);
        bsT.insert(5);
        bsT.insert(2);
        bsT.insert(8);
        bsT.insert(12);
        bsT.insert(10);
        bsT.insert(14);
        bsT.printTree(bsT.getRoot());

    }
}
