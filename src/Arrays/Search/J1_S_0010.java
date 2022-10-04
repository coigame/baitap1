package Arrays.Search;

import static Arrays.Search.Search.*;

public class J1_S_0010 {
    static void linearSearch(int[] arr, int search){
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == search){
                count++;
                System.out.println("\n" + "Found " + search + " at index " + i);
            }
        }
        if(count == 0){
            System.out.println("\n" + "searched value doesn't present in the array.");
        }
    }

    public static void main(String[] args) {
        Search.starter();
        linearSearch(array, integer);
    }
}
