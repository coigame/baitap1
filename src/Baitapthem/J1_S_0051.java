package Baitapthem;

import java.util.Scanner;

public class J1_S_0051 {
    static J1_S_0051 calculated = new J1_S_0051();
    static Scanner scanner = new Scanner(System.in);

    // Đây là code calculator
    enum Operator {
        add("+"),
        subtract("-"),
        multiply("*"),
        divide("/"),
        exponents("^"),
        equal("=");
        private final String operation;
        Operator(String operation) {
            this.operation = operation;
        }
    }
    static boolean validateInteger(double a) {
        int valid = (int) a;
        return valid == a;
    }
    static Double checkin(String inputVal) {
        try {
            return Double.parseDouble(inputVal);
        } catch (Exception e) {
            return null;
        }
    }
    static Operator checkOperator(String operator) {
        Operator result = null;
        for (Operator o :
                Operator.values()) {
            if (operator.equals(o.operation)) {
                result = o;
            }
        }
        return result;
    }
    public double calculate(double a, Operator operator, double b) {
        double result = 0;
        switch (operator) {
            case add: {
                result = a + b;
                break;
            }
            case subtract: {
                result = a - b;
                break;
            }
            case multiply: {
                result = a * b;
                break;
            }
            case divide: {
                if (b == 0) {
                    System.out.println("Cannot divide by zero");
                } else {
                    result = a / b;
                }
                break;
            }
            case exponents: {
                while (!validateInteger(b)) {
                    System.out.println("Index must be an integer");
                    b = scanner.nextInt();
                }
                int index = (int) b;
                result = Math.pow(a, index);
                break;
            }
            case equal: {
                return result;
            }
        }
        return result;
    }
    public static void continueCalculate(double result) {
        double next = 0;
        String numnext;
        String operator;
        do {
            do {
                System.out.println("Enter Operator: ");
                operator = scanner.nextLine();
                if (checkOperator(operator) == null)
                    System.out.println("Please input (+, -, *, /, ^, =)");
            } while (checkOperator(operator) == null);

            if (operator.equals("=")) {
                System.out.println("Result: " + result);
                break;
            } else {
                do {
                    System.out.println("Enter number: ");
                    numnext = scanner.nextLine();
                    if (checkin(numnext) != null) {
                        next = checkin(numnext);
                    } else {
                        System.out.println("Please enter number");
                    }
                } while (checkin(numnext) == null);
            }
            result = calculated.calculate(result, checkOperator(operator), next);
            System.out.println("Memory: " + result);
        }
        while (true);
    }
    static void calculator() {
        String num2;
        String num1;
        double x = 0;
        double y = 0;
        String operator;
        double result = 0;

        System.out.println("----- Normal Calculator -----");
        do {
            System.out.println("Enter number: ");
            scanner.nextLine();
            num1 = scanner.nextLine();
            if (checkin(num1) != null) {
                x = checkin(num1);
            } else {
                System.out.println("Please enter number");
            }
        }
        while (checkin(num1) == null);

        do {
            System.out.println("Enter Operator: ");
            operator = scanner.nextLine();
            if (checkOperator(operator) == null)
                System.out.println("Please input (+, -, *, /, ^, =)");
        } while (checkOperator(operator) == null);

        if (operator.equals("=")) {
            System.out.println("Result: " + num1);
        } else {
            do {
                System.out.println("Enter number: ");
                num2 = scanner.nextLine();
                if (checkin(num2) != null)
                    y = checkin(num2);
            } while (checkin(num2) == null);

            try {
                result = calculated.calculate(x, checkOperator(operator), y);
                System.out.println("Memory: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Cannot Divide By Zero");
            }
            continueCalculate(result);
        }
    }
    //end

    //Đây là code BMI
    enum BMI{
        Understandard,
        Standard,
        Overweight,
        Fat,
        Very_fat,
    }
    public BMI calculateBMI (double weight, double height){
        double BMI = height/(weight*weight);
        if(BMI < 19){
            return J1_S_0051.BMI.Understandard;
        }
        else if(BMI < 25){
            return J1_S_0051.BMI.Standard;
        }
        else if (BMI < 30) {
            return J1_S_0051.BMI.Overweight;
        }
        else if (BMI <= 30) {
            return J1_S_0051.BMI.Fat;
        }
        else
        {
            return J1_S_0051.BMI.Very_fat;
        }
    }
    public static void BMICalculated(){
        String weight;
        double weightnumber = 0;
        String height;
        double heightnumber = 0;
        System.out.println("----- BMI Calculator -----");
        do{
            System.out.println("Enter Weight(kg): ");
            scanner.nextLine();
            weight = scanner.nextLine();
            if(checkin(weight) == null){
                System.out.println("BMI is digit");
            }
            else {
                weightnumber = Double.parseDouble(weight);
            }
        }while (checkin(weight) == null);

        do{
            System.out.println("Enter Height(cm): ");
            height = scanner.nextLine();
            if(checkin(height) == null){
                System.out.println("BMI is digit");
            }
            else {
                heightnumber = Double.parseDouble(height);
            }
        }while (checkin(height) == null);

        BMI result = calculated.calculateBMI(weightnumber, heightnumber/100);
        if(result == BMI.Very_fat){
            System.out.println("Very fat - should lose weight immediately: BMI is over 40");
        }
        else if(result == BMI.Fat){
            System.out.println("Fat - should lose weight : BMI is between 30-40");
        }
        else if (result == BMI.Overweight) {
            System.out.println("Overweight: BMI is between 25-30");
        }
        else if (result == BMI.Standard) {
            System.out.println("Standard: BMI is between 19-25 ");
        }
        else {
            System.out.println("Under-standard: BMI is less than 19");
        }
    }

    public static void main(String[] args) {
        loop:
        while (true) {
            System.out.println("========= Calculator Program =========\n" +
                    "1. Normal Calculator\n" +
                    "2. BMI Calculator\n" +
                    "3. Exit\n" +
                    "Please choose one option: ");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1: {
                    calculator();
                    scanner.nextLine();
                    break;
                }
                case 2: {
                    BMICalculated();
                    scanner.nextLine();
                    break;
                }
                case 3: {
                    break loop;
                }
                default:
                    System.out.println("Please choose one option: ");
            }
        }
    }
}
