package com.company.io.streamUsage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOStreamReaderWriter {

    public static void main(String[] args) {
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(""))) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
