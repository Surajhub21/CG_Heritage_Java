public class Task6_StringMethods {

    public static void main(String[] args) {

        // String trim() and case methods
        String raw = "  John Doe  ";
        String trimmed = raw.trim();
        String upper = trimmed.toUpperCase();
        String lower = trimmed.toLowerCase();
        System.out.println("Original: '" + raw + "' (length=" + raw.length() + ")");
        System.out.println("trim(): '" + trimmed + "' (length=" + trimmed.length() + ")");
        System.out.println("toUpperCase(): " + upper);
        System.out.println("toLowerCase(): " + lower);
    }
}
