public class Main {
    public static void main(String[] args) {
        System.out.println("Creating employees...");

        Employee e1 = new Employee("Alice", "HR", 20000, 3);
        Employee e2 = new Employee("Bob", "Engineering", 50000, 5);
        Employee e3 = new Employee("Charlie", "Sales", 15000, 0);

        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);

        System.out.println();
        System.out.println("Bonuses:");
        System.out.printf("%s default bonus: %.2f\n", e1.getEmployeeId(), e1.calculateBonus());
        System.out.printf("%s 15%% bonus: %.2f\n", e2.getEmployeeId(), e2.calculateBonus(15));
        System.out.printf("%s 10%% + experience bonus: %.2f\n", e2.getEmployeeId(), e2.calculateBonus(10, true));

        System.out.println();
        System.out.println("Total employees: " + Employee.getTotalEmployees());

        System.out.println();
        System.out.println("Testing validations (expect exceptions):");
        try {
            new Employee("", "Test", 20000, 1);
        } catch (Exception ex) {
            System.out.println("Caught expected error for empty name: " + ex.getMessage());
        }

        try {
            new Employee("Dave", "Test", 10000, 1);
        } catch (Exception ex) {
            System.out.println("Caught expected error for low salary: " + ex.getMessage());
        }

        try {
            new Employee("Eve", "Test", 20000, -2);
        } catch (Exception ex) {
            System.out.println("Caught expected error for negative experience: " + ex.getMessage());
        }
    }
}

