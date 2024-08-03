package main.java.multithreadin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        System.out.println("processor: "+Runtime.getRuntime().availableProcessors());
        Callable<String> task = () -> {
            Random random = new Random();
            int i = random.nextInt() * 100;
            System.out.println("Inside the thread task");
            Thread.sleep(1000);
            return "Task completed " +" "+i;
        };

        List<Future<String>> futureList= new ArrayList<>();
        List<CompletableFuture<String>> futureList1= new ArrayList<>();
        try {
            for (int i = 0; i < 10; i++) {
               // Future<String> future = executor.submit(task);
                CompletableFuture<String> future1 = CompletableFuture.supplyAsync(()->{
                    try {
                    Random random = new Random();
                    int j = random.nextInt() * 100;
                    System.out.println("Inside the thread task");
                    Thread.sleep(1000);
                    return "Task completed " +" "+j;
                } catch (InterruptedException e) {
                    throw new IllegalStateException(e);
                }
            });
                futureList1.add(future1);
                System.out.println("Waiting for the task to complete...");
                //futureList.add(future);
            }
            for (int i = 0; i < 10; i++) {
                CompletableFuture<String> stringCompletableFuture = futureList1.get(i);
                stringCompletableFuture.thenAccept(a-> System.out.println(a));
                stringCompletableFuture.get();
               // String string = futureList.get(i).get();
              //  System.out.println(string);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}