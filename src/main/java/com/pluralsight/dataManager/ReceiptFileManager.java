package com.pluralsight.dataManager;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptFileManager {

    public static void saveReceipt(String receiptText, LocalDateTime timestamp) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
        String fileName = "data/receipts/" + timestamp.format(formatter) + ".txt";
        File directory = new File("data/receipts");
        if (!directory.exists()) {
            directory.mkdirs();
        }
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(receiptText);
        } catch (IOException e) {
            System.out.println("\n[SYSTEM ERROR] Could not save the receipt file to the hard drive.");
            System.out.println("Reason: " + e.getMessage());
        }
    }
}