import java.util.*;

public class Q4_MenuDrivenPhonebook {
    private static HashMap<String, String> phoneBook = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        phoneBook.put("Alice", "9876543210");
        phoneBook.put("Bob", "9123456789");
        phoneBook.put("Charlie", "8765432109");

        int choice;

        while (true) {
            displayMenu();
            System.out.print("\nEnter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    searchContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    showAllContacts();
                    break;
                case 6:
                    System.out.println("\nThank you for using Phonebook. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("\nInvalid choice! Please enter a number between 1 and 6.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n=== PHONEBOOK MENU ===");
        System.out.println("1. Add Contact");
        System.out.println("2. Search Contact");
        System.out.println("3. Update Contact");
        System.out.println("4. Delete Contact");
        System.out.println("5. Show All Contacts (Sorted by Name)");
        System.out.println("6. Exit");
    }

    private static void addContact() {
        System.out.print("\nEnter contact name: ");
        String name = scanner.nextLine().trim();

        if (phoneBook.containsKey(name)) {
            System.out.println("Contact already exists! Use update option to modify.");
            return;
        }

        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine().trim();

        if (!phoneNumber.matches("\\d{10}")) {
            System.out.println("Invalid phone number! Please enter a 10-digit number.");
            return;
        }

        phoneBook.put(name, phoneNumber);
        System.out.println("Contact added successfully!");
    }

    private static void searchContact() {
        System.out.print("\nEnter contact name to search: ");
        String name = scanner.nextLine().trim();

        if (phoneBook.containsKey(name)) {
            System.out.println("Contact found!");
            System.out.println("Name: " + name + ", Phone: " + phoneBook.get(name));
        } else {
            System.out.println("Contact not found!");
        }
    }

    private static void updateContact() {
        System.out.print("\nEnter contact name to update: ");
        String name = scanner.nextLine().trim();

        if (!phoneBook.containsKey(name)) {
            System.out.println("Contact not found!");
            return;
        }

        System.out.print("Enter new phone number: ");
        String phoneNumber = scanner.nextLine().trim();

        if (!phoneNumber.matches("\\d{10}")) {
            System.out.println("Invalid phone number! Please enter a 10-digit number.");
            return;
        }

        phoneBook.put(name, phoneNumber);
        System.out.println("Contact updated successfully!");
    }

    private static void deleteContact() {
        System.out.print("\nEnter contact name to delete: ");
        String name = scanner.nextLine().trim();

        if (!phoneBook.containsKey(name)) {
            System.out.println("Contact not found!");
            return;
        }

        phoneBook.remove(name);
        System.out.println("Contact deleted successfully!");
    }

    private static void showAllContacts() {
        if (phoneBook.isEmpty()) {
            System.out.println("\nPhonebook is empty!");
            return;
        }

        System.out.println("\n=== ALL CONTACTS (SORTED BY NAME) ===");
        TreeMap<String, String> sortedContacts = new TreeMap<>(phoneBook);

        for (Map.Entry<String, String> entry : sortedContacts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

