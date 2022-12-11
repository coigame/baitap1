package vpbank.ThreadBai2.Model;

public class Messages {
    private String action;
    private String phoneNumberFrom;
    private String phoneNumberTo;
    private String Money;

    public Messages() {
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getPhoneNumberFrom() {
        return phoneNumberFrom;
    }

    public void setPhoneNumberFrom(String phoneNumberFrom) {
        this.phoneNumberFrom = phoneNumberFrom;
    }

    public String getPhoneNumberTo() {
        return phoneNumberTo;
    }

    public void setPhoneNumberTo(String phoneNumberTo) {
        this.phoneNumberTo = phoneNumberTo;
    }

    public String getMoney() {
        return Money;
    }

    public void setMoney(String money) {
        Money = money;
    }
}
