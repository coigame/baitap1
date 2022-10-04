package vpbank.test;

import vpbank.test.excecute.Bai3;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            File ships = new File("C:\\Developer\\positions.txt");
            Scanner myReaderfile = new Scanner(ships);
            while (myReaderfile.hasNextLine()) {
                String data = myReaderfile.nextLine();
                System.out.println(data);
            }
            myReaderfile.close();

            Bai3 Object = new Bai3();
            File alert = new File("alert.txt");
            Object.writeAlertFile("C:\\Developer\\positions.txt", "C:\\Developer\\area.txt", alert.getAbsolutePath());
            Scanner myReader = new Scanner(alert);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        }
        catch (Exception  e){
            System.out.println(e.getMessage());
        }
    }
}
