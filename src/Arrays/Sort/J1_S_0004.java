package Arrays.Sort;
import java.util.Random;

public class J1_S_0004 extends Sort {
    static int minimum(int[] arr, int from, int to) {
        int minimum = arr[from];
        for (int i = from; i < to; i++) {
            if (minimum > arr[i]) {
                minimum = arr[i];
            }
        }
        return minimum;
    }
    static int maximum(int[] arr, int from, int to) {
        int maximum = arr[from];
        for (int i = from; i < to; i++) {
            if (maximum < arr[i]) {
                maximum = arr[i];
            }
        }
        return maximum;
    }
    static int pivot(int[] arr, int from, int to) {
        Random rand = new Random();
        int k = minimum(arr, from, to);
        int l = maximum(arr, from, to);

        return rand.nextInt((l - k) + 1) + k;
    }
    static void swap(int[] arr, int from, int to) {
        int swap = arr[from];
        arr[from] = arr[to];
        arr[to] = swap;
    }
    static void quickSort(int[] arr, int from, int to) {
       int i = from;
       int j = to;
       int pivot = pivot(arr, i ,j);
       while(i < j){
           while(arr[i] < pivot) {
               i++;
           }
           while (arr[j] > pivot) {
               j--;
           }
           if(i <= j) {
               swap(arr, i, j);
               i++;
               j--;
           }
       }

       if(j > from){
           quickSort(arr, from, j);
       }
       if(i < to){
           quickSort(arr, i, to);
       }
    }

    public static void main(String[] args) {
        Sort.starter();
        quickSort(array, 0 ,array.length -1);
        System.out.println("\n" + "Sorted Array ");
        for (int arrays: array) {
            System.out.print(arrays + "\t");
        }
    }
}
