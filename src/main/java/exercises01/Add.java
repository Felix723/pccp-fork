package exercises01;

import javax.xml.stream.events.StartDocument;

public class Add {
    static void main() {
        long start, spent = 0;
        start = System.nanoTime();
        int counter = 0;
        for (int i = 1; i <= 100; i++) {
            counter = counter + i;
        }
        spent += System.nanoTime() - start;
        System.out.println("time spent calculating: " + spent);
    }
    
}
