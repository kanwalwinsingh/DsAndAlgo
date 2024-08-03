package LeetCode;

public class CountAndSay {
    public static String countAndSay(int n){
        if(n<=0){
            return "";
        }
        String result = "1";
        for(int i = 2; i<= n; i++){
            result = getNext(result);
        }
        return result;
    }

    public static String getNext(String s){
        StringBuilder builder = new StringBuilder();
        int count = 1;
        char currentChar = s.charAt(0);
        for(int i =1; i< s.length(); i++){
            if(s.charAt(i) == currentChar){
                count++;
            }else{
                builder.append(count).append(currentChar);
                currentChar = s.charAt(i);
                count = 1;
            }
        }
        builder.append(count).append(currentChar);
        return builder.toString();
    }
    public static void main(String[] args) {
        int n = 5;  // Example input
        System.out.println("The " + n + "th element in the count-and-say sequence is: " + countAndSay(n));
    }
}
