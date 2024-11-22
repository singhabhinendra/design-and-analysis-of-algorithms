import java.util.Arrays;
public class ShellSort {
    public static void main(String[] args) {
        int[] arr=new int[]{12,10,15,14,19,1,3,5,2,4};
        System.out.println(Arrays.toString(shellSort(arr)));
    }
    public static int[] shellSort(int[] arr){
        int n=arr.length;
        int gap=n/2;
        for (int i = gap;gap>0;gap=gap/2) {
            for (int j = gap;j<n ; j++) {
                if(arr[j]<arr[j-gap]){
                    int temp=arr[j];
                    arr[j]=arr[j-gap];
                    arr[j-gap]=temp;
                }
            }
        }
        return arr;
    }
}
