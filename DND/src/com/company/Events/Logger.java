package com.company.Events;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    public static void clearLogger() {
        try {
            new FileWriter("log.txt", false).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void log(String method) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Log.txt", true));

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            writer.write(method + ", " + dtf.format(now) +" Thread: "+Thread.currentThread().getName()+'\n');
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
