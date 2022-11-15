package Arrays.Sort;

public class J1_S_0002 extends Sort {
    static int findPosition(int[] z, int value, int start){
        int find = 0;
        for(int i = start; i < z.length; i++){
            if(value == z[i]){
                find = i;
                break;
            }
        }
        return find;
    }
    static void swapPosition(int[] position, int from, int to){
        int swap = position[to];
        position[to] = position[from];
        position[from] = swap;
    }
    static int findMinimum(int[] x, int j){
        int y = x[j];
        for (int i = j; i < x.length - 1; i++){
            if(y > x[i+1]){
                y = x[i + 1];
            }
        }
        return y;
    }
    static void selectionSort(int[] n){
        int minimum;
        int position;
        for(int i = 0; i < n.length; i++){
            minimum = findMinimum(n, i);
            position = findPosition(n, minimum, i);
            swapPosition(n, position, i);
        }
    }

    public static void main(String[] args) {
        Sort.starter();

        selectionSort(array);
        System.out.println("\n" + "Sorted Array ");
        for (int arrays: array) {
            System.out.print(arrays + "\t");
        }
    }
}
