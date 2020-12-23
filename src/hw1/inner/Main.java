package hw1.inner;

public class Main {
    public static void main(String[] args) {
//        Outer outer = new Outer(7);
//        Outer.Inner inner = outer.new Inner();

//        Outer.Inner inner = new Outer(5).new Inner(1);
//        inner.printOutValue();
//
//        Outer.MyStaticClass myStaticClass = new Outer.MyStaticClass();
//        myStaticClass.test();

        if(true){
            class LocalClass{
                int x;
                int y;

                public LocalClass(int x, int y) {
                    this.x = x;
                    this.y = y;
                }
            }

            LocalClass localClass = new LocalClass(5, 9);
            System.out.println(localClass.x);
        }
    }

    public void testMethod(){
        class LocalClass{
            int x;
            int y;

            public LocalClass(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        LocalClass localClass = new LocalClass(5, 9);
        System.out.println(localClass.x);
    }

}
