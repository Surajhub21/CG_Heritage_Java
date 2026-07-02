import java.util.*;

public class Q2_DuplicateFinder {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2, 3, 5, 6, 5, 1, 7};

        System.out.println("=== ARRAY ELEMENTS ===");
        System.out.print("Array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        findAndPrintDuplicates(nums);
    }

    private static void findAndPrintDuplicates(int[] nums) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        System.out.println("\n=== DUPLICATE ANALYSIS ===");
        System.out.print("Duplicates are: ");
        boolean first = true;

        for (Integer num : frequencyMap.keySet()) {
            if (frequencyMap.get(num) > 1) {
                if (!first) {
                    System.out.print(", ");
                }
                System.out.print(num);
                first = false;
            }
        }
        System.out.println();

        System.out.println("\n=== DUPLICATE FREQUENCIES ===");
        for (Integer num : frequencyMap.keySet()) {
            if (frequencyMap.get(num) > 1) {
                System.out.println("Number " + num + " appears " + frequencyMap.get(num) + " times");
            }
        }
    }
}

