class NamedRunnableTask implements Runnable {
    private final String displayName;

    NamedRunnableTask(String displayName) {
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

public class RunnableDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread namedThread = new Thread(new NamedRunnableTask("Named Runnable"), "NamedRunnable-Worker");
        Thread lambdaThread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Lambda Runnable | current thread: " + Thread.currentThread().getName() + " | print " + i);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }, "LambdaRunnable-Worker");

        namedThread.start();
        lambdaThread.start();
        namedThread.join();
        lambdaThread.join();
    }
}
