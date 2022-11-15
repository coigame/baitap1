package Baitapthem;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
class Validate{
    static ArrayList<Double> listdouble = new ArrayList<>();
    static ArrayList<Integer> listinterger = new ArrayList<>();
    static boolean validateNumber(String s){
        Pattern pattern = Pattern.compile("^(?!-0(\\.0+)?$)-?(0|[1-9]\\d*)(\\.\\d+)?$");
        return !pattern.matcher(s).matches();
    }
    static boolean validateInteger(double a) {
        int valid = (int) a;
        return valid == a;
    }
    static boolean validateOdd(int x){
        return x%2 != 0;
    }
    static boolean validateSquare(int x){
        return Math.sqrt(x) == (int) Math.sqrt(x);
    }
}
class CalculateEquation extends Validate{
    private static void calculateSuperlativeEquation(){
        Scanner scan = new Scanner(System.in);

        System.out.println(" ----- Calculate Equation ----- ");
        System.out.print("Enter A: ");
        String A = scan.nextLine();
        while (validateNumber(A)){
            System.out.println("Please input number");
            A = scan.nextLine();
        }

        System.out.print("Enter B: ");
        String B = scan.nextLine();
        while (validateNumber(B)){
            System.out.println("Please input number");
            B = scan.nextLine();
        }
        double x = Double.parseDouble(A);
        double y = Double.parseDouble(B);

        listdouble.add(x);
        listdouble.add(y);

        if(x==0 && y==0){
            System.out.println("Solution: empty");
        }
        else if (x == 0) {
            System.out.println("Solution: null");
        }
        else {
            System.out.println("Solution: x = " + x / y);
        }

        for (double j: listdouble) {
                if(validateInteger(j)){
                    listinterger.add((int) j);
                }
            }


            System.out.print("Number is Odd:");
            for (int i: listinterger
                 ) {
                if(validateOdd(i)){
                    System.out.print("\t" + i);
                }
            }
            System.out.print("\n");

            System.out.print("Number is Even:");
            for (int i: listinterger
                 ) {
                if(!validateOdd(i)){
                    System.out.print("\t" + i);
                }
            }
            System.out.print("\n");

            System.out.print("Number is Square: ");
            for (int i: listinterger
            ) {
                if(validateSquare(i)){
                    System.out.print("\t" + i);
                }
            }
            System.out.print("\n");
    }
}
class CalculateQuadraticEquation extends Validate {
    static ArrayList<Double> quadraticEquation(double x, double y, double z){
        double root1;
        double root2;
        ArrayList<Double> result = new ArrayList<>();
        if(x == 0){
            result = null;
        }
        else {
            double delta = y * y - 4 * x * z;
            if (delta >= 0) {
                root1 = (-y + Math.sqrt(delta)) / (2 * x);
                root2 = (-y - Math.sqrt(delta)) / (2 * x);
                result.add(root1);
                result.add(root2);
            } else {
                result = null;
            }
        }
        return result;
    }
    public static void calculateQuadraticEquation() {
        Scanner scan = new Scanner(System.in);

        System.out.println("----- Calculate Quadratic Equation -----");
        System.out.print("Enter A: ");
        String A = scan.nextLine();
        while (validateNumber(A)) {
            System.out.println("Please input number");
            A = scan.nextLine();
        }

        System.out.print("Enter B: ");
        String B = scan.nextLine();
        while (validateNumber(B)) {
            System.out.println("Please input number");
            B = scan.nextLine();
        }

        System.out.print("Enter C: ");
        String C = scan.nextLine();
        while (validateNumber(C)) {
            System.out.println("Please input number");
            C = scan.nextLine();
        }

            double x = Double.parseDouble(A);
            double y = Double.parseDouble(B);
            double z = Double.parseDouble(C);

            listdouble.add(x);
            listdouble.add(y);
            listdouble.add(z);

           ArrayList<Double> result =  quadraticEquation(x,y,z);

           if(result == null){
               if(x == 0 && y==0 && z==0){
                   System.out.println("Solution: empty");
               } else if (x == 0) {
                   System.out.println("System error");
               }
               else {
                   System.out.println("Solution: null");
               }
           }
           else {
               System.out.println("Solution: x1 = " + result.get(0) + " and x2 = " + result.get(1));
           }

            for (double j : listdouble) {
                if (validateInteger(j)) {
                    listinterger.add((int) j);
                }
            }

        System.out.print("Number is Odd:");
        for (int i: listinterger
        ) {
            if(validateOdd(i)){
                System.out.print("\t" + i);
            }
        }
        System.out.print("\n");

        System.out.print("Number is Even:");
        for (int i: listinterger
        ) {
            if(!validateOdd(i)){
                System.out.print("\t" + i);
            }
        }
        System.out.print("\n");

        System.out.print("Number is Square: ");
        for (int i: listinterger
        ) {
            if(validateSquare(i)){
                System.out.print("\t" + i);
            }
        }
        System.out.print("\n");
    }
}

public class J1_S_0050 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
        System.out.print("========= Equation Program =========\n" +
                "1. Calculate Superlative Equation\n" +
                "2. Calculate Quadratic Equation\n" +
                "3. Exit\n" +
                "Please choose one option:\n");
        int choose = scanner.nextInt();
        while (choose != 1 && choose != 2 && choose != 3){
            System.out.println("Please choose one option:\n");
            choose = scanner.nextInt();
        }
        switch (choose) {
                case 1: {
                    CalculateEquation.calculateSuperlativeEquation();
                    scanner.nextLine();
                    scanner.nextLine();
                    break;
                }
                case 2: {
                    CalculateQuadraticEquation.calculateQuadraticEquation();
                    scanner.nextLine();
                    scanner.nextLine();
                    break;
                }
                case 3: {
                    loop = false;
                    scanner.nextLine();
                    scanner.nextLine();
                    break;
                }
            }
        }
    }
}
