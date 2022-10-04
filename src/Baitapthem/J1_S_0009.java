package Baitapthem;

public class J1_S_0009 {
    static int fibonacci(int n){
        if(n >= 2){
            return fibonacci(n-1) + fibonacci(n-2);
        }
        if(n == 1){
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("The 45 sequence fibonacci");
        for(int i = 0; i<=45; i++){
            System.out.print(fibonacci(i) + ", ");
        }
    }
}
