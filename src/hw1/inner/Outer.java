package hw1.inner;

import java.io.Serializable;

public class Outer {
    private int x;
    private static int r;

    public Outer(int x) {
        this.x = x;
    }

    class Inner{
        private int y ;

        public Inner(int y) {
            this.y = y;
        }

        public void printOutValue(){
            System.out.println(x);
        }
    }

    public void testInner(){
       Inner inner = new Inner(1);
    }

    static class MyStaticClass implements Serializable {
        public void test(){
            System.out.println(r);
        }
    }
}
