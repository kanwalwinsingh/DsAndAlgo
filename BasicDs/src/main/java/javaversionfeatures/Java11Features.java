package main.java.javaversionfeatures;

import java.io.IOException;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java11Features {
    public static void main(String[] args) {
        List<String> listOfStrings = Arrays.asList(" ", "\t", "\n", "One", "Two", "Three");

        //to filter before java 11
        List<String> listWithOnlyBlank = listOfStrings.stream().filter(String::isBlank).collect(Collectors.toList());
        System.out.println(listWithOnlyBlank);
        //to filter list with no blank in java 11 using predicate.not
        listOfStrings.stream().filter(Predicate.not(String::isBlank)).forEach(System.out::println);

        //var with lambda
        Stream.of("1","2").map((var s)->Integer.valueOf(s)).forEach(System.out::println);

        //new string method added 1)isBlank, lines,strip,stripLeading,stripTrailing,repeat
        String multilineString = "Baeldung helps \n \n developers \n explore Java.";
        List<String> multiLineStringToList = multilineString.lines().filter(Predicate.not(String::isBlank))
                .map(String::strip).collect(Collectors.toList());
        System.out.println(multiLineStringToList);

        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        ClassLoader parent = systemClassLoader.getParent();


        //Changes in the File class readString and writeString
        try {

            Path filePath = Files.writeString(Files.createTempFile("demo",".txt"), "Sample text");
            String fileContent = Files.readString(filePath);
            System.out.println(fileContent);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
