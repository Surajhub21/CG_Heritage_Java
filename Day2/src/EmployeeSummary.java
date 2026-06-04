public class EmployeeSummary {
    public static void main(String[] args) {
        int[] ids = {1001, 1002, 1003, 1004, 1005};
        String[] names = {"  Alice Johnson ", "Bob Smith", "Carla M. Lopez", "daniel o'neal", "Eva Green"};
        double[] salaries = {85000.75, 65000.0, 92000.5, 72000.0, 48000.25};
        boolean[] active = {true, false, true, true, false};
        String[] departments = {"Engineering", "HR", "Finance", "engineering", "Sales"};
        byte[] yearsExp = {5, 2, 10, 4, 1};
        char[] genders = {'F', 'M', 'F', 'M', 'F'};

        System.out.println("ID     NAME                 SALARY      STATUS     DEPT         EXP G");
        System.out.println("---------------------------------------------------------------------");

        for (int i = 0; i < ids.length; i++) {
            String cleaned = names[i].trim();
            String lower = cleaned.toLowerCase();
            String[] parts = lower.split(" +");
            StringBuilder sb = new StringBuilder();
            for (String p : parts) {
                if (p.length() > 0) {
                    sb.append(p.substring(0, 1).toUpperCase()).append(p.substring(1)).append(" ");
                }
            }
            String displayName = sb.toString().trim();
            String dept = departments[i].trim();
            String status = active[i] ? "Active" : "Inactive";
            int salaryWhole = (int) salaries[i];
            int expInt = (int) yearsExp[i];

            System.out.printf("%-6d %-20s %10.2f %-10s %-12s %3d %c%n",
                    ids[i], displayName, salaries[i], status, dept, expInt, genders[i]);
        }
    }
}
