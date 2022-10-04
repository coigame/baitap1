package vpbank.baitap.Bai1;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Bai1 {
    static ArrayList<String> stringOutPut = new ArrayList<>();
    public ArrayList<String> readFile(String filePath) {
        try {
            File myfile = new File(filePath);
            Scanner scan = new Scanner(myfile);
            while (scan.hasNextLine()) {
                String s = scan.nextLine();
                stringOutPut.add(s);
            }
            scan.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return stringOutPut;
    }
    public void printUpperWords() {
        Pattern pattern = Pattern.compile("[A-Z]");
        System.out.println("Cac ky tu in hoa la: ");
        for (String value : stringOutPut) {
            char[] characters = value.toCharArray();
            for (char c :
                    characters) {
                String s = Character.toString(c);
                if (pattern.matcher(s).matches()) {
                    System.out.print(s + "\t");
                }
            }
        }
    }
    public void countCharacter() {
        int count = 0;
        for (String s : stringOutPut) {
            char[] characters = s.toCharArray();
            for (char c :
                    characters) {
                if (!Character.isWhitespace(c)) {
                    count++;
                }
            }
        }
        System.out.println("Số lượng ký tự: " + count);
    }
    public void countLowerCharacter() {
        int count = 0;
        Pattern pattern = Pattern.compile("[A-Z]");
        for (String value : stringOutPut) {
            char[] characters = value.toCharArray();
            for (char c :
                    characters) {
                String s = Character.toString(c);
                if (!Character.isWhitespace(c) && !pattern.matcher(s).matches()) {
                    count++;
                }
            }
        }
        System.out.println("Số ký tự thường: " + count);
    }
    public void replaceString() {
        for (int i = 0; i < stringOutPut.size(); i++) {
            String old = "Toi yeu ha noi pho";
            String replace = stringOutPut.get(i).replace(old, old.toUpperCase());
            stringOutPut.set(i, replace);
        }
    }
    public void deleteBlankSpace() {
//        for (int i = 0; i < stringOutPut.size(); i++) {
//            String replace = stringOutPut.get(i).replaceAll("\\s\\s+", " ").trim();
//            stringOutPut.set(i, replace);
//        }
        stringOutPut.replaceAll(s -> s.replaceAll("\\s\\s+", " ").trim());
    }
    public void addString() {
        for (int i = 0; i < stringOutPut.size(); i++) {
            String old = "$";
            if(stringOutPut.get(i).contains(old)){
                int at = stringOutPut.get(i).indexOf(old);
                StringBuilder sb = new StringBuilder(stringOutPut.get(i));
                String add = sb.insert(at + 1,"o con ga cua toi").toString();
                stringOutPut.set(i, add);
            }
        }
    }

    public static void main(String[] args) {
        try {
            Bai1 myobj = new Bai1();
            File output = new File("outPut1.txt");
            String input = "C:\\Developer\\BaiTap_Javacore_1\\inPut1.txt";
            ArrayList<String> arrayList = myobj.readFile(input);
            
            myobj.printUpperWords();
            myobj.countCharacter();
            myobj.countLowerCharacter();
            myobj.deleteBlankSpace();
            myobj.replaceString();
            myobj.addString();

            FileWriter mywriter = new FileWriter(output);
            for(String s: arrayList){
                mywriter.write(s + "\n");
            }
            mywriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
