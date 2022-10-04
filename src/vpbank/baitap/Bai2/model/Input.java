package vpbank.baitap.Bai2.model;
import java.io.File;
import java.util.ArrayList;

public class Input extends Match{
    private int dateFolder;
    private String phoneNumber;
    private File filePhoneNumber;

    public Input() {

    }

    public Input(int dateFolder, String phoneNumber, File filephonenumber) {
        this.dateFolder = dateFolder;
        this.filePhoneNumber = filephonenumber;
        this.phoneNumber = phoneNumber;
    }

    public int getDateFolder() {
        return dateFolder;
    }

    public void setDateFolder(int dateFolder) {
        this.dateFolder = dateFolder;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public File getFilePhoneNumber() {
        return filePhoneNumber;
    }

    public void setFilePhoneNumber(File filePhoneNumber) {
        this.filePhoneNumber = filePhoneNumber;
    }
}
