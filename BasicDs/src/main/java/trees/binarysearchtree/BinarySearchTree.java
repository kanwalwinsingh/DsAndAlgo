package main.java.trees.binarysearchtree;

public class BinarySearchTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    //Iterative function to insert a value in BST
    public boolean add(int value) {
        // If tree is empty then insert root with the given value inside tree
        if (isEmpty()) {
            root = new Node(value);
            return true;
        }
        //Starting from root
        Node currentNode = root;

        //Traversing the tree untill valid position to insert the value
        while (currentNode != null) {
            Node leftChild = currentNode.getLeftChild();
            Node rightChild = currentNode.getRightChild();

            //If the value to insert is less than root value then move to left subtree
            //else move to the right subtree of root
            //and before moving check if the subtree is null, if its then insert the value.
            if (currentNode.getData() > value) {
                if (leftChild == null) {
                    leftChild = new Node(value);
                    currentNode.setLeftChild(leftChild);
                    return true;
                }
                currentNode = leftChild;
            } else {
                if (rightChild == null) {
                    rightChild = new Node(value);
                    currentNode.setRightChild(rightChild);
                    return true;
                }
                currentNode = rightChild;
            }
        }
        return false;
    }

    //Recursive function to insert a value in BST
    public Node recursive_insert(Node currentNode, int value) {
        //Base case
        if (currentNode == null) {
            return new Node(value);
        }
        if (value < currentNode.getData()) {
            currentNode.setLeftChild(recursive_insert(currentNode.getLeftChild(), value));
        } else {
            currentNode.setRightChild(recursive_insert(currentNode.getRightChild(), value));
        }
        // value already exist
        return currentNode;
    }

    public boolean rec_add(int value) {
        root = recursive_insert(root, value);
        return true;
    }

    // Search value in BST using the iterative, Either return the node with that value or return null
    public Node search(int value) {
        if (isEmpty()) return null;

        Node currentNode = this.getRoot();
        while (currentNode != null) {
            if (currentNode.getData() == value) return currentNode;

            if (currentNode.getData() > value) {
                currentNode = currentNode.getLeftChild();
            } else {
                currentNode = currentNode.getRightChild();
            }
        }
        System.out.println(value + " Not found in the Tree!!");
        return null;
    }

    //Search function using the recursive search
    public Node search_recursive(Node currentNode, int value) {
        if (currentNode == null || currentNode.getData() == value) {
            return currentNode;
        }
        if (value < currentNode.getData()) {
            return search_recursive(currentNode.getLeftChild(), value);
        } else {
            return search_recursive(currentNode.getRightChild(), value);
        }
    }

    public Node recursiveSearch(int value) {
        if (isEmpty()) return null;
        Node currentNode = this.root;
        return search_recursive(currentNode, value);
    }


    //Function to check if tree is empty or not
    public boolean isEmpty() {
        return root == null;
    }

    public void printTree(Node current) {
        if (current == null) {
            return;
        }
        System.out.print(current.getData() + ",");
        printTree(current.getLeftChild());
        printTree(current.getRightChild());
    }

    //3 conditions for delete
    //1.node is leaf node.
    //2.node has 1 child.
    //3.node has 2 children.
    boolean delete(int value, Node currentNode) {

        if (root == null) {
            return false;
        }

        Node parent = null; //To Store parent of currentNode
        while(currentNode != null && (currentNode.getData() != value)) {
            parent = currentNode;
            if (currentNode.getData() > value)
                currentNode = currentNode.getLeftChild();
            else
                currentNode = currentNode.getRightChild();

        }

        if(currentNode == null) {
            return false;
        }
        else if(currentNode.getLeftChild() == null && currentNode.getRightChild() == null) {
            //1. Node is Leaf Node
            //if that leaf node is the root (a tree with just root)
            if(root.getData() == currentNode.getData()){
                setRoot(null);
                return true;
            }
            else if(currentNode.getData() < parent.getData()){
                parent.setLeftChild(null);
                return true;
            }
            else{
                parent.setRightChild(null);
                return true;
            }
        } else if(currentNode.getRightChild() == null) {

            if(root.getData() == currentNode.getData()){
                setRoot(currentNode.getLeftChild());
                return true;
            }
            else if(currentNode.getData() < parent.getData()){
                parent.setLeftChild(currentNode.getLeftChild());
                return true;
            }
            else{

                parent.setRightChild(currentNode.getLeftChild());
                return true;
            }

        }
        else if(currentNode.getLeftChild() == null) {

            if(root.getData() == currentNode.getData()){
                setRoot(currentNode.getRightChild());
                return true;
            }
            else if(currentNode.getData() < parent.getData()){
                parent.setLeftChild(currentNode.getRightChild());
                return true;
            }
            else{
                parent.setRightChild(currentNode.getRightChild());
                return true;
            }

        }
        else {
            //Find Least Value Node in right-subtree of current Node
            Node leastNode = findLeastNode(currentNode.getRightChild());
            //Set CurrentNode's Data to the least value in its right-subtree
            int temp = leastNode.getData();
            delete(temp, root);
            currentNode.setData(temp);
            //Delete the leafNode which had the least value
            return true;
        }

    }

    //Helper function to find least value node in right-subtree of currentNode
    private Node findLeastNode(Node currentNode) {

        Node temp = currentNode;

        while (temp.getLeftChild() != null) {
            temp = temp.getLeftChild();
        }

        return temp;

    }

    public void preTraversal(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.getData()+",");
        preTraversal(root.getLeftChild());
        preTraversal(root.getRightChild());
    }

    public void inOrderTraversal(Node root){
        if(root == null) return;

        inOrderTraversal(root.getLeftChild());
        System.out.print(root.getData()+", ");
        inOrderTraversal(root.getRightChild());

    }

    public void postOrderTraversal(Node root){
        if(root == null) return;

        postOrderTraversal(root.getLeftChild());
        postOrderTraversal(root.getRightChild());
        System.out.print(root.getData()+",");

    }


}
