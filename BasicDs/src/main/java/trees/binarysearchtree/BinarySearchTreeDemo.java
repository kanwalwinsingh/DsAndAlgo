package main.java.trees.binarysearchtree;

public class BinarySearchTreeDemo {

    public static void main(String[] args) {
        BinarySearchTree BST = new BinarySearchTree();

        BST.add(6);
        BST.add(4);
        BST.add(2);
        BST.add(5);
        BST.add(9);
        BST.add(8);
        BST.add(12);


//        System.out.print("Tree : ");
//        bsT.printTree(bsT.getRoot());
//
//
//        System.out.print("\nDeleting Node 6: ");
//        bsT.delete(6, bsT.getRoot());
//        bsT.printTree(bsT.getRoot());
//
//        System.out.print("\nDeleting Node 15: ");
//        bsT.delete(15, bsT.getRoot());
//        bsT.printTree(bsT.getRoot());
//
//        System.out.print("\nDeleting Node 1: ");
//        bsT.delete(1, bsT.getRoot());
//        bsT.printTree(bsT.getRoot());

        BST.preTraversal(BST.getRoot());
        System.out.println("-------");
        BST.inOrderTraversal(BST.getRoot());
        System.out.println("-------");
        BST.postOrderTraversal(BST.getRoot());

    }

}
