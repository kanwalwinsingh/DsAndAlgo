package nikhil_lohia;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IsSubSequence {
    public static boolean isSubsequence(String s, String t){
        int i = 0, j =0;
        while ( i<s.length() && j<t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                if(i == s.length()) return true;
            }
            j++;

        }
        return (i == s.length());
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("axc","ahbgdc"));
    }
}
