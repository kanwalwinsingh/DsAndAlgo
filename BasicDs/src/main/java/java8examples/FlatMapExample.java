package main.java.java8examples;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FlatMapExample {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,2,3);
        List<Integer> list2 = Arrays.asList(4,5,6);
        List<Integer> list3 = Arrays.asList(7,8,9);

        List<List<Integer>> listOfLists = Arrays.asList(list1, list2, list3);
        Set<Integer> setOfIntegers = listOfLists.stream().flatMap(l -> l.stream()).collect(Collectors.toSet());
        System.out.println(setOfIntegers);

        //sum of numbers using the stream flat map
        List<List<Integer>> listOfListsN = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8)
        );
        int sum = listOfListsN.stream().flatMapToInt(a -> a.stream().mapToInt(Integer::intValue).peek(System.out::println)).sum();
        System.out.println(sum);

    }
}
