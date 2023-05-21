package Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ServiceAuditCSV {
    private static ServiceAuditCSV instance;

    private ServiceAuditCSV() {
    }

    public static ServiceAuditCSV getInstance() {
        if (instance == null)
            instance = new ServiceAuditCSV();

        return instance;
    }

    public void writeToFile(String action) {
        try {
            File file = new File("src\\Files\\Audit.csv");

            BufferedWriter writer = new BufferedWriter(new FileWriter("src\\Files\\Audit.csv", true));
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy / HH:mm:ss");
            String formatDateTime = now.format(formatter);

            writer.write(action + ", " + formatDateTime + "\n");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
