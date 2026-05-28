package com.pluralsight.entities;

import com.pluralsight.ui.ColorUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderId;
    private LocalDateTime timeStamp;
    private List<Orderable> items;

    public Order(String orderId, LocalDateTime timeStamp) {
        this.orderId = orderId;
        this.timeStamp = timeStamp;
        this.items = new ArrayList<>();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
    public void addItem(Orderable item){
        items.add(item);
    }
    public void displayItems() {
        System.out.println(ColorUtils.YELLOW_BOLD + "\n--- Current Cart ---" + ColorUtils.RESET);
        if (items.isEmpty()) {
            System.out.println(ColorUtils.YELLOW + "Your cart is currently empty." + ColorUtils.RESET);
        } else {
            for (Orderable o : items) {
                System.out.println(ColorUtils.YELLOW + o.getDescription() + ColorUtils.RESET);
            }
        }
        System.out.println();
    }
    public double calculateTotal(){
        double total =0;
        for(Orderable item: items){
            total+=item.calculatePrice();
        }
        return total;
    }
    public String generateReceiptText() {
        StringBuilder receipt = new StringBuilder();
        DateTimeFormatter printFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");

        receipt.append("=========================================\n");
        receipt.append("             GIGA-BITE PIZZA             \n");
        receipt.append("=========================================\n");
        receipt.append("Order ID: ").append(this.orderId).append("\n");
        receipt.append("Date: ").append(this.timeStamp.format(printFormat)).append("\n");
        receipt.append("-----------------------------------------\n");

        for (Orderable item : items) {
            receipt.append(item.getDescription()).append("\n");
        }

        receipt.append("-----------------------------------------\n");
        receipt.append(String.format("%-30s $%6.2f\n", "Order Total:", calculateTotal()));
        receipt.append("=========================================\n");

        return receipt.toString();
    }
}
