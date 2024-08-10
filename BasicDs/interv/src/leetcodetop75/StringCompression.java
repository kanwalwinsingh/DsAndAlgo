package leetcodetop75;

import java.util.HashMap;
import java.util.Map;

public class StringCompression {
    public static int compress(char[] chars) {
        int n = chars.length;
        int index = 0; // This pointer keeps track of where to write in the array
        for(int i =0; i<n;){
        char currentChar = chars[i];
        int count = 0;

        //Count the number of consecutive repeating character
            while (i<n && chars[i] == currentChar){
                i++;
                count++;
            }

            //Write the character to the array
            chars[index++] = currentChar;

            //If the count is greater than 1, write the digits of the count
            if(count >1){
                for(char c: Integer.toString(count).toCharArray()){
                    chars[index++] = c;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        char[] cha = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(compress(cha));
    }
}
