package LeetCode;

public class EditDistance {
   public int minDistance(String word1, String word2){
       int m = word1.length();
       int n = word2.length();

       //Ensure the smaller string is used to optimize the space
       if(m<n){
           return minDistance(word2,word1);
       }

       //Create two 1D dp arrays
       int[] prev = new int[n+1];
       int[] curr = new int[n+1];

       //initialize the base case for the smaller string
       for(int j =0; j<= n; j++){
           prev[j] = j;
       }
       //Fill the dp table
       for(int i =1; i<= m; i++){
           curr[0] = i;
           for(int j =1; j<=n; j++){
               if(word1.charAt(i-1) == word2.charAt(j-1)){
                   curr[j] = prev[j-1];
               }else{
                   curr[j] = 1+ Math.min(
                           prev[j], Math.min(curr[j-1],prev[j-1])
                   );
               }
           }
           //Swap the current and previous arrays
           int[] temp = prev;
           prev = curr;
           curr = temp;
       }
       return prev[n];
   }
    public static void main(String[] args) {
        EditDistance ed = new EditDistance();
        String word1 = "intention";
        String word2 = "execution";
        System.out.println(ed.minDistance(word1, word2));  // Output: 5
    }
}
