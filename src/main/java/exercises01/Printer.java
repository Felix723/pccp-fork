package exercises01;

import java.util.concurrent.locks.ReentrantLock;

public class Printer {
    ReentrantLock l = new ReentrantLock();
    
    public void print() {
        l.lock(); // def
        System.out.print(" - "); // 2
        try { Thread.sleep(50); } catch (InterruptedException exn) { } // 3
        System.out.print("|"); // 4
        l.unlock(); // | locked - open def
    }
    public static void main(String[] args) {
        Printer p = new Printer();
        Thread t1 = new Thread(() -> {
            while (true) { // 1
                p.print();
            }
        });
        Thread t2 = new Thread(() -> {
            while (true) { // 1
                p.print(); 
            }
        });
        t1.start(); t2.start();
        try { t1.join(); t2.join(); }
        catch (InterruptedException exn) {
            System.out.println("Some thread was interrupted");
        }
    }
}
