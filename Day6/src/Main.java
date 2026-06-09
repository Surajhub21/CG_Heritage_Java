public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student(1, "Alice", 92.5);
        Student s3 = new Student(2, "Bob", 67.0);

        s1.display();
        s2.display();
        s3.display();

        System.out.println("Total students: " + Student.studentCount);
    }
}

