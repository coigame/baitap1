package Arrays.Search;

import java.util.Random;
import java.util.Scanner;

public class Search {
    static float a;
    static int[] array;
    static float x;
    static int integer;
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
    static void sort(int[] list){
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

    public static void starter(){
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
        sort(array);

        System.out.println("Enter search value: ");
        x = scan.nextFloat();

        while(validInt(x)){
            System.out.println("You must enter an integer");
            System.out.println("Enter search value :");
            x = scan.nextFloat();
        }
        integer = (int) x;

        System.out.println("Sorted array:");
        for (int arrays: array) {
            System.out.print(arrays + "\t")  ;
        }
    }
}
