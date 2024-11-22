import java.util.Arrays;
import java.util.Scanner;
public class BubbleSort {
    public static void main(String[] args) {
      int[] arr = new int[10];
      Scanner sc = new Scanner(System.in);
      for (int i = 0; i < arr.length; i++) {
          arr[i]=sc.nextInt();
      }
      bubbleSort(arr);
//      bubbleSort(new []{1,2,3,4,4});
    }
    public static void bubbleSort(int[] array){
        int n=array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if(array[j]>array[j+1]){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
