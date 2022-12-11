package vpbank.ThreadBai2.Excecute;

import vpbank.ThreadBai2.Model.Messages;
import vpbank.ThreadBai2.Model.Msisdn;
import vpbank.ThreadBai2.Model.Output;
import vpbank.ThreadBai2.processing.ProcessingModel;
import vpbank.ThreadBai2.processing.ProcessingUtil;

import java.io.File;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.util.*;

public class ThreadBanking extends Thread{
    Queue<Output> results = new LinkedList<>();
    HashMap<String, Msisdn> customers = new HashMap<>();
    Set<String> phoneNumber = customers.keySet();
    Set<File> checkedFiles = new HashSet<>();

    public void readMsisdn(File Msisdn){
        try {
            Scanner scanner = new Scanner(Msisdn);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] contents = line.split("\\|");
                Msisdn msisdn = new Msisdn(contents[0], contents[1], contents[2]);
                customers.put(msisdn.getPhoneNumber(), msisdn);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public synchronized void checkInput(File Input){
        long startTime = System.nanoTime();
        File[] files = Input.listFiles();
        assert files != null;
        if(checkedFiles.isEmpty()){
            for (File file: files) {
                executeInputFile(file);
                notifyAll();
                checkedFiles.add(file);
                try {
                    Thread.sleep(2000);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }else {
            for (File file: files) {
                if (!checkedFiles.contains(file)){
                    executeInputFile(file);
                    notifyAll();
                    checkedFiles.add(file);
                    try {
                        Thread.sleep(2000);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
    }
    public void executeInputFile(File Messages){
        try {
            Scanner scanner = new Scanner(Messages);
            while (scanner.hasNextLine()){
                Msisdn customerFrom;
                Msisdn customerTo;
                String money;
                boolean value;

                String line = scanner.nextLine();
                String[] message = line.split("\\|");
                Messages messages = ProcessingModel.messageCreate(message);
                switch (messages.getAction()){
                    case "transfer":
                        customerFrom = customers.get(messages.getPhoneNumberFrom());
                        customerTo = customers.get(messages.getPhoneNumberTo());
                        money = messages.getMoney();
                        value = ProcessingUtil.transfer(customerFrom, customerTo, money);
                        results.add(ProcessingModel.outputCreate(value, messages));
                        break;
                    case "add":
                        customerTo = customers.get(messages.getPhoneNumberTo());
                        money = messages.getMoney();
                        value = ProcessingUtil.add(customerTo, money);
                        results.add( ProcessingModel.outputCreate(value, messages));
                        break;
                    case "minus":
                        customerTo = customers.get(messages.getPhoneNumberTo());
                        money = messages.getMoney();
                        value = ProcessingUtil.minus(customerTo, money);
                        results.add(ProcessingModel.outputCreate(value, messages));
                        break;
                    default:
                        break;
                }
            }
            scanner.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public synchronized void updateMsisdn(File Msisdn){
        try {
            RandomAccessFile raf = new RandomAccessFile(Msisdn, "rw");
            raf.setLength(0);

            String fileContent;
            FileWriter writer = new FileWriter(Msisdn, true);
            for (String phoneNumber: phoneNumber){
               {
                   Msisdn customer = customers.get(phoneNumber);
                   fileContent = phoneNumber + "|" +  customer.getCurrentMoney() + "|" + customer.getLastUpdate();
                   writer.write(fileContent + "\n");
                }
            }
            System.out.println("SUCCESSFULLY WROTE TO FILE");
            writer.close();
            wait();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public synchronized void writeOutput(File Output){
        try {
            boolean append = Output.length() != 0;
            FileWriter outputWriter = new FileWriter(Output, append);
            while (results.size() != 0){
                Output output = results.poll();
                output.setStartProcess("Start");
                output.setEndProcess("End");
                if(output.getAction().equals("transfer")) {
                    outputWriter.write(output.getAction() + "|" +
                            output.getPhoneNumberFrom() + "|" +
                            output.getPhoneNumberTo() + "|" +
                            output.getMoneyAmount() + "|" +
                            output.getResult() + "|" + output.getResultDetail() + "|" +
                            output.getStartProcess() + "|" + output.getEndProcess() + "\n");
                }else {
                    outputWriter.write(output.getAction() + "|" +
                            output.getPhoneNumberTo() + "|" +
                            output.getMoneyAmount() + "|" +
                            output.getResult() + "|" + output.getResultDetail() + "|" +
                            output.getStartProcess() + "|" + output.getEndProcess() + "\n");
                }
            }
            outputWriter.close();
            wait();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
