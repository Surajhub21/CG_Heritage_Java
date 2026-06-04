import java.util.Scanner;

public class Questions5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];
        int sum = 0;
        int max = Integer.MIN_VALUE;

        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < 5; i++) {
            numbers[i] = scanner.nextInt();
            sum += numbers[i];
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        System.out.println("Sum: " + sum);
        System.out.println("Maximum: " + max);
    }
}
