public class LongCounter {
    private long count = 0;
    
//    public void run(){
//        count = count + 1;
//    }
    public void increment() {
        count = count + 1;
    }

    public long get() {
        return count;
    }
}
