package main.java.algorithms.customdatastructures;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnapshotArray {
    private int snapId;
    private Map<Integer, Map<Integer,Integer>> nodeValue;
    private int ncount;

    //Constructor
    public SnapshotArray(int length){
        snapId = 0;
        nodeValue = new HashMap<>();
        nodeValue.put(0, new HashMap<>());
        ncount = length;
    }

    //Function setValue sets the value at given index idx to val
    public  void setValue(int idx, int val){
        if(idx<ncount){
            nodeValue.get(snapId).put(idx,val);
        }
    }

    //This function takes no parameter and returns the snapid. snapid is the number of times that the snapshot() was called
    public int snapshot(){
        nodeValue.put(snapId+1,new HashMap<>(nodeValue.get(snapId)));
        snapId++;
        return snapId -1;
    }
    //Function getValue returns the value at the index idx with the given snapId
    public int getValue(int idx, int snapShotId){
        if(snapShotId<snapId && snapShotId>=0 ){
            return nodeValue.get(snapShotId).getOrDefault(idx, 0);
        }else {
            return -1;
        }
    }
    public static void main(String[] args) {
        // Driver code
        List<Integer> numNodes = Arrays.asList(3, 5, 5, 3, 2);
        List<List<List<Integer>>> nodesValue = Arrays.asList(
                Arrays.asList(Arrays.asList(0, 5), Arrays.asList(0, 1), Arrays.asList(2, 3), Arrays.asList(1, 10)),
                Arrays.asList(Arrays.asList(4, 1), Arrays.asList(2, 21)),
                Arrays.asList(Arrays.asList(4, 12), Arrays.asList(2, 61)),
                Arrays.asList(Arrays.asList(0, 15), Arrays.asList(0, 5), Arrays.asList(2, 13), Arrays.asList(1, 100)),
                Arrays.asList(Arrays.asList(0, 32), Arrays.asList(0, 6), Arrays.asList(1, 2)));
        List<List<List<Integer>>> valueToGet = Arrays.asList(
                Arrays.asList(Arrays.asList(0, 0), Arrays.asList(0, 1), Arrays.asList(1, 0)),
                Arrays.asList(Arrays.asList(4, 1), Arrays.asList(2, 1), Arrays.asList(3, 1)),
                Arrays.asList(Arrays.asList(4, 1), Arrays.asList(2, 1), Arrays.asList(3, 1)),
                Arrays.asList(Arrays.asList(0, 1), Arrays.asList(1, 1)),
                Arrays.asList(Arrays.asList(0, 0)));

        for (int i = 0; i < numNodes.size(); i++) {
            System.out.println(i + 1 + ".\tInitializing a data structure with " + numNodes.get(i) + " nodes");
            SnapshotArray snapshotArr = new SnapshotArray(numNodes.get(i));

            for (int j = 0; j < nodesValue.get(i).size(); j++) {
                for (int k = 0; k < nodesValue.get(i).get(j).size(); k++) {
                    System.out.println("\t\tSetting the value of node " + nodesValue.get(i).get(j).get(0) + " to " + nodesValue.get(i).get(j).get(1));
                    snapshotArr.setValue(nodesValue.get(i).get(j).get(0), nodesValue.get(i).get(j).get(1));
                    System.out.println("\t\tSnap id:" + snapshotArr.snapshot() + "\n");
                    break;
                }
            }

            for (int x = 0; x < valueToGet.get(i).size(); x++) {
                for (int y = 0; y < valueToGet.get(i).get(x).size(); y++) {
                    System.out.println("\t\tNode value at index " + valueToGet.get(i).get(x).get(0) + " with snapID: " + valueToGet.get(i).get(x).get(1) + " is: " + snapshotArr.getValue(valueToGet.get(i).get(x).get(0), valueToGet.get(i).get(x).get(1)));
                    break;
                }
            }
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

}
