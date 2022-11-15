package Arrays.Sort;
import java.util.Random;
import java.util.Scanner;

public class Sort {
    public static float a;
    public static int[] array;
    static boolean validInt(float y){
        int i = (int) Math.floor(y);
        return i != y;
    }
    static void inputRandomInt(int[] list){
        Random ran = new Random();
        for (int i =0; i < list.length; i++){
            int ranDomNum = ran.nextInt(list.length);
            list[i] = ranDomNum;
        }
    }
    static void starter(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of array :");
        a = scan.nextFloat();

        while (validInt(a)) {
            System.out.println("You must enter an integer");
            System.out.println("Enter number of array :");
            a = scan.nextFloat();
        }

        int n = (int) a;
        array = new int[n];
        inputRandomInt(array);
        System.out.println("Unsorted array");
        for (int arrays: array) {
            System.out.print(arrays + "\t")  ;
        }
    }
}
