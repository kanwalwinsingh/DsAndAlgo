package nikhil_lohia;

import java.util.HashSet;
import java.util.Set;

public class CheckIfStringIsPanagram {
    public boolean checkIfPanagram(String sentence){
        boolean[] visited = new boolean[26];
        for (int i =0; i<sentence.length(); i++){
            visited[sentence.charAt(i)-'a'] = true;
        }
        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    public boolean checkIfpanagramUsinghashSet(String sentence){
        Set<Character> alphabetSet = new HashSet<>();
        for (int i ='a'; i<='z'; i++){
            alphabetSet.add((char) i);
        }
        for(int i =0; i<sentence.length(); i++){
            alphabetSet.remove(sentence.charAt(i));
            if(alphabetSet.isEmpty())
                return true;
        }
        return false;
    }
}
