public class Employee {
    private final String employeeId;
    private String name;
    private String department;
    private double baseSalary;
    private int experienceYears;

    private static int nextSequence = 1;
    private static int totalEmployees = 0;

    public Employee(String name, String department, double baseSalary, int experienceYears) {
        this.employeeId = generateEmployeeId();
        totalEmployees++;
        setName(name);
        setDepartment(department);
        setBaseSalary(baseSalary);
        setExperienceYears(experienceYears);
    }

    private static synchronized String generateEmployeeId() {
        String id = String.format("EMP%03d", nextSequence);
        nextSequence++;
        return id;
    }

    public static int getTotalEmployees() {
        return totalEmployees;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary < 15000) {
            throw new IllegalArgumentException("Salary must be >= 15000");
        }
        this.baseSalary = baseSalary;
    }

    public void setExperienceYears(int experienceYears) {
        if (experienceYears < 0) {
            throw new IllegalArgumentException("Experience years must be 0 or more");
        }
        this.experienceYears = experienceYears;
    }

    @Override
    public String toString() {
        return String.format("Employee{id='%s', name='%s', dept='%s', salary=%.2f, exp=%d yrs}",
                employeeId, name, department, baseSalary, experienceYears);
    }

    public double calculateBonus() {
        return calculateBonus(10.0);
    }

    public double calculateBonus(double percentage) {
        if (percentage < 0) {
            throw new IllegalArgumentException("Percentage cannot be negative");
        }
        return baseSalary * (percentage / 100.0);
    }

    public double calculateBonus(double percentage, boolean includeExperienceBonus) {
        double bonus = calculateBonus(percentage);
        if (includeExperienceBonus) {
            bonus += 1000.0 * experienceYears;
        }
        return bonus;
    }
}

