package main.java.stringsproblems;

import javax.imageio.plugins.tiff.TIFFDirectory;
import javax.sound.midi.MidiFileFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class FindIfTwoStringAreAnagramToEachOther {

    static boolean areAnagram(char[] str1, char[] str2) {
        // Get length of both strings
        int n1 = str1.length;
        int n2 = str2.length;

        // if llength of both string are not same then they cannot b anagram
        if (n1 != n2) {
            return false;
        }

        //sort both the arrays
        Arrays.sort(str1);
        Arrays.sort(str2);

        // compare sorted string
        for (int i = 0; i < n1; i++) {
            if (str1[i] != str2[i]) {
                return false;
            }
        }
        return true;
    }

    static boolean areAnagramUsingTwoCountArray(char str1[], char str2[]) {
        // Create 2 count arrays and initalize all value as zero
        if (str1.length != str2.length)
            return false;

        int NO_OF_CHARS = 256;
        int count1[] = new int[NO_OF_CHARS];
        int count2[] = new int[NO_OF_CHARS];

        int i;

        //for each character in input strings, increment count in the corresponding count array
        for (i = 0; i < str1.length && i < str2.length; i++) {
            count1[str1[i]]++;
            count2[str2[i]]++;
        }
        //compare count arrays
        for (i = 0; i < NO_OF_CHARS; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean areAnagramsUsingHashMap(String a, String b){
        if(a.length() != b.length()){
            return false;
        }

        //create a HashMap containing character as key and Integer as value. we will be storing character as key and count of character as value
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i =0; i< a.length(); i++){
            char charAtI = a.charAt(i);
            if(map.containsKey(charAtI)){
                map.put(charAtI, map.get(charAtI)+1);
            }else{
                map.put(charAtI,1);
            }
        }

        //Now loop over string b
        for (int i =0; i< b.length(); i++){
            char charAtI = b.charAt(i);
            if(map.containsKey(charAtI)){
                map.put(charAtI, map.get(charAtI) -1);
            }else{
                return false;
            }
        }

        Set<Character> keys = map.keySet();
        for(Character key : keys){
            if(map.get(key)!= 0)
                return false;
        }
        return true;
    }
    public static void main(String args[])
    {
        char str1[] = ("gram").toCharArray();
        char str2[] = ("mrag").toCharArray();

        // Function call
        if (areAnagramUsingTwoCountArray(str1, str2))
            System.out.println("The two strings are"
                    + " anagram of each other");
        else
            System.out.println("The two strings are not"
                    + " anagram of each other");
    }
}
