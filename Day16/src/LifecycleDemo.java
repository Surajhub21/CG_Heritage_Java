import java.util.concurrent.atomic.AtomicBoolean;

public class LifecycleDemo {
    private static void printStates(String label, Thread... threads) {
        System.out.println(label);
        for (Thread thread : threads) {
            System.out.println(thread.getName() + " | state=" + thread.getState() + " | isAlive=" + thread.isAlive());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        AtomicBoolean go = new AtomicBoolean(false);

        Thread t1 = new Thread(() -> runWorker(lock, go, 1), "Lifecycle-1");
        Thread t2 = new Thread(() -> runWorker(lock, go, 2), "Lifecycle-2");
        Thread t3 = new Thread(() -> runWorker(lock, go, 3), "Lifecycle-3");

        printStates("Before start", t1, t2, t3);

        t1.start();
        t2.start();
        t3.start();

        Thread.sleep(100);
        printStates("After start while spinning", t1, t2, t3);

        go.set(true);
        Thread.sleep(150);
        printStates("After release while lock is held", t1, t2, t3);

        t1.join();
        t2.join();
        t3.join();

        printStates("After join", t1, t2, t3);
    }

    private static void runWorker(Object lock, AtomicBoolean go, int id) {
        while (!go.get()) {
            Thread.yield();
        }

        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " entered critical section " + id);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
            System.out.println(Thread.currentThread().getName() + " leaving critical section " + id);
        }
    }
}
