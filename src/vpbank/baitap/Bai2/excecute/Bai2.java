package vpbank.baitap.Bai2.excecute;
import vpbank.baitap.Bai2.model.Input;
import vpbank.baitap.Bai2.model.Match;
import vpbank.baitap.Bai2.model.Output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Bai2 {
    static ArrayList<Input> inputs = new ArrayList<>();
    static ArrayList<Output> outputs = new ArrayList<>();
    static ArrayList<Match> matchPhoneNumber = new ArrayList<>();
    public boolean validFileInput(String filename){
        Pattern pattern = Pattern.compile("^cdr_\\d{8}_8x56_\\d+[.]txt$");
        return pattern.matcher(filename).matches();
    }
    public boolean validFileOutput(String filename){
        Pattern pattern = Pattern.compile("^\\d{8}_8x56_\\d+[.]txt$");
        return pattern.matcher(filename).matches();
    }
    public boolean validPhoneNumber(String phoneNum){
        Pattern pattern = Pattern.compile("^849\\d{7}$");
        return pattern.matcher(phoneNum).matches();
    }
    public ArrayList<String> readFile(File file){
        ArrayList<String> numbers = new ArrayList<>();
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String phonenumber = reader.nextLine();
                if(validPhoneNumber(phonenumber)) {
                    numbers.add(phonenumber);
                }
            }
            reader.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return numbers;
    }
    public void InputStep1(File folderInput){
        try {
            File[] dateFileInput = folderInput.listFiles();
            File[] file;
            assert dateFileInput != null;
            for (File date:
                    dateFileInput) {
                file = date.listFiles();
                if (file != null) {
                    InputStep2(file, date);
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void InputStep2(File[] file, File date){
        for (File cdr:
                file) {
            if(validFileInput(cdr.getName())){
                int dateInt = Integer.parseInt(date.getName());
                InputStep3(dateInt, cdr);
            }
        }
    }
    public void InputStep3(int dateInt, File cdr){
        for (String phonenumber:
             readFile(cdr)) {
            Input obj = new Input(dateInt, phonenumber, cdr);
            inputs.add(obj);
        }
    }
    public void OutputStep1(File folderOutput){
        try {
            File[] dateFileOutput = folderOutput.listFiles();
            File[] file;
            assert dateFileOutput != null;
            for (File date:
                    dateFileOutput) {
                file = date.listFiles();
                assert file != null;
                OutputStep2(file, date);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void OutputStep2(File[] file, File date){
        for (File cdr:
                file) {
            if(validFileOutput(cdr.getName())){
                int dateInt = Integer.parseInt(date.getName());
                OutputStep3(dateInt, cdr);
            }
        }
    }
    public void OutputStep3(int dateInt, File cdr){
        for (String phonenumber:
                readFile(cdr)) {
            Output obj = new Output(dateInt, phonenumber, cdr);
            outputs.add(obj);
        }
    }
    public void Matcher(File folderInput, File folderOutput){
        try {
            InputStep1(folderInput);
            OutputStep1(folderOutput);
            for (Input input : inputs) {
                for (Output output : outputs) {
                    if (input.getDateFolder() == output.getDateFolder() && input.getPhoneNumber().equals(output.getPhoneNumber())) {
                        Match match = new Match(input.getDateFolder(), input.getPhoneNumber());
                        matchPhoneNumber.add(match);
                    }
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void WriteOutput(String filename){
        try {
            FileWriter myWriter = new FileWriter(filename);
            for(Output output: outputs){
                int count = 0;
                for(Match match: matchPhoneNumber){
                    if(output.getPhoneNumber().equals(match.getPhoneNumber()) && output.getDateFolder() == match.getDateFolder()){
                        count++;
                    }
                }
                if(count == 0){
                    myWriter.write(output.getDateFolder() + ": " + output.getPhoneNumber() + "\n");
                }
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public void WriteInput(String filename){
        try {
            FileWriter myWriter = new FileWriter(filename);
            for(Input input: inputs){
                int count = 0;
                for(Match match: matchPhoneNumber){
                    if(input.getPhoneNumber().equals(match.getPhoneNumber()) && input.getDateFolder() == match.getDateFolder()){
                        count++;
                    }
                }
                if(count == 0){
                    myWriter.write(input.getDateFolder() + ": " + input.getPhoneNumber() + "\n");
                }
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
