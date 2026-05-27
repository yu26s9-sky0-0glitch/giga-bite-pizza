package com.pluralsight.entities;

public class GarlicKnots implements Orderable{
    private int quantity;
    private static final double price = 1.50;

    public GarlicKnots(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }
    @Override
    public double calculatePrice() {
        return price*quantity;
    }

    @Override
    public String getDescription() {
        return String.format("%s %30.2f",quantity +" Garlic Knots: ", calculatePrice());
    }
}
