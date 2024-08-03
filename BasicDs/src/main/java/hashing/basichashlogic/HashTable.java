package main.java.hashing.basichashlogic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

public class HashTable {
    private ArrayList<HashEntry> bucket;
    private int slots;
    private int size;

    public HashTable(){
        bucket = new ArrayList<>();
        slots = 10;
        size = 0;
        for(int i =0; i<slots;i++){
            bucket.add(null);
        }
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    private int getIndex(String key){
        int hashCode = key.hashCode();
        int index = hashCode%slots;
        if(index<0){
            index = (index+slots)%slots;
        }
        return index;
    }

    //Insert a key value pair into the table
    public void insert(String key, int value){
        //Find head of the chain
        int b_index = getIndex(key);
        HashEntry head = bucket.get(b_index);
        //Check if the key already exists
        while (head!=null){
            if(head.key.equals(key)){
                head.value =value;
            }
            head = head.next;
        }
        //Insert key in the chain
        size++;
        head = bucket.get(b_index);
        HashEntry new_slot = new HashEntry(key,value);
        new_slot.next = head;
        bucket.set(b_index,new_slot);

        //Checks if array >60% of the arrray get filled
        if((1.0*size)/slots >= 0.6){
            ArrayList<HashEntry> temp = bucket;
            bucket = new ArrayList<>();
            slots = 2*slots;
            size = 0;
            for(int i =0; i<slots;i++){
                bucket.add(null);
            }
            for(HashEntry head_node : temp){
                while (head_node != null){
                    insert(head_node.key, head_node.value);
                    head_node = head_node.next;
                }
            }
        }
    }

    //Return a value for a given key
    public int getvalue(String key){
        //Find the head of the chain
        int b_index = getIndex(key);
        HashEntry head = bucket.get(b_index);
        //Search key in slots
        while (head!=null){
            if(head.key.equals(key))
                return head.value;
            head = head.next;
        }
        return -1;
    }

    //Remove a value based with key
    public int delete(String key){

        //Find index
        int b_index = getIndex(key);

        //Get head of the chain for that index
        HashEntry head = bucket.get(b_index);

        //Find the key in slots
        HashEntry prev = null;
        while (head!=null){
            //If key exists
            if(head.key.equals(key))
                break;
            prev = head;
            head = head.next;
        }
        //If key does not exist
        if(head == null)
            return -1;

        //Decrease the size by one
        size--;

        //Remove key
        if(prev!=null){
            prev.next = head.next;
        }else{
            bucket.set(b_index,head.next);
        }
        return head.value;
    }


}
