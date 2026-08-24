// For week 1
// sestoft@itu.dk * 2014-08-21
// raup@itu.dk * 2021-08-27
package exercises01;
import java.util.concurrent.locks.ReentrantLock;

public class RunLongCounter {

    LongCounter lc = new LongCounter();
    ReentrantLock l = new ReentrantLock();
    int counts = 10_000_000;

    public RunLongCounter() {

        Thread t1 = new Thread(() -> {
            for (int i=0; i<counts; i++)
                try {
                    l.lock();
                    lc.increment();
                } finally {
                    l.unlock();
                }
        });
        Thread t2 = new Thread(() -> {
            for (int i=0; i<counts; i++)
                try {
                    l.lock();
                    lc.increment();
                } finally {
                    l.unlock();
                }
        });
        t1.start(); t2.start();
        try { t1.join(); t2.join(); }
        catch (InterruptedException exn) {
            System.out.println("Some thread was interrupted");
        }
        System.out.println("Count is " + lc.get() + " and should be " + 2*counts);
    }

    public static void main(String[] args) {
        new RunLongCounter();
    }

    class LongCounter {
        private long count = 0;

        public void increment() {
            count = count + 1;
        }

        public long get() {
            return count;
        }
    }
}