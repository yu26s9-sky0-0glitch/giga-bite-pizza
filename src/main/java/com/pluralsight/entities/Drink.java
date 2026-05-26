package com.pluralsight.entities;

public class Drink implements Orderable{
    private String name;
    private String size;
    private int quantity;
    private static final double SMALL_DRINK = 2.00;
    private static final double MEDIUM_DRINK = 2.50;
    private static final double LARGE_DRINK = 3.00;

    public Drink(String name, String size,int quantity) {
        this.name = name;
        this.size = size;
        this.quantity=quantity;

    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double calculatePrice() {
        return switch (size) {
            case "Small" -> quantity*SMALL_DRINK;
            case "Medium" -> quantity*MEDIUM_DRINK;
            case "Large" -> quantity*LARGE_DRINK;
            default -> 0;
        };
    }

    public String getDescription() {
        return quantity+ " " +size+" Drink: "+calculatePrice();
    }
}
