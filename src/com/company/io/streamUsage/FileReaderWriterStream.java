package com.company.io.streamUsage;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriterStream {

    public static void main(String[] args) {
        File sourse = new File("/Users/ivan/Documents/1Z0-809/files/fileReaderWriterfiles/zoo.txt");
        File dest = new File("/Users/ivan/Documents/1Z0-809/files/fileReaderWriterfiles/zooCopy.txt");

        try(FileReader reader = new FileReader(sourse);
            FileWriter writer = new FileWriter(dest)) {

            int ch;
            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
                writer.write(ch);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
