package main.java.hashing.basichashlogic;

public class HashEntry {
    String key;
    int value;

    HashEntry next;

    public HashEntry(String key, int value){
        this.key = key;
        this.value = value;
    }
}
