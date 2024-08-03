package main.java.algorithms.hashmapproblems;

import java.util.HashMap;

public class RequestLogger {
    private HashMap<String, Integer> requests;
    int limit;

    public RequestLogger(int timmeLimit){
        requests = new HashMap<>();
        limit = timmeLimit;
    }

    //function to accept and deny message requests
    public boolean messageRequestDecision(int timestamp, String request){
        if(!this.requests.containsKey(request)){
            this.requests.put(request,timestamp);
            return true;
        }
        if(timestamp - this.requests.get(request) >= limit){
            this.requests.put(request,timestamp);
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        // Driver code
        int[] times = { 1, 5, 6, 7, 15 };
        String[] messages = {
                "good morning",
                "hello world",
                "good morning",
                "good morning",
                "hello world"
        };
        RequestLogger obj = new RequestLogger(7);
        for (int i = 0; i<messages.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tTime, message: {" + times[i] + ", '" + messages[i] + "'}");
            System.out.println("\tMessage request decision: " + obj.messageRequestDecision(times[i], messages[i]));
            System.out.println("-------------------------------------------------");
        }
    }
}
