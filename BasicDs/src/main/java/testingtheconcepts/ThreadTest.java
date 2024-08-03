package main.java.testingtheconcepts;

import java.util.Objects;

public class ThreadTest {

    public String name;

    public ThreadTest(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThreadTest that = (ThreadTest) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public String toString() {
        return "ThreadTest{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    public static synchronized void staticMethod(){
        try {
            Thread.sleep(10050);
            System.out.println("Inside static method ");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public synchronized void instanceMethod(){
        try {
            Thread.sleep(10050);
            System.out.println("Inside instance method "+this.toString()+" "+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
