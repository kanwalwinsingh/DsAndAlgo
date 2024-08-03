package main.java.javaversionfeatures;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class java9FeatureTest {
    public static void main(String[] args) throws FileNotFoundException {
        List nameList = List.of("akhil", "abhishek");
        System.out.println(nameList);

        // nameList.add("ayush"); // this will give exception i.e UnsupportedOperationException
        System.out.println(nameList);

        //prior to java 9 unmodifiable list
        List<Integer> myIntList = new ArrayList<>();
        myIntList.addAll(Arrays.asList(1, 2, 3, 4));
        System.out.println(myIntList);
        List<Integer> myIntListUnmodfiable = Collections.unmodifiableList(myIntList);
        System.out.println(myIntListUnmodfiable);

        //    myIntListUnmodfiable.add(5); //this will give runtime exception unsupportedOperationException
        System.out.println(myIntListUnmodfiable);

        myIntList.add(6); //this will run fine
        System.out.println(myIntList);
        System.out.println("Unmodifiable list also updated: " + myIntListUnmodfiable);

        /* ---- imuttable map creation*/
        Map<Integer, String> integerStringMap = Map.of(1, "1", 2, "2");
        Map<Integer, String> kvMap = Map.ofEntries(Map.entry(3, "3"), Map.entry(4, "4"));
        System.out.println(integerStringMap + " " + kvMap);

        //Stream API changes example in Java 9
        System.out.println("Stream api changes testing");
        IntStream.of(1, 2, 3, 4, 5, 6).takeWhile(i -> i < 4).forEach(System.out::println);
        //
        IntStream.of(10, 11, 12, 13, 14, 15).dropWhile(i -> i < 13)
                .forEach(System.out::println);
        System.out.println("Example of nullable stream " + Stream.ofNullable(1).count());
        System.out.println("Example of a  null stream " + Stream.ofNullable(null).count());

        Stream.iterate(1, i -> i < 1000, i -> i * 10).forEach(System.out::println);


        //closing resources example
        //before java 7
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/k0s0lvx/Library/CloudStorage/OneDrive-WalmartInc/backup/intellijProjects/spring-boot-graphql-tut-master/DsAndAlgo/BasicDs/src/main/java/javaversionfeatures/mytextfile.txt");
        try {
            //using the resource
            fileOutputStream.write("First line".getBytes());
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            //Releasing the resources
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //After java 7
        try (FileOutputStream fileOutputStream1 = new FileOutputStream("/Users/k0s0lvx/Library/CloudStorage/OneDrive-WalmartInc/backup/intellijProjects/spring-boot-graphql-tut-master/DsAndAlgo/BasicDs/src/main/java/javaversionfeatures/mytextfile.txt")) {
            fileOutputStream1.write("Second line".getBytes());
        } catch (IOException ea) {
            ea.printStackTrace();
        }

        //After java 9
        FileOutputStream fileOutputStream2 = new FileOutputStream("/Users/k0s0lvx/Library/CloudStorage/OneDrive-WalmartInc/backup/intellijProjects/spring-boot-graphql-tut-master/DsAndAlgo/BasicDs/src/main/java/javaversionfeatures/mytextfile.txt");
        try (fileOutputStream2) {
            fileOutputStream2.write("third line".getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Java 9 abstract class diamond operator example
        Addition<Integer> addition = new Addition<>() {
            @Override
            void add(Integer t1, Integer t2) {
                System.out.println(t1+t2);
            }
        };
        addition.add(3,6);
        java9FeatureTest java9Feature = new java9FeatureTest();
        java9Feature.iterateAListOfString("my","oh","my");

       // String _ = "underscore"; // underscore is not allowed as the variable name form java 9 onwards

        //java 9 optional enhancment example
        Optional<String> optionalAddress1 = Optional.of("Address1");
        optionalAddress1.ifPresentOrElse(System.out::println,()-> System.out.println("No address present"));

        Optional<String> optionalAddress2 = Optional.empty();
        optionalAddress2.ifPresentOrElse(System.out::println,()-> System.out.println("No address present"));

        String newAddress = optionalAddress2.orElse("new address");
        System.out.println(newAddress);

        //example of stream() method in optional

        System.out.println(optionalAddress1.stream().map(String::length).count());
        System.out.println(optionalAddress2.stream().map(String::length).count());

        //example of or function when optional is empty
        System.out.println(optionalAddress2.or(()->Optional.of("latest address")).get());

        }

    //Create safe varargs method in java 7
    @SafeVarargs
    private void iterateAListOfString(String... args){
        Arrays.stream(args).forEach(System.out::println);
    }
}
