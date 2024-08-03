package nikhil_lohia;
import java.util.*;
public class SortingTheSentance {
    static String sortSentenace(String s){
        Map<Integer,String> map = new TreeMap<>();
        String[] splitedString = s.split(" ");
        for(String word: splitedString){
            int lastIndex = word.length()-1;
            int index = word.charAt(lastIndex)-'0';
            String actualWord = word.substring(0,lastIndex);
            map.put(index, actualWord);
        }
        StringBuilder finalString = new StringBuilder();
        for (Map.Entry<Integer,String> wordIndex : map.entrySet()){
            finalString.append(wordIndex.getValue()).append(" ");

        }

        return finalString.toString();
    }

    public static void main(String[] args) {
        System.out.println(sortSentenace("is2 sentence4 This1 a3"));
        System.out.println(sortSentenace("Myself2 Me1 I4 and3"));
    }
}
