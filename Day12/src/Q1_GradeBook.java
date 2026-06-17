import java.util.*;

public class Q1_GradeBook {
    public static void main(String[] args) {
        HashMap<String, Integer> gradeBook = new HashMap<>();

        gradeBook.put("Alice", 85);
        gradeBook.put("Bob", 35);
        gradeBook.put("Charlie", 92);
        gradeBook.put("Diana", 38);
        gradeBook.put("Eve", 78);
        gradeBook.put("Frank", 29);

        System.out.println("=== ALL STUDENTS AND MARKS ===");
        for (Map.Entry<String, Integer> entry : gradeBook.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("\n=== STUDENT WITH HIGHEST MARKS ===");
        String topStudent = findTopStudent(gradeBook);
        System.out.println("Student: " + topStudent + ", Marks: " + gradeBook.get(topStudent));

        System.out.println("\n=== REMOVING STUDENTS WITH MARKS < 40 ===");
        removeFailedStudents(gradeBook);

        System.out.println("\n=== UPDATED GRADE BOOK ===");
        for (Map.Entry<String, Integer> entry : gradeBook.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static String findTopStudent(HashMap<String, Integer> gradeBook) {
        String topStudent = null;
        int maxMarks = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : gradeBook.entrySet()) {
            if (entry.getValue() > maxMarks) {
                maxMarks = entry.getValue();
                topStudent = entry.getKey();
            }
        }
        return topStudent;
    }

    private static void removeFailedStudents(HashMap<String, Integer> gradeBook) {
        Iterator<Map.Entry<String, Integer>> iterator = gradeBook.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            if (entry.getValue() < 40) {
                System.out.println("Removing " + entry.getKey() + " with marks: " + entry.getValue());
                iterator.remove();
            }
        }
    }
}

