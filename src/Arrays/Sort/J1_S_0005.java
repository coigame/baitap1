package Arrays.Sort;

public class J1_S_0005 extends Sort {
    static int[] merge(int[] x, int[] y) {
        int[] A = new int[x.length + y.length];
        int i = 0, j = 0, n = 0;
        while (i < x.length && j < y.length) {
            if (x[i] <= y[j])
                A[n++] = x[i++];
            else
                A[n++] = y[j++];
        }
        for (; i == x.length && j < y.length; A[n++] = y[j++]);
        for (; j == y.length && i < x.length; A[n++] = x[i++]);

        return A;
    }
    static int[] mergeSort(int[] arr) {
        int[] arrleft;
        int[] arrright;
        int[] ar1 = null;
        int[] ar2 = null;
        int midpoint = arr.length / 2;
        if (arr.length == 1) {
            return arr;
        }

        if (arr.length % 2 != 0) {
            arrleft = new int[midpoint];
            System.arraycopy(arr, 0, arrleft, 0, midpoint);
            arrright = new int[midpoint + 1];
            System.arraycopy(arr, midpoint, arrright, 0, midpoint + 1);
        } else {
            arrright = new int[midpoint];
            System.arraycopy(arr, 0, arrright, 0, midpoint);
            arrleft = new int[midpoint];
            System.arraycopy(arr, midpoint, arrleft, 0, midpoint);
        }

        if (midpoint != 0) {
            ar1 = mergeSort(arrright);
            ar2 = mergeSort(arrleft);
        }

        return merge(ar1, ar2);
    }

    public static void main(String[] args) {
        Sort.starter();
        int[] Result = mergeSort(array);
        System.out.println("\n" + "Sorted Array ");
        for (int arrays : Result) {
            System.out.print(arrays + "\t");
        }
    }
}
