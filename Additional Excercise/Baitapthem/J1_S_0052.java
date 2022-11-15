package Baitapthem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Country{
    protected String countryCode;
    protected String countryName;
    protected float totalArea;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public float getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(float totalArea) {
        this.totalArea = totalArea;
    }

    public Country(){

    }

    public Country(String countryCode, String countryName, float totalArea) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.totalArea = totalArea;
    }

    public void display(){
        System.out.println("ID\t\t\tName\t\tTotalArea");
        System.out.println("");
        System.out.format("%32s%10s%16s", countryCode, countryName, totalArea);
    }
}
class EastAsiaCountries extends Country{
    private String countryTerrain;

    public String getCountryTerrain() {
        return countryTerrain;
    }

    public void setCountryTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    public EastAsiaCountries(){

    }

    public EastAsiaCountries(String countryCode, String countryName, float totalArea, String countryTerrain) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }

    @Override
    public void display(){
        System.out.println("ID\t\t\tName\t\tTotalArea\tTerrain");
        System.out.println("");
        System.out.format("%32s%16s%16s%16s", countryCode, countryName, totalArea, countryTerrain);
    }
}
public class J1_S_0052 {
    enum nameEastAsiaCountries{
        Brunei ("Brunei"),
        Cambodia ("Cambodia"),
        East_Timor ("East_Timor"),
        Indonesia ("Indonesia"),
        Laos ("Laos"),
        Malaysia ("Malaysia"),
        Myanmar ("Myanmar"),
        Philippines ("Philippines"),
        Singapore ("Singapore"),
        Thailand ("Thailand"),
        Vietnam ("Vietnam");
        private final String countryname;
        nameEastAsiaCountries(String name) {
            countryname = name;
        }
    }
    List<EastAsiaCountries> countries = new ArrayList<>();
    static J1_S_0052 obj = new J1_S_0052();
    static Scanner scanner = new Scanner(System.in);
    public void checkCountryName(String name) throws Exception{
        int count = 0;
        for (nameEastAsiaCountries namecountry:
             nameEastAsiaCountries.values()) {
            if(name.equals(namecountry.countryname)){
                count ++;
            }
        }
        if(count == 0){
            throw new Exception("INVALID COUNTRY NAME");
        }
    }
    public void checkDuplicate(String ID, String name) throws Exception{
       for (EastAsiaCountries country:
             countries) {
            if(country.countryCode.equals(ID) || country.countryName.equals(name)){
                throw new Exception("COUNTRY ALREADY EXIST");
            }
        }
    }
    public void addCountryInformation(EastAsiaCountries country) throws Exception{
            String countryCode;
            String countryName;
            float totalArea;
            String countryTerrain;

            System.out.println("Enter code of country: ");
            scanner.nextLine();
            countryCode = scanner.nextLine();
            country.setCountryCode(countryCode);

            System.out.println("Enter name of country: ");
            countryName = scanner.nextLine();
            country.setCountryName(countryName);

            System.out.println("Enter total vpbank.test.model.Area: ");
            totalArea = scanner.nextFloat();
            country.setTotalArea(totalArea);

            System.out.println("Enter terrain of country: ");
            scanner.nextLine();
            countryTerrain = scanner.nextLine();
            country.setCountryTerrain(countryTerrain);

            checkDuplicate(countryCode, countryName);
            checkCountryName(countryName);
            countries.add(country);
    }

    public EastAsiaCountries getRecentlyEnteredInformation() throws Exception{
        if(countries.size() == 0){
            throw new Exception("NO SUCH RESULT EXISTS");
        }
        else {
            return countries.get(countries.size() - 1);
        }
    }

    public EastAsiaCountries[] searchInformationByName(String name) throws Exception{
        int k = 0;
        checkCountryName(name);
        EastAsiaCountries result[] = new EastAsiaCountries[k];
        if(countries.size() == 0){
            throw new Exception("NO DATA");
        } else {
            for ( EastAsiaCountries o :countries) {
                if(name.equals(o.getCountryName())){
                    k++;
                    result[k] = o;
                }
            }
        }
        return result;
    }
    static boolean validSort(List<EastAsiaCountries> valid){
        int q = 0;
        String x;
        String y;
        for(int i = 0; i < valid.size() - 1; i++){
            x = valid.get(i).countryName;
            y = valid.get(i+1).countryName;
            if(x.compareTo(y) <= 0){
                q+=1;
            }
        }
        return q == 0;
    }
    public EastAsiaCountries[]sortInformationByAscendingOrder() throws Exception{
        if(countries.size() == 0){
            throw new Exception("NO DATA");
        } else {
            EastAsiaCountries[] countriesarray = new EastAsiaCountries[countries.size()];
            while (!validSort(countries)){
                for(int i = 0 ; i < countries.size() - 1; i++){
                    String x = countries.get(i).countryName;
                    String y = countries.get(i+1).countryName;
                    if(x.compareTo(y) > 0){
                        EastAsiaCountries swap = countries.get(i);
                        countries.set(i, countries.get(i + 1));
                        countries.set(i+1, swap);
                    }
                }
            }
           for (int i = 0; i < countries.size(); i++){
               countriesarray[i] = countries.get(i);
           }
            return  countriesarray;
        }
    }

    public static void main(String[] args) throws Exception {
        loop:
        while (true) {
            System.out.println("                               MENU\n" +
                    "==========================================================================\n" +
                    "1. Input the information of 11 countries in East Asia\n" +
                    "2. Display the information of country you've just input\n" +
                    "3. Search the information of country by user-entered name\n" +
                    "4. Display the information of countries sorted name in ascending order  \n" +
                    "5. Exit \n" +
                    "==========================================================================\n");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:{
                    try {
                        EastAsiaCountries country = new EastAsiaCountries();
                        obj.addCountryInformation(country);
                        System.out.println("INPUT SUCCESSFULLY");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 2:{
                    try{
                        obj.getRecentlyEnteredInformation();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 5:{
                    break loop;
                }
            }
        }
    }
}
