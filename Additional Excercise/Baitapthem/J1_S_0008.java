package Baitapthem;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class J1_S_0008 {
    static ArrayList<String> Count(ArrayList<String> array) {
        ArrayList<String> result = new ArrayList<>();
        while (array.size() != 0) {
            int count = 0;
            int i = 0;
            for (; i < array.size(); i++) {
                if (array.get(0).equals(array.get(i))) {
                    count += 1;
                    if (i != 0) {
                        array.remove(i);
                    }
                }
            }
            String tokenresult = array.get(0) + "=" + count;
            result.add(tokenresult);
            array.remove(0);
        }
        return result;
    }

        public static void main (String[]args){
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your content: ");
            String s = scan.nextLine();
            StringTokenizer st1 = new StringTokenizer(s);
            ArrayList<String> token = new ArrayList<>();
            ArrayList<String> letter = new ArrayList<>();

            while (st1.hasMoreTokens()) {
                token.add(st1.nextToken());
            }

            for(int i = 0; i < s.length()-1; i++){
                if(s.charAt(i) != ' '){
                    letter.add(s.substring(i,i+1));
                }
            }

            ArrayList<String> counttoken = Count(token);
            ArrayList<String> countletter = Count(letter);

            for (String i: counttoken ) {
                System.out.print(i + ",");
            }
            System.out.println(" ");
            for(String j: countletter){
                System.out.print(j + ",");
            }
        }
    }