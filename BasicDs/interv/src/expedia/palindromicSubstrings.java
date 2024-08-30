package expedia;

public class palindromicSubstrings {
    public int countSubstrings(String s){
        int count = 0;
        for(int i = 0; i< s.length(); i++){
            //Count odd-length palindromes centered at s[i]
            count += countPalindromesAroundCenter(s,i,i);
            // count even-length palindromes centered between s[i] and s[i+1]
             count += countPalindromesAroundCenter(s,i,i+1);
        }
        return count;
    }
    private int countPalindromesAroundCenter(String s, int left, int right){
        int count = 0;
        while (left >= 0 && right< s.length() && s.charAt(left) == s.charAt(right)){
            count++;
            left--;
            right++;
        }
        return count;

    }
    public static void main(String[] args) {
        palindromicSubstrings solution = new palindromicSubstrings();
        String s = "abc";
        System.out.println("Number of palindromic substrings: " + solution.countSubstrings(s)); // Output: 3

        s = "aaa";
        System.out.println("Number of palindromic substrings: " + solution.countSubstrings(s)); // Output: 6
    }
}
