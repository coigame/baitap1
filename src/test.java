import java.io.File;

public class test {

    public static void main(String[] args) {
        File file = new File("C:\\Developer\\BaiTap_Javacore_1\\inPut1.txt");
        File[] array = file.listFiles();
        System.out.println(array == null);
    }
}
