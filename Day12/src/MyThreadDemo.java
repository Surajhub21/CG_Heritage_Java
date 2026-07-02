class MyThread extends Thread {
    private final String displayName;

    MyThread(String displayName, String threadName) {
        super(threadName);
        this.displayName = displayName;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(displayName + " | current thread: " + Thread.currentThread().getName() + " | print " + i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}

public class MyThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread("GitHub Copilot", "MyThread-Worker");
        thread.start();
        thread.join();
    }
}
