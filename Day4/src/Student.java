public class Student {
    int rollNumber;
    String name;
    double marks;
    static int studentCount = 0;

    public Student() {
        this.rollNumber = 0;
        this.name = "Unknown";
        this.marks = 0.0;
        studentCount++;
    }

    public Student(int rollNumber, String name, double marks) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.marks = marks;
        studentCount++;
    }

    public void display() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + calculateGrade());
        System.out.println();
    }

    private char calculateGrade() {
        if (marks >= 85.0) return 'A';
        else if (marks >= 70.0) return 'B';
        else if (marks >= 50.0) return 'C';
        else return 'F';
    }
}

