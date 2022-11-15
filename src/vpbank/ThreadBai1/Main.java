package vpbank.ThreadBai1;

import vpbank.ThreadBai1.Excecute.ThreadCopy;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String inputPath = "C:\\Developer\\Bai tap Thread\\input";
        String outputPath = "C:\\Developer\\Bai tap Thread\\output";

        File input = new File(inputPath);
        File output = new File(outputPath);
        input.mkdirs();
        output.mkdirs();

        final ThreadCopy threadCopy = new ThreadCopy();
            Thread t1 = new Thread(() -> {
                while (true) {
                    if (threadCopy.compare(input, output)) {
                        File[] inputChildren = input.listFiles();
                        File[] outputChildren = output.listFiles();
                        threadCopy.findNewFile(inputChildren, outputChildren);
                    }
                    try {
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            });

            Thread t2 = new Thread(() -> {
                while (true) {
                    try {
                        threadCopy.CopyNewFiles(outputPath);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            });

            t1.start();
            t2.start();
        }

}
