package com.pluralsight.entities;

public class Side implements Orderable {
    private String name;

    public Side(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public double calculatePrice() {
        return 0.00;
    }

    @Override
    public String getDescription() {
        return String.format("%s %30s","Side: " + name, " (Included)");
    }
}