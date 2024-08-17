package agoda;

public class PermutationInString {

    public boolean checkInclusion(String  s1, String s2){
        //Base condition
        if(s1.length() > s2.length()){
            return false;
        }

        //Create a frequency map for s1
        int[] s1Map = new int[26];
        for(char c: s1.toCharArray()){
            s1Map[c-'a']++;
        }

        //Create a frequency map for the first window in s2
        int[] s2Map = new int[26];
        for(int i =0; i< s1.length(); i++){
            s2Map[s2.charAt(i) -'a']++;
        }

        //Sliding window over s2
        for(int i = 0; i<= s2.length() - s1.length(); i++){
            //check for the current window matches the frequency map of s1
            if(matches(s1Map, s2Map)){
                return true;
            }

            // Slide the window: remove the left character and add the next character
            if(i + s1.length() < s2.length()){
                s2Map[s2.charAt(i) -'a']--;
                s2Map[s2.charAt(i+s1.length())-'a']++;
            }
        }
        return false;
    }

    private boolean matches(int[] s1Map, int[] s2Map){
        for(int i =0; i<26;i++){
            if(s1Map[i] != s2Map[i]){
                return false;
            }
        }
        return true;
    }

    // Driver Code
    public static void main(String[] args) {
        PermutationInString solution = new PermutationInString();

        String s1 = "ab";
        String s2 = "eidbaooo";

        boolean result = solution.checkInclusion(s1, s2);
        System.out.println("Does s2 contain a permutation of s1? " + result); // Expected Output: true
    }
}
