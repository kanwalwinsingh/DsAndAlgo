package leetcodetop75;

import java.util.LinkedList;
import java.util.Queue;

public class Dota2senate {
    public String predictPartyVictory(String senate){
        int n = senate.length();
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();

        //Populate the queues with tje indices of radiant and dire senator
        for(int i =0; i<n; i++){
            if(senate.charAt(i) == 'R'){
                radiant.offer(i);
            }else {
                dire.offer(i);
            }
        }

        //Simulate the voting rounds
        while (!radiant.isEmpty() && !dire.isEmpty()){
            int rIndex = radiant.poll();
            int dIndex = dire.poll();
            if(rIndex < dIndex){
                //Radiant senator bans Dire Senator
                    radiant.offer(rIndex+n);
            }else{
                dire.offer(dIndex+n);
            }
        }

        //Determine the winner
        return radiant.isEmpty() ? "Dire" : "Radiant";

    }
    public static void main(String[] args) {
        Dota2senate ds = new Dota2senate();
        System.out.println(ds.predictPartyVictory("RD"));  // Output: Radiant
        System.out.println(ds.predictPartyVictory("RDD")); // Output: Dire
    }
}
