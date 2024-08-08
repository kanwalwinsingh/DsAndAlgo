package leetcodetop75;

import java.util.HashMap;
import java.util.Map;

public class StringCompression {
    public static int compress(char[] chars) {
        Map<Integer,Integer> myMap = new HashMap<>();
        for(char c :  chars){
           myMap.put(c-'a',myMap.getOrDefault(c-'a',0)+1);
        }
        StringBuilder sp = new StringBuilder();
        for(Integer ch : myMap.keySet()){
            sp.append(ch);
            int val = myMap.get(ch);
            if(val>1) {
            sp.append(val);
            }
        }
       return sp.length();
    }

    public static void main(String[] args) {
        char[] cha = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(compress(cha));
    }
}
