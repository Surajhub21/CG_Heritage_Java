public class Main {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        java.util.List<Integer> nums = new java.util.ArrayList<>();
        while (sc.hasNextInt()) {
            nums.add(sc.nextInt());
        }
        sc.close();

        if (nums.isEmpty()) {
            return;
        }

        int max = nums.get(0);
        int min = nums.get(0);
        for (int n : nums) {
            if (n > max) {
                max = n;
            }
            if (n < min) {
                min = n;
            }
        }

        System.out.println("Largest = " + max);
        System.out.println("Smallest = " + min);
    }
}
