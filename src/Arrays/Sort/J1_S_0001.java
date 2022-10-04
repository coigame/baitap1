package Arrays.Sort;

public class J1_S_0001 extends Sort {
    static boolean validSort(int[] valid){
        int q = 0;
        int x;
        int y;
        for(int i = 0; i < valid.length - 1; i++){
            x = valid[i];
            y = valid[i+1];
            if(x > y){
                q+=1;
            }
        }
        return q == 0;
    }
    static void bubleSort(int[] list){
        int a;
        int b;
        while(!validSort(list)) {
            for (int i = 0; i < list.length - 1; i++) {
                a = list[i];
                b = list[i+1];
                if (a > b) {
                    list[i] = b;
                    list[i+1] = a;
                }
            }
        }
    }

    public static void main(String[] args) {
        Sort.starter();

        bubleSort(array);
        System.out.println("\n" + "Sorted Array ");
        for (int arrays: array) {
            System.out.print(arrays + "\t");
        }
    }
}
