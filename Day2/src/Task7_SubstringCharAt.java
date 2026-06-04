public class Task7_SubstringCharAt {

    public static void main(String[] args) {

        // Substring, charAt
        String empCode = "EMP-FIN-2042";
        String dept = empCode.substring(4, 7);
        String empNumber = empCode.substring(8);
        char firstChar = empCode.charAt(0);
        System.out.println("empCode = " + empCode);
        System.out.println("department(4,7) = " + dept);
        System.out.println("employee number(8) = " + empNumber);
        System.out.println("charAt(0) = " + firstChar);
    }
}
