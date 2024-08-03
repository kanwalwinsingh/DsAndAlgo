package nikhil_lohia;

import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeStrings {
    public String decodeString(String s) {
        Deque<String> stringStack = new ArrayDeque<>();
        Deque<Integer> intStack = new ArrayDeque<>();
        int k = 0;
        char[] chars = s.toCharArray();
        for(int i =0; i<chars.length; i++) {
            char c = chars[i];
            if (Character.isDigit(c)) {
                k = (k * 10) + (c - '0');
                continue;
            }
            if (c == '[') {
                intStack.push(k);
                k = 0;
                stringStack.push(String.valueOf(c));
                continue;
            }
            if (c != ']') {
                stringStack.push(String.valueOf(c));
                continue;
            }
            StringBuilder temp = new StringBuilder();
            while (!stringStack.peek().equals("["))
                temp.insert(0, stringStack.pop());

            stringStack.pop();

            StringBuilder replacment = new StringBuilder();
            int count = intStack.pop();
            for (int j = 0; j < count; j++) {
                replacment.append(temp);
            }

            stringStack.push(replacment.toString());
        }
            StringBuilder result = new StringBuilder();
            while (!stringStack.isEmpty()){
                result.insert(0,stringStack.pop());
            }
            return result.toString();

        }

}
