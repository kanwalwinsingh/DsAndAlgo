package nikhil_lohia;

/**
 * https://leetcode.com/problems/length-of-last-word/description/
 */
public class LengthOfthelastWord {
    public int lengthOfLastWord(String s){
        int count = 0;
        for (int i = s.length()-1; i>=0; i--){
            if(s.charAt(i) != ' '){
                count++;
            }else{
               if(count>0){
                   break;
               }
            }
        }
        return count;
    }
}
