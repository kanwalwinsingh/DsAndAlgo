package nikhil_lohia;

import java.util.HashSet;
import java.util.Set;

public class FindJewlesInStone {
    public int numJewelsInStone(String jewels, String stones){
        Set<Character> jewelsSet = new HashSet<>();
        for(int i =0; i<jewels.length(); i++){
            jewelsSet.add(jewels.charAt(i));
        }
        int count = 0;
        for(int i = 0; i<stones.length(); i++){
            if(jewelsSet.contains(stones.charAt(i))){
                count++;
            }
        }
        return count;
    }
}
