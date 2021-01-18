package hw5;

public class CounterWithPrivateMon {
    private int c;
    private final Object mon = new Object();

    public CounterWithPrivateMon() {
        c = 0;
    }

    public void inc() {
        synchronized (mon) {
            c++;
        }
    }

    public void dec() {
        synchronized (mon) {
            c--;
        }
    }


    public int getC() {
        return c;
    }
}
