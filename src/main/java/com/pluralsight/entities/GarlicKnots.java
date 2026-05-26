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

    public double calculatePrice() {
        return price*quantity;
    }


    public String getDescription() {
        return quantity +" Garlic Knots: "+ price;
    }
}
