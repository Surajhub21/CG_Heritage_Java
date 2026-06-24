import java.util.concurrent.CountDownLatch;

class Counter {
    protected int value;

    void increment() {
        int current = value;
        Thread.yield();
        value = current + 1;
    }

    int getValue() {
        return value;
    }
}

class SynchronizedCounter extends Counter {
    @Override
    synchronized void increment() {
        int current = value;
        Thread.yield();
        value = current + 1;
    }
}

public class CounterRaceDemo {
    private static int runTest(Counter counter) throws InterruptedException {
        CountDownLatch ready = new CountDownLatch(5);
        CountDownLatch start = new CountDownLatch(1);
        Thread[] threads = new Thread[5];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                ready.countDown();
                try {
                    start.await();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                for (int j = 0; j < 1000; j++) {
                    counter.increment();
                }
            }, "Counter-Worker-" + (i + 1));
        }

        for (Thread thread : threads) {
            thread.start();
        }

        ready.await();
        start.countDown();

        for (Thread thread : threads) {
            thread.join();
        }

        return counter.getValue();
    }

    public static void main(String[] args) throws InterruptedException {
        Counter unsafeCounter = new Counter();
        int unsafeResult = runTest(unsafeCounter);
        System.out.println("Without synchronized: " + unsafeResult + " (expected 5000)");

        Counter safeCounter = new SynchronizedCounter();
        int safeResult = runTest(safeCounter);
        System.out.println("With synchronized: " + safeResult + " (expected 5000)");
    }
}
