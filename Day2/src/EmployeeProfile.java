public class EmployeeProfile {

    public static void main(String[] args) {

        //Task 1 - declare all 8 primitive types
        int employeeId = 101;
        long annualSalaryLong = 500000L;
        float taxRate = 2.5f;
        double performanceGrade = 4.7;
        char gender = 'M';
        boolean isActive = true;
        byte experienceYears = 3;
        short teamSize = 5;

        System.out.println("employeeId : " + employeeId);
        System.out.println("annualSalaryLong : " + annualSalaryLong);
        System.out.println("taxRatePercent : " + taxRate);
        System.out.println("performanceGrade : " + performanceGrade);
        System.out.println("gender : " + gender);
        System.out.println("isActive : " + isActive);
        System.out.println("experienceYears : " + experienceYears);
        System.out.println("teamSize : " + teamSize);

        System.out.println();
        // Task 2 - Strings
        String name1 = "Employee1";
        String name2 = "Employee1";
        String email = "employee1@gmail.com";
        String department = "SWE";

        System.out.println("name.equals: " + name1.equals(name2));
        System.out.println("name1 == name2: " + (name1 == name2));
        System.out.println("name1 == \"Employee1\": " + (name1 == "Employee1"));

        System.out.println();
        // Task 3 - implicit widening
        byte b = 10;
        short s = b;
        int i = s;
        long l = i;
        float f = l;
        double d = f;
        System.out.println("byte b = " + b);
        System.out.println("short s = " + s);
        System.out.println("int i = " + i);
        System.out.println("long l = " + l);
        System.out.println("float f = " + f);
        System.out.println("double d = " + d);

        // Task 4 - narrowing casts
        System.out.println();
        double salaryDouble = 75000.99;
        int salaryInt = (int) salaryDouble;
        System.out.println("double salaryDouble = " + salaryDouble);
        System.out.println("int salaryInt = (int) salaryDouble -> " + salaryInt);

        float rating = 4.8f;
        int ratingInt = (int) rating;
        System.out.println("float rating = " + rating + " -> (int) rating = " + ratingInt);

        System.out.println();
        // Task 5 - strings to numbers
        String intString = "120";
        String doubleString = "45.75";
        int parsedInt = Integer.parseInt(intString);
        double parsedDouble = Double.parseDouble(doubleString);
        System.out.println("Parsed int: " + parsedInt + ", Parsed double: " + parsedDouble);
        System.out.println("Arithmetic = " + (parsedInt + parsedDouble));

        // Task 6 - String trim() and case methods
        System.out.println("\n--- String trimming and case methods ---");
        String raw = "  John Doe  ";
        String trimmed = raw.trim();
        String upper = trimmed.toUpperCase();
        String lower = trimmed.toLowerCase();
        System.out.println("Original: '" + raw + "' (length=" + raw.length() + ")");
        System.out.println("trim(): '" + trimmed + "' (length=" + trimmed.length() + ")");
        System.out.println("toUpperCase(): " + upper);
        System.out.println("toLowerCase(): " + lower);

        System.out.println();
        // Task 7 - substring, charAt
        String empCode = "EMP-FIN-2042";
        String dept = empCode.substring(4, 7);
        String empNumber = empCode.substring(8);
        char firstChar = empCode.charAt(0);
        System.out.println("empCode = " + empCode);
        System.out.println("department(4,7) = " + dept);
        System.out.println("employee number(8) = " + empNumber);
        System.out.println("charAt(0) = " + firstChar);

        System.out.println();
        // Task 8 - validation method
        System.out.println("validateEmployeeCode(\"EMP-FIN-2042\") -> " + validateEmployeeCode("EMP-FIN-2042"));
        System.out.println("validateEmployeeCode(\"ABC-HR-12A4\") -> " + validateEmployeeCode("ABC-HR-12A4"));

        System.out.println();
        // Task 9 - ternary operator
        double sampleSalary = 80000.0;
        boolean sampleActive = true;
        String performance = (sampleSalary > 70000) ? "Top Performer" : "Needs Improvement";
        System.out.println(performance);

    }

    /*
    Write a validation method: check if an employee code starts with "EMP",
    contains a department code, and ends with a 4-digit number.
    Use startsWith(), contains(), endsWith().
     */
    // Validation method described in the task
    public static boolean validateEmployeeCode(String code) {
        if (code == null){
            return false;
        }
        boolean starts = code.startsWith("EMP");
        boolean containsDash = code.contains("-");
        // check last 4 characters are digits
        if (code.length() < 4) {
            return false;
        }

        String last4 = code.substring(code.length() - 4);

        boolean last4Digits = false;
        try{
            int digits = Integer.parseInt(last4);

            if(digits >= 1000 && digits <= 9999){
                last4Digits = true;
            }

        } catch (Exception e) {}

        boolean ends = code.endsWith(last4);

        return starts && containsDash && last4Digits && ends;
    }
}
