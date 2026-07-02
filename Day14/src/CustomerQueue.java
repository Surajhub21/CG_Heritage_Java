import java.util.LinkedList;
import java.util.Queue;

public class CustomerQueue {

    public static void main(String[] args) {
        Queue<String> q = new LinkedList<>();
        q.add("Alice");
        q.add("Bob");
        q.add("Charlie");
        q.add("Diana");
        q.add("Eve");
        System.out.println("After adding 5 customers, next: " + q.peek());
        System.out.println(q);
        String served = q.poll();
        System.out.println("Serving: " + served + ", next: " + q.peek());
        served = q.poll();
        System.out.println("Serving: " + served + ", next: " + q.peek());
        q.add("Frank");
        q.add("Grace");
        System.out.println("After adding 2 more, next: " + q.peek());
        System.out.println("Remaining customers: " + q);
    }

}

