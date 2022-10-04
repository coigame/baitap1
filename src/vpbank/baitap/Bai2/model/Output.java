package vpbank.baitap.Bai2.model;

import java.io.File;

public class Output extends Match{
    private int dateFolder;
    private String phoneNumber;
    private File filephonenumber;

    public Output() {
    }

    public Output(int dateFolder, String phoneNumber, File filephonenumber) {
        this.dateFolder = dateFolder;
        this.filephonenumber = filephonenumber;
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

    public File getFilephonenumber() {
        return filephonenumber;
    }

    public void setFilephonenumber(File filephonenumber) {
        this.filephonenumber = filephonenumber;
    }
}
