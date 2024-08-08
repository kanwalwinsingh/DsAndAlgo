package nikhil_lohia;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        Map<Character,Character> charMappingMap = new HashMap<>();
        for(int i =0; i<s.length(); i++){
            char original = s.charAt(i);
            char replacment = t.charAt(i);
            if(!charMappingMap.containsKey(original)){
                if(!charMappingMap.containsValue(replacment)){
                    charMappingMap.put(original, replacment);
                }else{
                    return false;
                }
            }else{
                char mappedCharacter = charMappingMap.get(original);
                if(mappedCharacter != replacment)
                    return false;
            }
        }
        return true;
    }

    public boolean isIsoMorphicStrings(String s, String t){
        int[] map = new int[256];
        boolean[] mapped = new boolean[256];
        for(int i =0; i<s.length(); i++){
            if(map[s.charAt(i)] == 0){
                if(mapped[t.charAt(i)]){
                    return false;
                }
                map[s.charAt(i)] = t.charAt(i);
                mapped[t.charAt(i)] = true;
            }else{
                if(map[s.charAt(i)] != t.charAt(i)){
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        IsomorphicStrings solution = new IsomorphicStrings();

        // Example usage
        System.out.println(solution.isIsoMorphicStrings("egg", "add")); // Output: true
        System.out.println(solution.isIsoMorphicStrings("foo", "bar")); // Output: false
        System.out.println(solution.isIsoMorphicStrings("paper", "title")); // Output: true
    }
}
