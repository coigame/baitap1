package Arrays.Search;

import java.util.ArrayList;

public class J1_S_0006 extends Search {
    static int binarySearch(int[] arr, int from, int to, int search){
        int midpoint = (from + to)/2;
        int i = -1;
        if(from < to) {
            if (arr[midpoint] == search) {
                return midpoint;
            }
            if (arr[midpoint] > search) {
               i =  binarySearch(arr, from, midpoint- 1, search);
            }
            if (arr[midpoint] < search){
               i = binarySearch(arr, midpoint + 1, to, search);
            }
            if(i != -1){
                return i;
            }
        }
        else if(from == to){
            if(arr[midpoint] == search){
                return midpoint;
            }
        }
        return i;
    }
    static ArrayList<Integer> binarySearchArray(int[] arr, int number, int search){
        ArrayList<Integer> result = new ArrayList<>();

            for(int i = number; i < arr.length; i++) {
                if (arr[i] == search) {
                    result.add(i);
                }
                else if (arr[i] > search) {
                    break;
                }
            }

            for(int j = number-1; j >=0; j--){
                if(arr[j] == search){
                    result.add(j);
                }
                else if (arr[j] < search) {
                    break;
                }
            }
            return result;
    }

    public static void main(String[] args) {
        Search.starter();
        int result = binarySearch(array, 0 ,array.length-1, integer);
        if(result == -1){
            System.out.println("\n" + "searched value doesn't present in the array.");
        }
        else{
            System.out.print("\n" + "Found " + integer + " at index ");
            for (int find:
            binarySearchArray(array, result, integer)) {
                System.out.print("\t" + find);
            }
        }
    }
}
