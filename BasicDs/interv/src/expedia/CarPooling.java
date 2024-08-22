package expedia;

import java.util.Map;
import java.util.TreeMap;

public class CarPooling {
    public static boolean carPooling(int[][] trips, int capacity){
        //Step1: create a TreeMap to record the number of passengers at each location
        Map<Integer,Integer> passengerChanges = new TreeMap<>();

        for(int [] trip: trips){
            int numPassenger = trip[0];
            int from = trip[1];
            int to = trip[2];

            //Add passengers at the 'from' location
            passengerChanges.put(from,passengerChanges.getOrDefault(from,0)+numPassenger);

            //Remove passengers at the 'to' location
            passengerChanges.put(to,passengerChanges.getOrDefault(to,0)-numPassenger);
        }

        //Step 2: Traverse through the sorted map and check if capacity is exceeded
        int currentPassenger = 0;
        for(int change: passengerChanges.values()){
            currentPassenger += change;
            if(currentPassenger > capacity){
                return false; //capacity exceeded
            }
        }
        return true; // capacity was not excedded at any point
    }

    public boolean carPollingOptimized(int[][] trips, int capacity){
        int[] frequency = new int[1001];

        for(int[] trip : trips){
            int from = trip[1];
            int to = trip[2];
            frequency[from] += trip[0];
            frequency[to] -= trip[0];
        }
        int currentCapacity = 0;
        for(int i = 0; i< frequency.length; i++ ){
            currentCapacity +=frequency[i];
            if(capacity < currentCapacity){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] trips = {{2, 1, 5}, {3, 3, 7}};
        int capacity = 4;
        System.out.println(carPooling(trips, capacity));  // Output: false
    }
}
