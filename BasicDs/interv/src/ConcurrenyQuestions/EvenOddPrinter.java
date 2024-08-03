package ConcurrenyQuestions;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class EvenOddPrinter {

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    volatile int counter = 0;

    public void printEven() {
        while (counter < 15) {
            try {
                lock.lock();
                while (counter % 2 != 0) {
                    condition.await();

                }
                System.out.println("Value of counter is: " + counter + ", Printed by Thread " + Thread.currentThread().getName());
                counter++;
                condition.signalAll();
            } catch (InterruptedException ex) {
                System.out.println(ex);
            } finally {
                lock.unlock();
            }
        }
    }

    public void printOdd() {
        while (counter < 15) {
            try {
                lock.lock();
                while (counter % 2 == 0) {
                    condition.await();

                }
                System.out.println("Value of counter is: " + counter + ", Printed by Thread " + Thread.currentThread().getName());
                counter++;
                condition.signalAll();
            } catch (InterruptedException ex) {
                System.out.println(ex);
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        EvenOddPrinter evenOddPrinter = new EvenOddPrinter();
        Thread t1 = new Thread(evenOddPrinter::printOdd, "Thread1");
        t1.start();
        Thread t2 = new Thread(evenOddPrinter::printEven, "Thread2");
        t2.start();
        t1.join();
        t2.join();
    }
}
