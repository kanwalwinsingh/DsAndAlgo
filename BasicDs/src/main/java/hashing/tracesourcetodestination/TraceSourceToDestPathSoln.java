package main.java.hashing.tracesourcetodestination;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TraceSourceToDestPathSoln {

    public static List<List<String>> tracePath(List<List<String>> paths){
        Map<String,String> dictionary = new HashMap<>();
        //Convert the array into the map
        for (List<String> path : paths){
            dictionary.put(path.get(0),path.get(1));
        }
        Map<String, String> reverseDict = new HashMap<>();
        //To Fill reverseDict, iterate through the given map
        for(Map.Entry<String,String> entry : dictionary.entrySet()){
            reverseDict.put(entry.getValue(), entry.getKey());
        }
        String start = null;

        //Find the starting point of itinery
        for(Map.Entry<String,String> entry: dictionary.entrySet()){
            if(!reverseDict.containsKey(entry.getKey())){
                start = entry.getKey();
                break;
            }
        }
        List<List<String>> result = new ArrayList<>();
        //Trace complete path
        String dest = dictionary.get(start);
        while (dest!=null && !dest.isEmpty()){
            List<String> path = new ArrayList<>();
            path.add(start);
            path.add(dest);
            result.add(path);
            start = dest;
            dest = dictionary.get(start);
        }
        return result;

    }
}
