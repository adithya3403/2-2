class MyRunnable1 implements Runnable {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("I am thread 1");
        }
    }
}

class MyRunnable2 implements Runnable {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("I am thread 2");
        }
    }
}

class MyRunnable3 implements Runnable {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("I am thread 3");
        }
    }
}

public class sample {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable1 mr1 = new MyRunnable1();
        MyRunnable2 mr2 = new MyRunnable2();
        MyRunnable3 mr3 = new MyRunnable3();
        Thread t1 = new Thread(mr1);
        Thread t2 = new Thread(mr2);
        Thread t3 = new Thread(mr3);
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println("I am main thread");
    }
}
