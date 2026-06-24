public class DeadlockDemo {
    private static void printStates(String label, Thread first, Thread second) {
        System.out.println(label);
        System.out.println(first.getName() + " | state=" + first.getState() + " | isAlive=" + first.isAlive());
        System.out.println(second.getName() + " | state=" + second.getState() + " | isAlive=" + second.isAlive());
    }

    private static void sleepQuietly(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static void runDeadlockDemo() {
        Object lockA = new Object();
        Object lockB = new Object();

        Thread thread1 = new Thread(() -> {
            synchronized (lockA) {
                System.out.println(Thread.currentThread().getName() + " acquired LockA");
                sleepQuietly(200);
                System.out.println(Thread.currentThread().getName() + " waiting for LockB");
                synchronized (lockB) {
                    System.out.println(Thread.currentThread().getName() + " acquired LockB");
                }
            }
        }, "Thread-1");

        Thread thread2 = new Thread(() -> {
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + " acquired LockB");
                sleepQuietly(200);
                System.out.println(Thread.currentThread().getName() + " waiting for LockA");
                synchronized (lockA) {
                    System.out.println(Thread.currentThread().getName() + " acquired LockA");
                }
            }
        }, "Thread-2");

        thread1.setDaemon(true);
        thread2.setDaemon(true);
        thread1.start();
        thread2.start();
        sleepQuietly(500);
        printStates("Deadlock demo", thread1, thread2);
        System.out.println("Both threads are stuck because each is waiting for the other lock.");
    }

    private static void runFixedDemo() throws InterruptedException {
        Object lockA = new Object();
        Object lockB = new Object();

        Thread thread1 = new Thread(() -> runOrdered(lockA, lockB, "Thread-1"), "Fixed-Thread-1");
        Thread thread2 = new Thread(() -> runOrdered(lockA, lockB, "Thread-2"), "Fixed-Thread-2");

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        printStates("Fixed demo", thread1, thread2);
        System.out.println("Both threads finished because they acquired locks in the same order.");
    }

    private static void runOrdered(Object lockA, Object lockB, String label) {
        synchronized (lockA) {
            System.out.println(label + " acquired LockA");
            sleepQuietly(100);
            synchronized (lockB) {
                System.out.println(label + " acquired LockB");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        runDeadlockDemo();
        runFixedDemo();
    }
}
