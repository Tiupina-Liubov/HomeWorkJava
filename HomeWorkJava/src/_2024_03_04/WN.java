package src._2024_03_04;


public class WN {
    public static void main(String[] args) {
        Storage storage = new Storage();

        Producer producer = new Producer(storage);
        Consumer consumer = new Consumer(storage);
        Reservation reservation = new Reservation(storage);
        Basket basket= new Basket(storage);

        Thread prodThread = new Thread(producer);
        Thread consThread = new Thread(consumer);
        Thread resetThread = new Thread(reservation);
        Thread basketThread= new Thread(basket);

        prodThread.start();
        resetThread.start();
        consThread.start();
        basketThread.start();
    }
}

class Storage {
    private int item = 0;
    private int reservedCount = 0;
     private int quantityInBasket=0;
    private final Object lock = new Object();

    public void getItem() {
        synchronized (lock) {

            while (reservedCount < 1) {
                try {
                        lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

           reservedCount--;
            System.out.println("Customer has bought one item. Quantity: " + reservedCount);
            lock.notifyAll();
        }
    }

    public void putItem() {
        synchronized (lock) {
            while (item >= 5 || reservedCount>=5|| quantityInBasket>=5) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            item++;
            System.out.println("Factory put one item into the Storage. Quantity: " + item);
            lock.notifyAll();
        }
    }

    public void reserved() {
        synchronized (lock) {
            while (reservedCount >= 5 || item<1 ||quantityInBasket<1) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            reservedCount++;
            item--;
            System.out.println("Number of reserved products = " + reservedCount);
            lock.notifyAll();
        }
    }

    public void goToBasket() {
        synchronized (lock) {
            while (item >= 5 || reservedCount>=5|| quantityInBasket>=5) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            reservedCount--;
            quantityInBasket++;
            System.out.println("Number of items in basket" + quantityInBasket);
            lock.notifyAll();
        }
    }
}

class Producer implements Runnable {
    Storage storage;

    public Producer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {

            storage.putItem();
        }
    }
}

class Consumer implements Runnable {
    Storage storage;

    public Consumer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            storage.getItem();
        }
    }
}

class Reservation implements Runnable {
    Storage storage;


    public Reservation(Storage storage) {
        this.storage = storage;
    }


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            storage.reserved();
        }
    }
}

class Basket implements Runnable {
    Storage storage;

    public Basket(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {

            storage.putItem();
        }
    }
}