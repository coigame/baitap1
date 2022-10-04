package vpbank.baitap.Bai2;

import vpbank.baitap.Bai2.excecute.Bai2;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            Bai2 object = new Bai2();
            File dirInput = new File("C:\\Developer\\BaiTap_Javacore_1\\input");
            File dirOutput  = new File("C:\\Developer\\BaiTap_Javacore_1\\output");

            File input = new File("input_co.txt");
            File output = new File("output_co.txt");

            object.Matcher(dirInput,  dirOutput);
            object.WriteInput(input.getName());
            object.WriteOutput(output.getName());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
