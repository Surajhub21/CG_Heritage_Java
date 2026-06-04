public class Task4_NarrowingCasts {

    public static void main(String[] args) {

        // Narrowing casts
        double salaryDouble = 75000.99;
        int salaryInt = (int) salaryDouble;
        System.out.println("double salaryDouble = " + salaryDouble);
        System.out.println("int salaryInt = (int) salaryDouble -> " + salaryInt);

        float rating = 4.8f;
        int ratingInt = (int) rating;
        System.out.println("float rating = " + rating + " -> (int) rating = " + ratingInt);
    }
}
