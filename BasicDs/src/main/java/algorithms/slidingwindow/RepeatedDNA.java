package main.java.algorithms.slidingwindow;

import java.util.*;

public class RepeatedDNA {

//    public static Set<String> findRepeatedSequences(String s, int k){
//        int n = s.length();
//        //Mapping of characters
//        Map<Character, Integer> mapping = new HashMap<>();
//        mapping.put('A',1);
//        mapping.put('C', 2);
//        mapping.put('G', 3);
//        mapping.put('T', 4);
//
//        //Base value
//        int a = 4;
//
//        //Numeric repersentation of the sequence
//        List<Integer> numbers = new ArrayList<>(Arrays.asList(new Integer[n]));
//        for (int i =  0; i< n; i++){
//            numbers.set(i,mapping.get(s.charAt(i)));
//        }
//        int hashValue = 0;
//        Set<Integer> hashSet = new HashSet<>();
//        Set<String> ouput = new HashSet<>();
//
//        for(int i =0; i<=n-k;i++){
//            if(i == 0){
//                for(int j =0; j<k; j++){
//                    hashValue += (int) (numbers.get(j) *Math.pow(a,k-j-1));
//                }
//            }else{
//                hashValue =
//            }
//        }
//        System.out.println("\tConverted sequence: " + numbers.toString());
//    }// Driver code

    public static List<String> findRepeatedDnaSrquece(String s, int k){
        int substringLength = s.length()-k;
        Map<String,Integer> sequenceCount = new HashMap<>();
        List<String> repeatedSeq = new ArrayList<>();
        for(int i = 0; i<=substringLength; i++){
            String currentString = s.substring(i,i+k);
            sequenceCount.put(currentString,sequenceCount.getOrDefault(currentString,0)+1);
            if(sequenceCount.get(currentString) == 2){
                repeatedSeq.add(currentString);
            }
        }
        return repeatedSeq;
    }
    public static void main(String[] args) {
        List<String> inputsString = Arrays.asList("ACGT", "AGACCTAGAC", "AAAAACCCCCAAAAACCCCCC",
                "GGGGGGGGGGGGGGGGGGGGGGGGG", "TTTTTCCCCCCCTTTTTTCCCCCCCTTTTTTT", "TTTTTGGGTTTTCCA",
                "AAAAAACCCCCCCAAAAAAAACCCCCCCTG", "ATATATATATATATAT");
        List<Integer> inputsK = Arrays.asList(3, 3, 8, 12, 10, 14, 10, 6);

        for (int i = 0; i < inputsK.size(); i++) {
            System.out.println((i + 1) + ".\tInput sequence: " + inputsString.get(i) +
                    "\n\tk: " + inputsK.get(i) + "\n");
            System.out.println(findRepeatedDnaSrquece(inputsString.get(i), inputsK.get(i)));
            System.out.println(Collections.nCopies(100,"-"));
        }
    }

}
