package main.java.hashing.basichashlogic;

public class HashFunctions {
    public static int hashModular(int key, int size) {
        return key % size;
    }

    public static int hashTruncate(int key) {
        return key % 500;
    }

    public static int hashFold(int key, int chunkSize) {
        System.out.println("Key: " + key);
        String strKey = Integer.toString(key);
        int hashVal = 0;
        System.out.println("Chunks:");
        for (int i = 0; i < strKey.length(); i += chunkSize) {
            if (i + chunkSize < strKey.length()) {
                System.out.println(strKey.substring(i, i + chunkSize));
                hashVal += Integer.parseInt(strKey.substring(i, i + chunkSize));
            } else {
                System.out.println(strKey.substring(i, strKey.length()));
                hashVal += Integer.parseInt(strKey.substring(i, strKey.length()));
            }
        }
        return hashVal;
    }

    public static void main(String args[]) {
        int[] ist = new int[10];
        int key = 35;
        int index = hashModular(key, 10);
        System.out.println("The index for key " + key + " is " + index);

        key = 123456;
        index = hashTruncate(key); // Fit the key into the list size
        System.out.println("The index for key " + key + " is " + index);

        key = 3456789;
        int chunkSize = 2;
        System.out.println("Hash Key: " + hashFold(key, chunkSize));
    }
}
