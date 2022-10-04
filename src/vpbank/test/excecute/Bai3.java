package vpbank.test.excecute;
import vpbank.test.model.Area;
import vpbank.test.model.Positions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.*;
import java.text.DateFormat;

public class Bai3 {
    List<Positions> records = new ArrayList<>();
    List<Area> areas = new ArrayList<>();
    public List<Positions> readPosition(String filePath){
        List<Positions> records = new ArrayList<>();
        int ID;
        int longitude;
        int latitude;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        Date time;
        try {
            File ships = new File(filePath);
            Scanner reader = new Scanner(ships);
            while (reader.hasNextLine()) {
                String information = reader.nextLine();
                String[] attribute = information.split("[|]");

                try {
                    ID = Integer.parseInt(attribute[0]);
                    longitude = Integer.parseInt(attribute[1]);
                    latitude = Integer.parseInt(attribute[2]);
                    time = dateFormat.parse(attribute[3]);
                    Positions record = new Positions(ID, longitude, latitude, time);
                    records.add(record);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return records;
    }
    public List<Area> readArea(String filePath){
        List<Area> areas = new ArrayList<>();
        String name;
        int longitudeleft;
        int longituderight;
        int latitudetop;
        int latitudebottom;

        try{
            File area = new File(filePath);
            Scanner reader = new Scanner(area);
            while (reader.hasNextLine()) {
                String information = reader.nextLine();
                String[] attribute = information.split("[|]");

                try {
                    name = attribute[0];
                    longitudeleft = Integer.parseInt(attribute[1]);
                    longituderight = Integer.parseInt(attribute[2]);
                    latitudetop = Integer.parseInt(attribute[3]);
                    latitudebottom = Integer.parseInt(attribute[4]);
                    Area areaobj = new Area(name, longitudeleft, longituderight, latitudetop, latitudebottom);
                    areas.add(areaobj);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return areas;
    }
    public boolean inArea(Positions p, Area a){
        return a.getLongitudeleft() <= p.getLongitude() && p.getLongitude() <= a.getLongituderight()
                && a.getLatitudebottom() <= p.getLatitude() && p.getLatitude() <= a.getLatitudetop();
    }
    public String Area(Positions p){
        for (Area a:
             areas) {
            if(inArea(p, a)){
                return a.getName();
            }
        }
        return null;
    }
    public boolean isSameShips(Positions first, Positions second){
        return first.getID() == second.getID();
    }
    public boolean isInSameArea(Positions starts, Positions ends){
        if(Area(starts) != null && Area(ends) != null){
            return Area(starts).equals(Area(ends));
        }
        else {
            return Area(starts) == null && Area(ends) == null;
        }
    }
    public void writeAlertFile(String filePathPosition, String filePathArea, String filePathAlert){
        try {
            FileWriter myWriter = new FileWriter(filePathAlert);
            records = readPosition(filePathPosition);
            areas = readArea(filePathArea);
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

            for (int i = 0; i < records.size() - 1; i++){
                if (!isInSameArea(records.get(i), records.get(i+1)) && isSameShips(records.get(i), records.get(i+1))){
                    Positions p = records.get(i+1);
                    Positions s = records.get(i);
                    String areastart  = Area(s);
                    String areaend = Area(p);
                    String time = dateFormat.format(p.getTime());
                    if(Area(records.get(i)) == null){
                        myWriter.write(p.getID() + " | Canh bao xam nhap vung | "  + areaend + " | " +
                              p.getLongitude() + " | " + p.getLatitude() + " | " + time + "\n");
                    }
                    else if(Area(records.get(i+1)) == null){
                        myWriter.write(p.getID() + " | Canh bao di ra khoi vung | "  + areastart + " | " +
                                p.getLongitude() + " | " + p.getLatitude() + " | " + time + "\n");
                    }
                    else {
                        myWriter.write(p.getID() + " | Canh bao xam nhap vung | "  + areaend + " | " +
                                p.getLongitude() + " | " + p.getLatitude() + " | " + time + "\n");
                        myWriter.write(p.getID() + " | Canh bao di ra khoi vung | "  + areastart + " | " +
                                p.getLongitude() + " | " + p.getLatitude() + " | " + time + "\n");
                    }
                }
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
