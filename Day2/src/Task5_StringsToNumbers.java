public class Task5_StringsToNumbers {

    public static void main(String[] args) {

        // Strings to numbers
        String intString = "120";
        String doubleString = "45.75";
        int parsedInt = Integer.parseInt(intString);
        double parsedDouble = Double.parseDouble(doubleString);
        System.out.println("Parsed int: " + parsedInt + ", Parsed double: " + parsedDouble);
        System.out.println("Arithmetic = " + (parsedInt + parsedDouble));
    }
}
