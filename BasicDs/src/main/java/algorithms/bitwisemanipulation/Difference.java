package main.java.algorithms.bitwisemanipulation;

public class Difference {
    public static int extraCharacterIndex(String str1, String str2){
        int result =0;
        int index = 0;
        int str1Length = str1.length();
        int str2Length = str2.length();
        for(int i =0; i< str1.length(); i++){
            result ^= str1.charAt(i);
        }
        for(int j =0; j<str2Length; j++){
            result^=str2.charAt(j);
        }
        if(str1Length>str2Length){
            index = str1.indexOf((char)(result));
            return index;
        }
        else{
            index = str2.indexOf((char)(result));
            return index;
        }
    }
    public static void main(String[] args) {
        // Driver code
        // Example - 1
        String[] string1 = {
                "wxyz",
                "cbda",
                "jlkmn",
                "courae",
                "hello"
        };
        String[] string2 = {
                "zwxgy",
                "abc",
                "klmn",
                "couearg",
                "helo"
        };
        for (int i = 0; i < string1.length; i++) {
            System.out.println(i + 1 + ".\tString1 = " + string1[i] + " \n\tString2 = " + string2[i]);
            System.out.println("\n\tThe extra character is at index: "  + extraCharacterIndex(string1[i], string2[i]));
            System.out.println("------------------------");
        }
    }
}
