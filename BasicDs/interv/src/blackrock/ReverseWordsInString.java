package blackrock;

public class ReverseWordsInString {

    static void reverseWord(String s){
        s = s.trim();
        String[] split = s.split(" ");
        for(int i = split.length-1; i>=0; i--){
            System.out.print(split[i]+" ");
        }
        System.out.println("-");
    }

    public static String[] revStringUsingSwapping(String[] strings, int length){
        //check if word is even
        if(length%2 == 0){
            //find the middle word
            int middle = length/2;

            //Starting from the middle start swapping words at the jth position and l-1-j position
            while(middle<= length-1){
                String temp;
                temp = strings[length-middle-1];
                strings[length-middle-1] = strings[middle];
                strings[middle] = temp;
                middle++;
            }
        }
        else { // the no of words are odd
            // find the middle word
            int  middle = (length/2) +1;
            while(middle<= length-1){
                String temp;
                temp = strings[length-middle-1];
                strings[length-middle-1] = strings[middle];
                strings[middle] = temp;
                middle++;
            }
        }
        return strings;
    }

    public static void main(String[] args) {
        reverseWord("i like this program very much ");

        String[] sArr = "i like this program very much".split(" ");
      String[] reversedWord =   revStringUsingSwapping(sArr,sArr.length);
      for (int i =0; i< reversedWord.length; i++){
          System.out.print(reversedWord[i]+" ");
      }
    }
}
