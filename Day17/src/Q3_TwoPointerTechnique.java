public class Q3_TwoPointerTechnique {
    
    public static void findPairs(int[] arr, int targetSum) {
        int left = 0;
        int right = arr.length - 1;
        
        System.out.println("Pairs that add up to " + targetSum + ":");
        
        while (left < right) {
            int sum = arr[left] + arr[right];
            
            if (sum == targetSum) {
                System.out.println("(" + arr[left] + ", " + arr[right] + ")");
                left++;
                right--;
            } else if (sum < targetSum) {
                left++;
            } else {
                right--;
            }
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15};
        int targetSum = 16;
        
        System.out.println("Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        findPairs(arr, targetSum);
    }
}

