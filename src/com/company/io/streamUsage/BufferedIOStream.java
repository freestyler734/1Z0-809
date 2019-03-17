package com.company.io.streamUsage;

import java.io.*;

public class BufferedIOStream {

    /*
        Пример использования Buffered стримов для чтения записи файлов
        Приводится копирование файлов
     */

    public static void main(String[] args) {
        File source = new File("/Users/ivan/Documents/1Z0-809/files/fileBufferedIOfiles/zoo.txt");
        File dest = new File("/Users/ivan/Documents/1Z0-809/files/fileBufferedIOfiles/zooCopy.txt");

        try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(source));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(dest, false))) {

            int readLen;
            byte[] b = new byte[1024];

            while ((readLen = bufferedInputStream.read(b, 0 , b.length)) > 0) {
                bufferedOutputStream.write(b, 0, readLen);
                bufferedOutputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
