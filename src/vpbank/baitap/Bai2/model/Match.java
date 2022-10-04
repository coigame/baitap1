package vpbank.baitap.Bai2.model;

public class Match {
    private int dateFolder;
    private String phoneNumber;

    public Match(){

    }

    public Match(int dateFolder, String phoneNumber) {
        this.dateFolder = dateFolder;
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
}
