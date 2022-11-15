package vpbank.ThreadBai1.Excecute;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ThreadCopy {
    static Queue<File> newFiles = new LinkedList<>();
    public static boolean compare(File Input, File Output){
        boolean haveNewFile = false;
        File[] inputChildren = Input.listFiles();
        File[] outputChildren = Output.listFiles();

        if(inputChildren.length == outputChildren.length){
            int similar = 0;
            for (File fileInput:
                    inputChildren) {
                for (File fileOutput:
                        outputChildren) {
                    if(fileInput.getName().equals(fileOutput.getName())){
                        similar += 1;
                    }
                }
            }
            if(similar != inputChildren.length){
                haveNewFile = true;
            }
        }else if(inputChildren.length > outputChildren.length){
            haveNewFile = true;
        }
        return haveNewFile;
    }

    public synchronized void findNewFile(File[] input, File[] output){
            for (File inputs : input) {
                int identity = 0;
                for (File outputs : output) {
                    if (inputs.getName().equals(outputs.getName())) {
                        identity = 1;
                    }
                }
                if (identity == 0) {
                    newFiles.add(inputs);
                }
            }
            notify();
    }

    public void CopyFile(File fileInput, String outputPath){
        ArrayList<String> fileContent = new ArrayList<>();
        try {
            File output = new File(outputPath + "\\" + fileInput.getName());
            Scanner scanner = new Scanner(fileInput);
            while (scanner.hasNextLine()){
                String content = scanner.nextLine();
                fileContent.add(content);
            }
            FileWriter fileWriter = new FileWriter(output);
            for (String content: fileContent
                 ) {
                fileWriter.write(content + "\n");
                System.out.println("Successfully wrote to the file.");
            }
            fileWriter.close();
            scanner.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public synchronized void CopyNewFiles(String outputPath) {
            try {
                wait();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            while (newFiles.size() != 0) {
                File input = newFiles.poll();
                CopyFile(input, outputPath);
                input.delete();
                System.out.println(newFiles.size());
            }
        }
}
