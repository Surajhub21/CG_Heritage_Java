import java.util.Scanner;

public class LargestSmallest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Input array elements
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Assume first element is largest and smallest
        int largest = arr[0];
        int smallest = arr[0];

        // Find largest and smallest
        for (int i = 1; i < n; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }

            if (arr[i] < smallest) {
                smallest = arr[i];
            }
        }

        // Display results
        System.out.println("Largest = " + largest);
        System.out.println("Smallest = " + smallest);

        sc.close();
    }
}