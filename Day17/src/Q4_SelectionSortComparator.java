import java.util.Arrays;
import java.util.Comparator;

public class Q4_SelectionSortComparator {
    
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
    
    public static void main(String[] args) {
        int[] marks = {78, 45, 89, 23, 67, 90, 12};
        
        System.out.println("Original marks: ");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println();
        
        int[] ascendingArr = marks.clone();
        selectionSort(ascendingArr);
        
        System.out.println("\nMarks sorted in ascending order (Selection Sort): ");
        for (int mark : ascendingArr) {
            System.out.print(mark + " ");
        }
        System.out.println();
        
        Integer[] descendingArr = new Integer[marks.length];
        for (int i = 0; i < marks.length; i++) {
            descendingArr[i] = marks[i];
        }
        
        Arrays.sort(descendingArr, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b.compareTo(a);
            }
        });
        
        System.out.println("\nMarks sorted in descending order (Comparator): ");
        for (int mark : descendingArr) {
            System.out.print(mark + " ");
        }
        System.out.println();
    }
}

