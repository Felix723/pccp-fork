// For week 1
// raup@itu.dk * 2021-08-27
package exercises01;

import java.util.concurrent.locks.ReentrantLock;

public class CounterThreads2 {

    // Shared variables
    long counter = 0;
    final long PEOPLE  = 10_000;
    final long MaxPeopleCovid = 15000;
    ReentrantLock lock = new ReentrantLock();

    public CounterThreads2() {
        try {
            // Create two instances of the thread
            Turnstile turnstile1 = new Turnstile();
            Turnstile turnstile2 = new Turnstile();

            // Start the execution
            turnstile1.start();turnstile2.start();

            // Wait until the threads finish their execution
            turnstile1.join();turnstile2.join();

            // Print the value of counter
            System.out.println(counter+" people entered");
        }
        catch (InterruptedException e) { // join() may throw InterruptedExceptions
            System.out.println("Error " + e.getMessage());
            e.printStackTrace();
        }
    }

    // We define the code in the class constructor, CounterThreads2(),
    // to avoid problems with using non-static variables in the body
    // of main().
    // In future lectures we will talk about the subtleties of static
    // variables in Java concurrency.
    public static void main(String[] args) {
        new CounterThreads2();
    }


    // Definition of the thread computation
    public class Turnstile extends Thread {
        public void run() {
            for (int i = 0; i < PEOPLE; i++) {
                lock.lock();
                if (counter == MaxPeopleCovid) {
                    lock.unlock();
                    return;
                }
                counter++;
                lock.unlock();
            }
        }
    }
}