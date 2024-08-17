package agoda;

public class AlphanumericFilter {
    public static String filterAlphanumeric(String input){
        //Using the Strinbuilder for efficent string manipulation
        StringBuilder result = new StringBuilder();

        //Traverse the input string  character by character
        for(char c : input.toCharArray()){
            //Check if the character is alphanumeric
            if(Character.isLetterOrDigit(c)){
                result.append(c); // Appeend the alphanumeric character to the result
            }
        }
        //Convert the Stringbuilder to string and return it
        return result.toString();
    }

    //Helper method to determine if a character is a letter
    private static boolean isLetter(char c){
        return (c>='A' && c<='Z' || (c>='a' && c<='z'));
    }

    //Helper method to determine if a character is a digit
    private static boolean isDigit(char c){
        return c>='0' && c<='9';
    }

    //Method to filter alphanumeric character from a string
    public static String filterAlphanumericWithoutInternalMetohd(String input){
        if(input == null){
            return "";
        }

        //Using a Strngbuilder for efficent string manipulation
        StringBuilder result = new StringBuilder();

        //Traverse the input string character by character
        for(int i =0; i<input.length();i++){
            char c = input.charAt(i);
            if(isDigit(c) || isLetter(c)){
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String input = "Hello, World! 1234 @#$$%";
        String filtered = filterAlphanumericWithoutInternalMetohd(input);
        System.out.println("Filtered String: " + filtered);
    }
}
