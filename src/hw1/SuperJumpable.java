package hw1;

public interface SuperJumpable extends Jumpable, Runnable {
    default void superJump(double h) {
        System.out.println("run... SuperJump!!! " + h + " meter");
    }
}
