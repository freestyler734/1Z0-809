package com.company.io.streamUsage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class BufferedReaderWriterStream {


    public static void main(String[] args) {
        List<String> lines = new ArrayList<>();

        File source = new File("C:\\Users\\User\\Desktop\\личное\\1Z0-809\\1Z0-809\\files\\fileBufferedReaderWriterfiles\\zoo.txt");
        File dest = new File("C:\\Users\\User\\Desktop\\личное\\1Z0-809\\1Z0-809\\files\\fileBufferedReaderWriterfiles\\zooCopy.txt");
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(source));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(dest))) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                lines.add(line);
            }

            for (String l: lines) {
                bufferedWriter.write(l);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
