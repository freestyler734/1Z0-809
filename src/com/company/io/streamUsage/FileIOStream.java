package com.company.io.streamUsage;

import java.io.*;

public class FileIOStream {

    /*
        Пример использования классов FileInputStream и FileOutputStream для
        копирования файла
     */
    public static void main(String[] args) {
        File source = new File("/Users/ivan/Documents/1Z0-809/files/fileIOfiles/zoo.txt");
        File dest = new File("/Users/ivan/Documents/1Z0-809/files/fileIOfiles/zooCopy.txt");

        try(FileInputStream inputStream = new FileInputStream(source);
            FileOutputStream outputStream = new FileOutputStream(dest, true)) {

            int b;
            while ((b = inputStream.read()) != -1) {
                outputStream.write(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
