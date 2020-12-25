package hw2;

public class FactorialException extends IllegalArgumentException{
    private int n;

    public int getN() {
        return n;
    }

    public FactorialException(int n) {
        this.n = n;
    }

    public FactorialException(String s, int n) {
        super(s);
        this.n = n;
    }
}
