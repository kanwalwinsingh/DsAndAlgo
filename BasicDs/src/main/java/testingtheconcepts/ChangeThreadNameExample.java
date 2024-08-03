package main.java.testingtheconcepts;

public class ChangeThreadNameExample {

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

        Thread thread = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("Thread is waiting with name: " + Thread.currentThread().getName());
                    lock.wait(); // Thread goes into waiting state
                    System.out.println("Thread resumed with name: " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    System.out.println("Thread was interrupted");
                }
            }
        });

        thread.setName("OriginalThreadName");
        thread.start();

        // Main thread sleeps for 1 second to ensure the other thread is waiting
        Thread.sleep(1000);

        // Change the thread name while it is in the waiting state
        thread.setName("UpdatedThreadName");

        // Wake up the waiting thread
        synchronized (lock) {
            lock.notify();
        }
    }
}