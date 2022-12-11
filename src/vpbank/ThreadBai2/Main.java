package vpbank.ThreadBai2;

import vpbank.ThreadBai2.Excecute.ThreadBanking;

import java.io.File;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
        File input = new File("C:\\Developer\\Bai tap Thread 2\\input");
        File msisdn = new File("C:\\Developer\\Bai tap Thread 2\\msisdn.txt");
        File output = new File("C:\\Developer\\Bai tap Thread 2\\output.txt");

        final ThreadBanking banking = new ThreadBanking();
        banking.readMsisdn(msisdn);

        Thread t1 = new Thread(() -> {
            while (true) {
                banking.checkInput(input);
                try {
                    sleep(2000);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        );

        Thread t2 = new Thread(() -> {
            while(true) {
                banking.updateMsisdn(msisdn);
            }
        });

        Thread t3 = new Thread(() ->  {
            while (true) {
                banking.writeOutput(output);
            }
        });

        t1.start();
        t2.start();
        t3.start();

    }
}
