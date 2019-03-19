package com.company.io.streamUsage;

import com.company.io.streamUsage.serialization.Tiger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectIOStream {

    public static void main(String[] args) {
        List<String> childs = new ArrayList<>();
        childs.add("T1");
        childs.add("T2");

        Tiger tiger = new Tiger("Tiger", 22, "black", 70, childs);
        System.out.println(tiger);

        // Сериализация объекта tiger
        File tigersFile = new File(/*"C:\\Users\\User\\Desktop\\личное\\1Z0-809\\1Z0-809\\files\\objectIOFiles\\Tigers"*/
        "/Users/ivan/Documents/1Z0-809/files/objectIOFiles/Tigers");
        try(ObjectOutputStream stream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(tigersFile)))) {
            stream.writeObject(tiger);
            stream.flush();
        } catch (IOException e) {
            e.printStackTrace();Reader
        }

        // Десериализация объекта
        try(ObjectInputStream stream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(tigersFile)))) {
            Object o = stream.readObject();
            if (o.getClass() == Tiger.class) {
                Tiger copiedTiger = (Tiger) o;
                System.out.println(copiedTiger);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
