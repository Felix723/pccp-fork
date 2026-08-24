public class Main {
    static void main() throws InterruptedException {
        LongCounter longCounter = new LongCounter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                longCounter.increment();
            }
                
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                longCounter.increment();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("lc counter value: " + longCounter.get());
    }
}
