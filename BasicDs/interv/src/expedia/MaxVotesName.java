package expedia;

import java.util.HashMap;
import java.util.Map;

public class MaxVotesName {

    public static String findMaxVotes(String[] names){
        Map<String, Integer> voteCount = new HashMap<>();
        String maxName = "";
        int maxVotes = 0;
        for(String name : names){
            voteCount.put(name,voteCount.getOrDefault(name,0)+1);
            int currentVotes = voteCount.get(name);
            //Check if current name has more vote or is lexicographically larger in case of a tie
            if(currentVotes > maxVotes || (currentVotes == maxVotes && name.compareTo(maxName) >0)){
                maxVotes = currentVotes;
                maxName = name;
            }
        }
        return maxName;
    }
    public static void main(String[] args) {
        String[] names = {"Alice", "Bob", "Alice", "Bob", "Charlie", "Bob"};
        System.out.println("Name with maximum votes: " + findMaxVotes(names));
    }
}
