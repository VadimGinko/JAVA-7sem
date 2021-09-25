package by.file;

import java.io.FileWriter;
import java.io.IOException;

public class Log {
    public static void info(String message) {
        try (FileWriter writer = new FileWriter("logs/stdout/log.txt", true)) {
            writer
                    .append(message)
                    .append(String.valueOf('\n'));
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
