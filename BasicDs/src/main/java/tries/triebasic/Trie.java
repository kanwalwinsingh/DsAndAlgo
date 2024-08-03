package main.java.tries.triebasic;

public class Trie {
    public TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    //Function to get the index of the character 'x'
    public int getIndex(char x){
        return x-'a'; // the index is based on the position of character in alphabets
    }

    //Function to insert a key in the Trie
    public void insert(String key){
        if(key == null){
            System.out.println("Null keys can not be Inserted");
            return;
        }
        key = key.toLowerCase(); // Keys are stored in lower case
        TrieNode currentNode = this.root;
        int index = 0; //to store character index;

        //Iterate the trie with given character index,
        //If it is null, then simply create a TrieNode and go down a level
        for(int level =0; level<key.length(); level++){
            index = getIndex(key.charAt(level));
            if(currentNode.children[index] == null){
                currentNode.children[index] = new TrieNode();
            }
            currentNode = currentNode.children[index];
        }
        //Mark the end of character
        currentNode.markAsLeaf();
    }

    //Function to search given key in trie
    public boolean search(String key){
        if(key == null) return false;
        key = key.toLowerCase();
        TrieNode currentNode = this.root;
        int index = 0;

        //Iterate the Trie with given character index,
        //If it is null at any point then we stop and return false
        //We will return true only if we reach leafNode and have traveresed the trie based on the length of the key
        for(int level =0; level<key.length(); level++){
            index = getIndex(key.charAt(level));
            if(currentNode.children[index] == null){
                return false;
            }
            currentNode = currentNode.children[index];
        }
        return currentNode.isEndWord;
    }

    //Helper function to return true if currentNode does not have any children
    private boolean hasNoChildren(TrieNode currentNode){
        for (int i =0; i<currentNode.children.length; i++){
            if((currentNode.children[i]!=null)){
                return false;
            }
        }
        return true;
    }

    //Recursive function to delete given key
    private boolean deleteHelper(String key, TrieNode currentNode, int length, int level){
        boolean deleteSelf = false;
        if (currentNode == null){
            System.out.println("Keys does not exist");
            return deleteSelf;
        }

        //Base Case:- If we have reached at the node which points to the alphabet at the end of the key.
        if(level == length){
            //If there are no nodes ahead of this node in this path then we can delete this node
            if(hasNoChildren(currentNode)){
                currentNode = null;
                deleteSelf = true;
            }else { // If there nodes ahead of currentNode in this path Then we cannot delete currentNode. We simply unmark this as leaf
                currentNode.unMarkAsLeaf();
                deleteSelf = false;
            }
        }else{
            TrieNode childNode = currentNode.children[getIndex(key.charAt(level))];
            boolean childDeleted = deleteHelper(key,childNode,length,level+1);
            if(childDeleted){
                //Making children pointer also null; since child is deleted
                currentNode.children[getIndex(key.charAt(level))] = null;
                //If currentNode is leaf node that means current Node is part of another key and hence we cannot delete this node and its parent nodes
                if(currentNode.isEndWord){
                    deleteSelf = false;
                }
                //If childNode is deleted but if currentNode has more Children then currentNode must be part of another key so we cannot delete current node
                else if(!hasNoChildren(currentNode)){
                    deleteSelf = false;
                }else{ // else we can delete currentNode
                    currentNode  = null;
                    deleteSelf = true;
                }
            }else{
                deleteSelf = false;
            }
        }
        return deleteSelf;
    }

    //Function to delete given key from trie
    public void delete(String key){
        if((root == null) || (key == null) ){
            System.out.println("Null key or Empty trie error");
            return;
        }
        deleteHelper(key,root,key.length(),0);
    }
}
