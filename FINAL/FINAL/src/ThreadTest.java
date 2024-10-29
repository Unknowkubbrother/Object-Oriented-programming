class MyThread_subpend extends Thread {
    private String name;
    private final Object lock;

    public MyThread_subpend(String name, Object lock) {
        this.name = name;
        this.lock = lock;
    }

    public void run() {
        synchronized (lock) {
            for (int i = 0; i < 20; i++) {
                System.out.print(name);
                if (i == 10) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        Object lock = new Object();
        MyThread_subpend t1 = new MyThread_subpend("A", lock);
        MyThread_subpend t2 = new MyThread_subpend("B", lock);

        t1.start();
        t2.start();

        try {
            Thread.sleep(200);
            synchronized (lock) {
                lock.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}