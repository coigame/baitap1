package vpbank.baitap.BaiTap_Day9;

import vpbank.baitap.BaiTap_Day9.Excecutor.Bai9;

public class Main {
    public static void main(String[] args) {
        try {
            Bai9 obj = new Bai9();
            obj.addFileInput("C:\\Developer\\BaiTap_Javacore_1\\BaiTap_Day9\\input");
            obj.readFiles();
            obj.sortInputs();
            obj.addOutput();
            obj.mapping();
            obj.writeFileOutput("C:\\Developer\\BaiTap_Javacore_1\\BaiTap_Day9\\output");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
