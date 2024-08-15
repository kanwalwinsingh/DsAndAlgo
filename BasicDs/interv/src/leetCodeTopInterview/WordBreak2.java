package leetCodeTopInterview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordBreak2 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> results = new ArrayList<>();

        backTrack(s,results,new StringBuilder(),0,new HashSet<>(wordDict));
        return results;
    }
    public void backTrack(String s, List<String> resultList, StringBuilder currentSentence, int index, HashSet<String> wordDict){
        if(s.length() == index){
            resultList.add(currentSentence.toString().trim());
        }
        for (int end = index+1; end <= s.length(); end++){
            String word = s.substring(index,end);
            if(wordDict.contains(word)){
                int currentLength = currentSentence.length();
                currentSentence.append(word).append(" ");
                backTrack(s,resultList,currentSentence,end,wordDict);
                currentSentence.setLength(currentLength);
            }
        }
    }
}
