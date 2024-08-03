package main.java.testingtheconcepts;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class A {
    void add() {
        System.out.println("Add A");
    }
}

class B extends A {
    void add() {
        super.add();
        //System.out.println("Add B");
    }
}

class C extends B {

    int c = 2;
    int d = 4;
    void add() {
        System.out.println(c+" "+d);
     swap(c,d);
        System.out.println(c+" "+d);
    }

    void swap(int c, int d){
        int t;
        t= c;
        c =d;
        d = t;
        System.out.println(c+" "+d);

    }

    public static void main(String[] args) throws CloneNotSupportedException {

//        ThreadTest threadTest1 = new ThreadTest("firstObject");
//
//        ThreadTest threadTest2 = new ThreadTest("secondObject");
//
//        Thread t1 = new Thread(()->{
//            System.out.println("Inside thread 1 begining");
//            threadTest2.staticMethod();
//            System.out.println("Inside thread 1 ending");
//        });
//        t1.setName("Thread1");
//
//        Thread t2 = new Thread(()->{
//            System.out.println("Inside thread 2 begining");
//            threadTest1.staticMethod();
//            System.out.println("Inside thread 2 ending");
//        });
//        t1.setName("Thread2");
//        t1.start();
//        t2.start();

        Map<Integer,Integer> hashmap = new HashMap<>(1);
        System.out.println(hashmap);

        CopyOnWriteArrayList<Integer> co = new CopyOnWriteArrayList<>();
        co.add(1);
        Iterator<Integer> iterator = co.iterator();
        while (iterator.hasNext()){
            if(iterator.next().equals(1)){
              //  iterator.remove();
            }
        }

    }


    public static String formatRupees(double value) {
        NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("en", "in"));
        format.setMinimumFractionDigits(2);
        format.setMaximumFractionDigits(5);
        return format.format(value);
    }
}