package main.java.javaversionfeatures;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java10Features {
    public static void main(String[] args) {
        var i = 10;
        var d = 1.1;
        var c = 'C';
        var b = true;
        var str = "string";
        var list = List.of(1, 22, 333);
        var map = Map.of(1, "Java", 2, "Python", 3, "JavaScript");
        List<Integer> collect = map.entrySet().stream().map(a -> a.getKey() * 3).collect(Collectors.toUnmodifiableList());
        System.out.println(collect);
        Map<String, Integer> unModifableMap = Stream.of("Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine")
                .collect(Collectors.toUnmodifiableMap(s -> s, String::length));
        System.out.println(unModifableMap);
        System.out.println(Map.copyOf(unModifableMap));


    }
}
