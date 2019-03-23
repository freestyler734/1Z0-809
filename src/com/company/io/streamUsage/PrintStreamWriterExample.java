package com.company.io.streamUsage;

import java.io.*;

public class PrintStreamWriterExample {

    public static void main(String[] args) {

        //File file = new File("C:\\Users\\User\\Desktop\\личное\\1Z0-809\\1Z0-809\\files\\printStream\\file.txt");
        File file = new File("/Users/ivan/Documents/1Z0-809/files/printStream/file.txt");
        try (PrintStream printStream = new PrintStream(new BufferedOutputStream(new FileOutputStream(file)))) {
            printStream.print(true);
            printStream.println();
            printStream.println("test");
            printStream.format("My test %d, %f", 1, 1.);

            printStream.append("\n");
            printStream.append("Appendable method test");

            boolean notCorrect = printStream.checkError();
            System.out.println("is printing correct: " + !notCorrect);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
