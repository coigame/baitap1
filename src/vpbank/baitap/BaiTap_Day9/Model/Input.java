package vpbank.baitap.BaiTap_Day9.Model;

import java.util.Date;

public class Input implements Comparable<Input>{
    private Date date;
    private String phoneNumber;
    private String description;

    public Input() {
    }

    public Input(Date date, String phoneNumber, String description) {
        this.date = date;
        this.phoneNumber = phoneNumber;
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int compareTo(Input input) {
        return this.getDate().compareTo(input.getDate());
    }
}
