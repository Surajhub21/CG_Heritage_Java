import java.util.Scanner;

public class Q5_CombinedDSA {
    
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
    
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[8];
        
        System.out.println("Enter 8 unsorted numbers:");
        for (int i = 0; i < 8; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }
        
        System.out.print("Enter target number to search: ");
        int target = scanner.nextInt();
        
        System.out.println("\n--- Step 1: Linear Search on Unsorted Array ---");
        System.out.println("Time Complexity: O(n)");
        System.out.println("Space Complexity: O(1)");
        
        int linearResult = linearSearch(arr, target);
        
        if (linearResult != -1) {
            System.out.println("Element found at index " + linearResult + " using Linear Search");
        } else {
            System.out.println("Element not found using Linear Search");
        }
        
        System.out.println("\n--- Step 2: Bubble Sort ---");
        System.out.println("Time Complexity: O(n^2)");
        System.out.println("Space Complexity: O(1)");
        
        int[] sortedArr = arr.clone();
        bubbleSort(sortedArr);
        
        System.out.print("Sorted array: ");
        for (int num : sortedArr) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        System.out.println("\n--- Step 3: Binary Search on Sorted Array ---");
        System.out.println("Time Complexity: O(log n)");
        System.out.println("Space Complexity: O(1)");
        
        int binaryResult = binarySearch(sortedArr, target);
        
        if (binaryResult != -1) {
            System.out.println("Element found at new index " + binaryResult + " using Binary Search");
        } else {
            System.out.println("Element not found using Binary Search");
        }
        
        System.out.println("\n--- Overall Complexity Analysis ---");
        System.out.println("Step 1 - Linear Search: O(n)");
        System.out.println("Step 2 - Bubble Sort: O(n^2)");
        System.out.println("Step 3 - Binary Search: O(log n)");
        System.out.println("Total: O(n^2) (dominated by Bubble Sort)");
        
        scanner.close();
    }
}

