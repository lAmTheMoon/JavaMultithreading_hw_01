package hw_01_1;

public class MyThread extends Thread {
    public MyThread(ThreadGroup group, String name) {
        super(group, name);
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                Thread.sleep(2500);
                System.out.printf("Всем привет! Это %s.\n", getName());
            }
        } catch (InterruptedException e) {
            System.out.printf("%s завершен\n", getName());
        }
    }
}
