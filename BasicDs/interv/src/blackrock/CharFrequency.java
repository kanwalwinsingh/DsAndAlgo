package blackrock;

import java.util.HashMap;
import java.util.Map;

public class CharFrequency {
    static final int SIZE = 26;


    static void printCharFrequency(String str){
        int n = str.length();
        int[] freq = new int[SIZE];
        str = str.toLowerCase();
        for (int i =0; i< n; i++){
            freq[str.charAt(i)-'a']++;
        }
        for(int i =0; i <n; i++){
            if (freq[str.charAt(i) - 'a'] !=0){
                System.out.print(str.charAt(i)+" ");
                System.out.println(freq[str.charAt(i)-'a']+ " ");


                freq[str.charAt(i)- 'a'] = 0;
            }
        }
    }

    static void charFreq(String str){
        int n = str.length();
        Map<Character,Integer> charmap = new HashMap<>();

        for (int i =0; i<n; i++){
            char ch = str.charAt(i);
            if (charmap.containsKey(ch)){
                charmap.put(ch,charmap.get(ch)+1);
            }else{
                charmap.put(ch,1);
            }
        }

        for(Character ch1 : charmap.keySet()){
            System.out.println(ch1 + " "+charmap.get(ch1));
        }
}

    public static void main(String args[])
    {
        String str = "geeksforgeeks";
        charFreq(str);
    }

}
