package microsoft;

public class SubstringCounter {

    public int numberofSubstring(String s){
        int[] count = new int[3]; // Array to keep track of count of 'a', 'b' and 'c'
        int left = 0;
        int right = 0;
        int result = 0;
        while (right<s.length()){
            //xpnad the window by moving the right pointer
            count[s.charAt(right)-'a']++;
            right++;

            //check if the current windows contain at least one of each 'a', 'b','c';
            while (count[0] >0 && count[1]>0 && count[2]>0){
                result+= s.length() -right +1;

                //Shrink the window by moving the lef pointer
                count[s.charAt(left) -'a' ]--;
                left++;
            }
        }
        return result;
     }
    public static void main(String[] args) {
        SubstringCounter counter = new SubstringCounter();
        String s = "aaacb";
        System.out.println("Number of substrings containing at least one of each 'a', 'b', 'c': " + counter.numberofSubstring(s));
    }
}
