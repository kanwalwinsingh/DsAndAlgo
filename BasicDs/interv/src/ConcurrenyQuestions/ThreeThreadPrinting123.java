package ConcurrenyQuestions;

import Codility.MaxProfit;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreeThreadPrinting123 {
    private final Lock lock = new ReentrantLock();
    private final Condition condition1 = lock.newCondition();
    private final Condition condition2 = lock.newCondition();
    private final Condition condition3 = lock.newCondition();
    private final int max = 12;
    private int current = 1;
    private int turn = 1;

    public void printNumber(int threadId, Condition currentCondition, Condition nextCondition) {
        while (current <= max) {
            lock.lock();
            try {
                while (turn != threadId) {
                    currentCondition.await();
                    if(current>max){
                        currentCondition.signal();
                        nextCondition.signal();
                    }
                }
                if (current <= max) {
                    System.out.println("Thread " + threadId + ": " + current);
                    current++;
                    turn = turn % 3 + 1;
                    nextCondition.signal();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ThreeThreadPrinting123 printer = new ThreeThreadPrinting123();

        Thread t1 = new Thread(() -> printer.printNumber(1, printer.condition1, printer.condition2), "Thread 1");
        Thread t2 = new Thread(() -> printer.printNumber(2, printer.condition2, printer.condition3), "Thread 2");
        Thread t3 = new Thread(() -> printer.printNumber(3, printer.condition3, printer.condition1), "Thread 3");

        t1.start();
        t2.start();
        t3.start();

        // Start the first thread
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
