package hw_01_1;

public class Main {
    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("threadGroup");
        MyThread thread1 = new MyThread(threadGroup, "поток 1");
        MyThread thread2 = new MyThread(threadGroup, "поток 2");
        MyThread thread3 = new MyThread(threadGroup, "поток 3");
        MyThread thread4 = new MyThread(threadGroup, "поток 4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadGroup.interrupt();
    }
}
