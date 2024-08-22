package expedia;

public class MyhashMap {
    private static  class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    private Node[] buckets;
    private int size;
    private final double loadFactor;

    public MyhashMap(){
        this(16,0.75);
    }

    public MyhashMap(int initialCapacity, double loadFactor){
        this.buckets = new Node[initialCapacity];
        this.loadFactor = loadFactor;
    }

    private int hash(int key){
        //Implement a suitable hash function
        return key % buckets.length;
    }

    public void put(int key, int value){
        int index = hash(key);
        Node head = buckets[index];
        while (head != null){
            if(head.key == key){
                head.value = value;
                return;
            }
            head = head.next;
        }

        // Insert new node at the beginning
        Node newNode = new Node(key,value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
        size++;

        //Check if resizing is required
        if(loadFactor() >= loadFactor){
            resize();
        }
    }

    public int get(int key){
        int index = hash(key);
        Node head = buckets[index];
        while (head != null){
            if(head.key == key){
                return head.key;
            }
            head = head.next;
        }
        return -1;
    }

    public void remove(int key){
        int index = hash(key);
        Node head = buckets[index];
        Node prev = null;
        while (head != null){
            if(head.key == key){
                if (prev == null){
                    buckets[index] = head.next;
                }else{
                    prev.next = head.next;
                }
                size--;
                return;
            }
            prev = head;
            head = head.next;
        }
    }

    private double loadFactor(){
        return (double) size/buckets.length;
    }

    private void resize(){

    }
}
