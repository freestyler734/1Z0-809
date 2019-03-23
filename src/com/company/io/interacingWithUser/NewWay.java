package com.company.io.interacingWithUser;

import java.io.Console;
import java.io.Reader;
import java.io.Serializable;

public class NewWay {

    public static void main(String[] args) {
        Console console = System.console();

        if (console != null) {
            String line = null;
            while (!(line = console.readLine()).equals("")) {
                console.writer().println("You entered: " + line);
            }
        }

    }
}
