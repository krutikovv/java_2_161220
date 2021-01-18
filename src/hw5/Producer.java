package hw5;

public class Producer implements Runnable {
    Store store;

    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            //будем создавать
            store.put();
        }
    }
}

class Consumer implements Runnable {
    Store store;

    public Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            //будем покупать
            store.get();
        }
    }
}

class Store {
    private int product;
    private final Object mon = new Object();

    public void get() {
        synchronized (mon) {
            while (product <= 0) {
                try {
                    mon.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            product--;
            System.out.println("Покупатель купил 1 товар");
            System.out.println("Товаров осталось : "+ product);
            mon.notify();
        }
    }

    public void put() {
        synchronized (mon) {
            while (product >= 3) {
                try {
                    mon.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            product++;
            System.out.println("Производитель добавил 1 товар");
            System.out.println("Товаров осталось : "+ product);
            mon.notify();
        }
    }
}

class MainApp {
    public static void main(String[] args) {
        Store store = new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);

        new Thread(producer).start();
        new Thread(consumer).start();


    }
}
