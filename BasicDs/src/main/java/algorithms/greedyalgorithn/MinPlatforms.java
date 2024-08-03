package main.java.algorithms.greedyalgorithn;

import java.util.Arrays;

public class MinPlatforms {
    static int findPlatform(int[] arrival, int[] departure){ // bruteforce O(n2)
        int n = arrival.length;
        int result =0, count = 0;
        for(int index =0; index<n; index++){
            count = 0;
            for(int i = 1; i<n;i++){
                if(arrival[i] >= arrival[index] && arrival[i] <= departure[index]){
                    count++;
                }
            }
            if(result<count)
                result = count;
        }
        return result;
    }

    public static int findPlatformUsingGreedy(int[] arrival, int[] departure){

        int n = arrival.length;

        //sorting both arrays
        Arrays.sort(arrival);
        Arrays.sort(departure);

        //plat_needed indicates number of platforms needed at a time
        int plat_needed = 1;
        int result = 1;
        int i = 1;
        int j = 0;

        //Similar to merge in merge sort to process all events in sorted order
        while ((i < n) && (j < n)) {
            //If next event arrives in sorted order, increment count of platforms needed
            if (arrival[i] < departure[j]) {
                plat_needed += 1;
                i += 1;
                //Update result if needed
                if (plat_needed > result) {
                    result = plat_needed;
                }
            } else {
                //Else decrement count of platforms needed
                plat_needed -= 1;
                j += 1;
            }
        }
        return result;
    }

    public static void main(String[] args){

        //Example 1
        int arrival[] = {900, 940, 950, 1100, 1500, 1800};
        int departure[] = {910, 1200, 1120, 1130, 1900, 2000};
        int answer  = MinPlatforms.findPlatformUsingGreedy(arrival, departure);
        System.out.println("Minimum Number of Platforms Required for Plan1 = " + answer);


        System.out.println();

        // Example 2
        int arrival1[] = {200, 210, 300, 320, 350, 500};
        int departure1[] = {230, 240, 320, 430, 400, 520};
        int answer2 = MinPlatforms.findPlatform(arrival1, departure1);
        System.out.println("Minimum Number of Platforms Required for Plan2 = " + answer2);

    }
}
