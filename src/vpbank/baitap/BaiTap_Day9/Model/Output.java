package vpbank.baitap.BaiTap_Day9.Model;
import java.util.Date;

public class Output {
    private String day;
    private Date date;
    private String phoneNumber;
    private String description;

    public Output() {
    }

    public Output(String day, Date date, String phoneNumber, String description) {
        this.day = day;
        this.date = date;
        this.phoneNumber = phoneNumber;
        this.description = description;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
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
}
