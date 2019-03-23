package com.company.io.interacingWithUser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OldWay {

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = null;
        try {
            while (!(line = reader.readLine()).equals("")) {
                System.out.println("You entered: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
