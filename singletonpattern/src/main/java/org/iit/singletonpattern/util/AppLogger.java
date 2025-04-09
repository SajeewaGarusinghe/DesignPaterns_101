package org.iit.singletonpattern.util;

import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class AppLogger {

    private static final String LOG_FILE_PATH = "application.log";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public AppLogger() {
        System.out.println("🔁 AppLogger Singleton created");
    }

    public void info(String message) {
        log("INFO", message);
    }

    public void error(String message) {
        log("ERROR", message);
    }

    private synchronized void log(String level, String message) {
        String timestamp = LocalDateTime.now().format(FORMATTER);
        String logLine = String.format("[%s] [%s] %s%n", timestamp, level, message);

        try (FileWriter writer = new FileWriter(LOG_FILE_PATH, true)) {
            writer.write(logLine);
        } catch (IOException e) {
            System.err.println("Logger failed: " + e.getMessage());
        }
    }
}