package LeetCode;

public class LongestPalindromicSubstring {
//    public static String longestPalindrome(String s){
//        int n = s.length();
//        int mid = (n-1)/2;
//        int right = 0;
//        int left = 0;
//        if(n%2 == 0){
//        left = mid;
//        right = mid+1;
//        }else{
//            left = mid-1;
//            right = mid+1;
//        }
//
//        while (left>=0 && right<n ){
//            if(s.charAt(left) == s.charAt(right) ) {
//                left--;
//                right++;
//            }else{
//                break;
//            }
//
//        }
//       return s.substring(left+1,right);
//
//    }
//
//    public static void main(String[] args) {
//        System.out.println(longestPalindrome("babad"));
//    }
}
