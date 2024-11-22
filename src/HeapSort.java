import java.util.*;
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = { 3, 4, 2, 5, 1, 9 };

        arr = createHeap(arr);

        System.out.println(Arrays.toString(arr));

        int end = arr.length - 1;
        while (end > 0) {
            swap(arr, 0, end);
            downheapyfy(arr, 0, end);
            end--;
        }
        System.out.println(Arrays.toString(arr));

    }

    private static void downheapyfy(int[] arr, int pi, int end) {
        int idx = pi;
        int lci = 2 * pi + 1;
        int rci = 2 * pi + 2;

        if (lci < end && arr[idx] < arr[lci]) {
            idx = lci;
        }
        if (rci < end && arr[idx] < arr[rci]) {
            idx = rci;
        }

        if (idx != pi) {
            swap(arr, idx, pi);
            downheapyfy(arr, idx, end);
        }
    }

    private static int[] createHeap(int[] arr) {
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = arr[i];
            upheapyfy(ans, i);
        }
        return ans;
    }

    private static void upheapyfy(int[] ans, int ci) {
        int pi = (ci - 1) / 2;
        if (ans[pi] < ans[ci]) {
            swap(ans, pi, ci);
            upheapyfy(ans, pi);
        }
    }

    private static void swap(int[] ans, int pi, int ci) {
        int cv = ans[ci];
        int pv = ans[pi];
        ans[pi] = cv;
        ans[ci] = pv;
    }

}