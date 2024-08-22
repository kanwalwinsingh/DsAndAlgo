package expedia;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> anagramMap = new HashMap<>();
        for(String str : strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);
            if(!anagramMap.containsKey(sortedString)) {
                anagramMap.put(sortedString, new ArrayList<>());
            }
                anagramMap.get(sortedString).add(str);
        }
        return new ArrayList<>(anagramMap.values());
    }
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams solution = new GroupAnagrams();

        List<List<String>> result = solution.groupAnagrams(strs);
        System.out.println(result);
    }
}
