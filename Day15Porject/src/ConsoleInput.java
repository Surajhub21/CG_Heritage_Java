import java.util.Scanner;

public class ConsoleInput implements AutoCloseable {

    private final Scanner scanner = new Scanner(System.in);

    public int readInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value >= min && value <= max) {
                    return value;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.println("Please enter a valid number between " + min + " and " + max + ".");
        }
    }

    public boolean askContinue() {
        while (true) {
            System.out.println("Do you want to continue or take the points and leave?");
            System.out.println("1. Continue");
            System.out.println("2. Take points and leave");
            String input = scanner.nextLine().trim();
            if (input.equals("1")) {
                return true;
            }
            if (input.equals("2")) {
                return false;
            }
            System.out.println("Please enter 1 or 2.");
        }
    }

    @Override
    public void close() {
        scanner.close();
    }
}

