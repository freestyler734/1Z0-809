package com.company.io;

import java.io.File;
import java.time.Instant;
import java.time.ZoneId;

public class FileUsageExamples {

    public static void main(String[] args) {
        // Получение разделителя каталогов в окружении JVM
        System.out.println(System.getProperty("file.separator"));
        System.out.println(File.separator);
        System.out.println("-----");

        /// Класс java.io.File используется для описания свойств файла или каталога ///

        // В качестве конструктора можно передать либо относительный путь либо абсолютный
        File filesDirectory = new File("C:\\Users\\User\\Desktop\\личное\\1Z0-809\\1Z0-809\\files");
        System.out.println("fileDirectory.exists(): " + filesDirectory.exists());

        // Либо можно передать два параметра parent и child
        // где parent м.б. либо File, либо String
        // Если parent - null, то он пропускается
        File zooFile1 = new File("C:\\Users\\User\\Desktop\\личное\\1Z0-809\\1Z0-809\\files", "zoo.txt");
        File zooFile2 = new File(filesDirectory, "zoo.txt");
        System.out.println("zooFile1.exists(): " + zooFile1.exists());
        System.out.println("zooFile2.exists(): " + zooFile2.exists());
        System.out.println("-----");

        // Основные методы
        // exists() - проверяет существует ли файл/каталог по этому пути
        System.out.println("fileDirectory.exists():  " + filesDirectory.exists());
        System.out.println("-");
        // getName() - возвращает имя файла/каталога по заданному пути
        System.out.println("fileDirectory.getName(): " + filesDirectory.getName());
        System.out.println("zooFile1.getName():      " + zooFile1.getName());
        System.out.println("-");
        //getAbsolutePath() - возвращает абсолютный путь в виде String
        System.out.println("zooFile1.getAbsolutePath(): " + zooFile1.getAbsolutePath());
        System.out.println("-");
        // isDirectory() - true, если по указанному пути директория
        System.out.println("fileDirectory.isDirectory(): " + filesDirectory.isDirectory());
        System.out.println("zooFile1.isDirectory(): " + zooFile1.isDirectory());
        System.out.println("-");
        // isFile() - true, если по указанному пути файл
        System.out.println("fileDirectory.isFile(): " + filesDirectory.isFile());
        System.out.println("zooFile1.isFile(): " + zooFile1.isFile());
        System.out.println("-");
        // length() - long с кол-м байтов в файле/каталоге
        System.out.println("fileDirectory.length(): " + filesDirectory.length());
        System.out.println("zooFile1.length(): " + zooFile1.length());
        System.out.println("-");
        // lastModified() - long со временем последнего изменения в виде Epoch миллисек.
        System.out.println("Instant.ofEpochMilli(fileDirectory.lastModified()).atZone(ZoneId.of(\"Europe/Moscow\")): " + Instant.ofEpochMilli(filesDirectory.lastModified()).atZone(ZoneId.of("Europe/Moscow")));
        System.out.println("Instant.ofEpochMilli(zooFile1.lastModified()).atZone(ZoneId.of(\"Europe/Moscow\")): " + Instant.ofEpochMilli(zooFile1.lastModified()).atZone(ZoneId.of("Europe/Moscow")));
        System.out.println("-");
        // getParent() - возвращает строку с путем к родителю, либо null, если родитель в пути файла не указан
        System.out.println("filesDirectory.getParent(): " + filesDirectory.getParent());
        System.out.println("zooFile1.getParent(): " + zooFile1.getParent());
        System.out.println("-");
        // listFile() - возвращает массив File[] с файлами внутри КАТАЛОГА, либо null если указан не каталог
        System.out.println("filesDirectory.listFiles(): " + filesDirectory.listFiles());
        System.out.println("zooFile1.listFiles(): " + zooFile1.listFiles());
        System.out.println("-");
        // mkdir() - создает каталог по заданному пути.
        // true - если успешно, каталога по пути не существует, и существуют все указанные в пути родительскае каталоги
        // иначе false
        System.out.println("new File(filesDirectory, \"test\").mkdir(): " + new File(filesDirectory, "test").mkdir());
        System.out.println("new File(filesDirectory, \"test1/test2\").mkdir(): " + new File(filesDirectory, "test1/test2").mkdir());
        System.out.println("-");
        // mkdirs() - то же, что и mkdir(), но создает родителей указанных в пути, если их не существует
        System.out.println("new File(filesDirectory, \"test1/test2\").mkdirs(): " + new File(filesDirectory, "test1/test2").mkdirs());
        System.out.println("-");
        // delete() - удаляет файл/каталог по пути, но каталог для успешного удаления д.б. пустым
        System.out.println("new File(filesDirectory, \"test\").delete(): " + new File(filesDirectory, "test").delete());
        System.out.println("new File(filesDirectory, \"test1\").delete(): " + new File(filesDirectory, "test1").delete());
        System.out.println("-");
        // renameTo(File) - переменовать файл по заданному в параметре пути
        File newZoo = new File(filesDirectory, "zoo1.txt");
        System.out.println("zooFile1.renameTo(newZoo)): " +  zooFile1.renameTo(newZoo));

        // переименуем обратно
        System.out.println("newZoo.renameTo(new File(filesDirectory, \"zoo.txt\")): " + newZoo.renameTo(new File(filesDirectory, "zoo.txt")));
    }
}
