package vpbank.baitap.BaiTap_Day9.Excecutor;

import vpbank.baitap.BaiTap_Day9.Model.Input;
import vpbank.baitap.BaiTap_Day9.Model.Output;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.FileWriter;

public class Bai9 {
    ArrayList<File> fileInput = new ArrayList<>();
    HashMap<String, ArrayList<Output>> dateMapOutput = new HashMap<>();
    ArrayList<Input> objectInputs  = new ArrayList<>();
    ArrayList<Output> objectOutputs = new ArrayList<>();

    public void addFileInput(String filePath) {
        File dir = new File(filePath);
        File[] children = dir.listFiles();
        if (children != null) {
            Collections.addAll(fileInput, children);
        }
    }

    public void readFiles() throws Exception{
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        for (File file:
             fileInput) {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()){
                String line = scan.nextLine();
                String[] attributes = line.split("[|]");
                String description = attributes[0];
                Date date = dateFormat.parse(attributes[1]);
                String phoneNumber = file.getName().substring(0, file.getName().indexOf("."));
                Input input = new Input(date, phoneNumber, description);
                objectInputs.add(input);
            }
            scan.close();
        }
    }

    public void sortInputs(){
        Collections.sort(objectInputs);
    }

    public void addOutput(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (Input input:
                objectInputs){
            String date = dateFormat.format(input.getDate());
            Output output = new Output(date, input.getDate(), input.getPhoneNumber(), input.getDescription());
            objectOutputs.add(output);
        }
    }

    public boolean sameDay(Output day1, Output day2){
        return day1.getDay().compareTo(day2.getDay()) == 0;
    }

    public void mapping(){
        ArrayList<Output> mapList = new ArrayList<>();
        for(int i = 0; i < objectOutputs.size(); i++){
            mapList.add(objectOutputs.get(i));
            if (i == objectOutputs.size() - 1) {
                dateMapOutput.put(objectOutputs.get(i).getDay(), mapList);
            }else if(!sameDay(objectOutputs.get(i), objectOutputs.get(i+1)) && i < objectOutputs.size() - 1){
                ArrayList<Output> add = new ArrayList<>();
                Output[] array = mapList.toArray(new Output[0]);
                Collections.addAll(add, array);
                dateMapOutput.put(objectOutputs.get(i).getDay(), add);
                mapList.clear();
            }
        }
    }

    public void writeFileOutput(String filePath) throws Exception{
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        Set<String> keySet = dateMapOutput.keySet();
        File directory = new File(filePath);
        if(!directory.exists()){
            directory.mkdirs();
        }
        for (String key : keySet) {
           File file = new File(directory.getAbsolutePath() + "\\" + key + ".txt");
           FileWriter myWriter = new FileWriter(file.getAbsolutePath());
            for (Output o : dateMapOutput.get(key)) {
                String description = o.getDescription();
                String phoneNumber = o.getPhoneNumber();
                String date = dateFormat.format(o.getDate());
                myWriter.write(date + "|" + phoneNumber + "|" + description + "\n");
            }
            myWriter.close();
        }
        System.out.println("Successfully wrote to the file.");
    }
}
