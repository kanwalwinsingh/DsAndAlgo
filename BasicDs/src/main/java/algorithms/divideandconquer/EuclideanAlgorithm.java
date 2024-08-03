package main.java.algorithms.divideandconquer;

import java.util.Random;

public class EuclideanAlgorithm {
    public static int GCD(int a, int b){
        if(a == 0)
            return b;
        return GCD(b%a,a);
    }
    public static void main(String[] args)
    {
        Random rand = new Random(); // built-in funtion provided by the library java.util.Random in Java for Random Number Generation
        int a = rand.nextInt(50);   // use random inputs
        int b = a * rand.nextInt(10) + rand.nextInt(35);
        System.out.println("GCD(" + a +  " , " + b+ ") = " + GCD(a, b));

        a = (rand.nextInt(150)%50); b = (rand.nextInt(200)%5);   // you can play around with the range of random numbers to see different outputs
        System.out.println("GCD(" + a +  " , " + b+ ") = " + GCD(a, b));

        a = rand.nextInt(10); b = rand.nextInt(10);
        System.out.println("GCD(" + a +  " , " + b+ ") = " + GCD(a, b));

    }
}
