package LeetCode;

public class LRUCache {
    private class ListNode {
        ListNode prev, next;
        int key, value;
        ListNode(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    ListNode head, tail;
    public int capacity, count;
    ListNode[] map;
    public LRUCache(int capacity){
        this.capacity = capacity;
        count = 0;
        map = new ListNode[10_000+1];
        head = new ListNode(0,0);
        tail = new ListNode(0,0);
        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
    }

    public int get(int key){
        if(map[key]!=null){
            ListNode node = map[key];
            int nodeVal = node.value;
            remove(node);
            insert(node);
            return nodeVal;
        }
        return -1;
    }

    public void put(int key, int value){
        if(map[key]!=null){
            ListNode node = map[key];
            node.value = value;
            remove(node);
            insert(node);
        }else{
            ListNode node = new ListNode(key,value);
            map[key] = node;
            if(count<capacity){
                count++;
                insert(node);
            }else {
                map[tail.prev.key] = null;
                remove(tail.prev);
                insert(node);
            }
        }
    }
    public void remove(ListNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insert(ListNode node){
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1); // Cache is {1=1}
        lruCache.put(2, 2); // Cache is {1=1, 2=2}
        System.out.println(lruCache.get(1)); // Returns 1
        lruCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lruCache.get(2)); // Returns -1 (not found)
        lruCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lruCache.get(1)); // Returns -1 (not found)
        System.out.println(lruCache.get(3)); // Returns 3
        System.out.println(lruCache.get(4)); // Returns 4
    }

}
