package leetcodetop75;

public class ReverseWordInString {
    public static String reverseWords(String s) {
        String[] strArray = s.trim().split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = strArray.length-1; i>0; i--){
                stringBuilder.append(strArray[i]);
                stringBuilder.append(" ");
        }
        return stringBuilder.append(strArray[0]).toString();
    }
//
//    public static String reverseWordsWithoutInBuiltFunction(String s){
//        //Convert the string to a character array
//        char[] charArray = s.toCharArray();
//
//        //Step 1 : Reverse the entire string
//        reverse(charArray,0,charArray.length-1);
//    }
//
//    private static void reverse(char[] charArray, int start, int end){
//        while (start< end){
//            char temp = charArray[start];
//            charArray[start] = charArray[end];
//            charArray[end] = temp;
//            start++;
//            end--;
//        }
//    }
//
//    private static void reverseWordsInCharArray(char[] charArray){
//        int n = charArray.length;
//        int start = 0, end = 0;
//        while (start<n){
//            //Skip spaces to find the start of the word
//            while (start<end || start<n && charArray[start] == ' ')start++;
//            //Find the end of the word
//            while (end<start || end<n && charArray[end] != ' ') end++;
//            //Reverse the word
//            reverse(charArray,start,end-1);
//        }
//
//    }

    public static void main(String[] args) {
        System.out.println(reverseWords("a good   example"));
    }
}
