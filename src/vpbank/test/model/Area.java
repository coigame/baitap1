package vpbank.test.model;

public class Area {
    private String name;
    private int longitudeleft;
    private int longituderight;
    private int latitudetop;
    private int latitudebottom;

    public Area() {
    }
    public Area(String name, int longitudeleft, int longituderight, int latidtudetop, int latitudebottom) {
        this.name = name;
        this.longitudeleft = longitudeleft;
        this.longituderight = longituderight;
        this.latitudetop = latidtudetop;
        this.latitudebottom = latitudebottom;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLongitudeleft() {
        return longitudeleft;
    }

    public void setLongitudeleft(int longitudeleft) {
        this.longitudeleft = longitudeleft;
    }

    public int getLongituderight() {
        return longituderight;
    }

    public void setLongituderight(int longituderight) {
        this.longituderight = longituderight;
    }

    public int getLatitudetop() {
        return latitudetop;
    }

    public void setLatitudetop(int latitudetop) {
        this.latitudetop = latitudetop;
    }

    public int getLatitudebottom() {
        return latitudebottom;
    }

    public void setLatitudebottom(int latitudebottom) {
        this.latitudebottom = latitudebottom;
    }
}
