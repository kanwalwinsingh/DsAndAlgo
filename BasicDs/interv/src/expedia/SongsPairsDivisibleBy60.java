package expedia;

public class SongsPairsDivisibleBy60 {
    public static int numPairsDivisibleBy60(int[] time){
        int[] remainderCount = new int[60];
        int count = 0;
        for(int song : time){
            int remainder = song%60;
            int complement = (60-remainder)%60;

            count += remainderCount[complement];

            remainderCount[remainder]++;

        }
        return count;
    }
    public static void main(String[] args) {
        int[] time = {30, 20, 150, 100, 40};
        System.out.println(numPairsDivisibleBy60(time));  // Output: 3
    }
}
