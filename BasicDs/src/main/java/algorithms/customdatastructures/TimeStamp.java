package main.java.algorithms.customdatastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TimeStamp {
    HashMap<String, List<String>> valuesDict;
    HashMap<String, List<Integer>> timestampDict;

    public TimeStamp(){
        valuesDict = new HashMap<>();
        timestampDict = new HashMap<>();
    }

    //Set timestamp {
    public void setValue(String key, String value, int timestamp){
        if(valuesDict.containsKey(key)){
            if(value != valuesDict.get(key).get(valuesDict.get(key).size()-1)){
                valuesDict.get(key).add(value);
                timestampDict.get(key).add(timestamp);
            }
        }else{
            valuesDict.put(key,new ArrayList<>());
            valuesDict.get(key).add(value);
            timestampDict.put(key,new ArrayList<>());
            timestampDict.get(key).add(timestamp);
        }
    }

    //Find the index of right most occurance of the given timestamp using binary search
    public int searchIndex(int n, String key, int timestamp){
        int left =0;
        int right = n;
        int mid =0;
        while (left<right){
            mid = left+ (right-left)/2;
            if ((timestampDict.get(key).get(mid) > timestamp)) {
                right = mid;
            } else {
                left = mid +1;
            }
        }
        return left -1;
    }

    //Get the value for the given key and timestamp
    public String getValue(String key, int timestamp){
        int index = 0;
        if(!valuesDict.containsKey(key)){
            return "";
        }else{
            index = searchIndex(timestampDict.get(key).size(),key,timestamp);
        }
        if (index>-1){
            return valuesDict.get(key).get(index);
        }
        return "";
    }

    public static class Triplet
    {
        public String course;
        public String cName;
        public int id;
        public Triplet(String course, String cName, int id)
        {
            this.course = course;
            this.cName = cName;
            this.id = id;
        }
    }
    public static void main(String args[]) {
        TimeStamp ts = new TimeStamp();
        int num = 1;
        List<Triplet> input = Arrays.asList(new Triplet("course", "OOP", 3), new Triplet("course", "PF", 5), new Triplet("course", "OS", 7), new Triplet("course", "ALGO", 9), new Triplet("course", "DB", 10));
        for (int i = 0; i<input.size(); i++) {
            System.out.println(num + ".\tAdd value: (" + '"' + input.get(i).course + '"' + ", " + '"' + input.get(i).cName + '"' + ", " + input.get(i).id + ")");
            ts.setValue(input.get(i).course, input.get(i).cName, input.get(i).id);
            int randomInt = (int) Math.floor(Math.random() * (10 - 1 + 1) + 1);
            System.out.println("\n\tGet value for:");
            System.out.println("\t\tKey = course  \n\t\tTimestamp = " + randomInt);
            System.out.println("\n\tReturned value = " + '"' + ts.getValue("course", randomInt) + '"');
            num += 1;
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
