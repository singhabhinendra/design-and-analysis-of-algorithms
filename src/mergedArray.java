import java.util.Arrays;

public class mergedArray {
    public static void main(String[] args) {
        int[] arr1=new int[]{1,2,3,4,5,6};
        int[] arr2=new int[]{7,8,9,10,11,12,13,14};
        int[] arr3=new int[arr1.length+arr2.length];
        int i=0;
        int j=0;
        int k=0;
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]<arr2[j]){
                arr3[k]=arr1[i];
                i++;
                k++;
            }
            else {
                arr3[k] = arr2[j];
                j++;
                k++;
            }
        }
        System.out.println(Arrays.toString(arr3));
        while(i<arr1.length) {
            arr3[k] = arr1[i];
            i++;
            k++;
        }
        while(j<arr1.length){
            arr3[k]=arr1[j];
            j++;
            k++;
        }
//        System.out.println(Arrays.toString(arr3));
    }
}
