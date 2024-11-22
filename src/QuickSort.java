public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 23, 4, 45, 45};
        QuickSort(arr, 0, arr.length - 1);
        // Print the sorted array to verify the result
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    private static void QuickSort(int[] arr, int si, int ei) {
        if (si < ei) {
            int pi = findPivot(arr, si, ei); // Get the pivot index
            QuickSort(arr, si, pi - 1); // Recursively sort the left part
            QuickSort(arr, pi + 1, ei); // Recursively sort the right part
        }
    }

    private static int findPivot(int[] arr, int si, int ei) {
        int pivot = arr[ei]; // Choosing the last element as the pivot
        int pi = si; // Index where the pivot should be placed

        for (int i = si; i < ei; i++) {
            if (arr[i] <= pivot) {
                // Swap arr[i] and arr[pi]
                int temp = arr[i];
                arr[i] = arr[pi];
                arr[pi] = temp;
                pi++;
            }
        }

        // Swap the pivot element with arr[pi]
        int temp = arr[pi];
        arr[pi] = arr[ei];
        arr[ei] = temp;

        return pi; // Return the pivot index
    }
}
