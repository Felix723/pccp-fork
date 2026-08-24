package exercises01;

import java.util.concurrent.locks.ReentrantLock;

public class LongCounter {
    private long count = 0;
    ReentrantLock lock = new ReentrantLock();
    
//    public void run(){
//        count = count + 1;
//    }
    public void increment() {
        lock.lock();
        count = count + 1;
        lock.unlock();
    }
    
    public void increment2() {
        count++;
    }
    public void increment3() {
        count += 1;
    }
    

    public long get() {
        return count;
    }
}
