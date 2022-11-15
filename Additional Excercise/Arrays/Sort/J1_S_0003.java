package Arrays.Sort;

public class J1_S_0003 extends Sort {
    static boolean validSortFromPoint(int[] y, int point){
        int q = 0;
        if(point == 1){
            if(y[0] > y[1]){
                q+=1;
            }
        }
        else {
            for (int i = 1; i < point; i++) {
                if (y[i - 1] > y[i] || y[i] > y[i + 1]) {
                    q += 1;
                }
            }
        }
        return q == 0;
    }

    static void insertionFromPoint(int[] x, int position){
        int insert = x[position];
            for(int i = position; i > 0 ; i--){
                if (!validSortFromPoint(x, i)) {
                    x[i] = x[i - 1];
                    x[i - 1] = insert;
                }
            }
    }

    static void insertionSort(int[] insert){
        for(int i = 1; i < insert.length; i++){
            insertionFromPoint(insert, i);
        }
    }

    public static void main(String[] args) {
        Sort.starter();
        insertionSort(array);
        System.out.println("\n" + "Sorted Array ");
        for (int arrays: array) {
            System.out.print(arrays + "\t");
        }
    }
}
