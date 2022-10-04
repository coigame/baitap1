package vpbank.test.model;

import java.util.Date;

public class Positions {
    protected int ID;
    protected int longitude;
    protected int latitude;
    protected Date time;

    public Positions() {
    }

    public Positions(int ID, int longitude, int latitude, Date time) {
        this.ID = ID;
        this.longitude = longitude;
        this.latitude = latitude;
        this.time = time;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
