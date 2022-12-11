package vpbank.ThreadBai2.Model;

public class Msisdn {
    private String phoneNumber;
    private String CurrentMoney;
    private String lastUpdate;

    public Msisdn(String phoneNumber, String currentMoney, String lastUpdate) {
        this.phoneNumber = phoneNumber;
        CurrentMoney = currentMoney;
        this.lastUpdate = lastUpdate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCurrentMoney() {
        return CurrentMoney;
    }

    public void setCurrentMoney(String currentMoney) {
        CurrentMoney = currentMoney;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
