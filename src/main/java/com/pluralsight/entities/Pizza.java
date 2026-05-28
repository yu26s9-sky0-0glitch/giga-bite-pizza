package com.pluralsight.entities;

import java.util.ArrayList;
import java.util.List;

public class Pizza implements Orderable{
    private String size;
    private String crust;
    private boolean isStuffed;
    private List<Topping> toppings;
    private static final double EIGHT_INCH_PRICE = 8.50;
    private static final double TWELVE_INCH_PRICE = 12.00;
    private static final double SIXTEEN_INCH_PRICE =16.50;


    public Pizza(String size, String crust, boolean isStuffed) {
        this.size = size;
        this.crust = crust;
        this.isStuffed = isStuffed;
        this.toppings = new ArrayList<>();
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCrust() {
        return crust;
    }

    public void setCrust(String crust) {
        this.crust = crust;
    }

    public boolean isStuffed() {
        return isStuffed;
    }

    public void setStuffed(boolean stuffed) {
        isStuffed = stuffed;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }
    public void addTopping(Topping t){
        toppings.add(t);
    }

    private double calculateBasePrice(){
        double basePrice = 0.00;
        switch (size){
            case "8 Inch":
                basePrice = EIGHT_INCH_PRICE;
                break;
            case "12 Inch":
                basePrice = TWELVE_INCH_PRICE;
                break;
            case "16 Inch":
                basePrice = SIXTEEN_INCH_PRICE;
                break;
        }
        return basePrice;
    }

    @Override
    public double calculatePrice() {
        double total = calculateBasePrice();

        for (Topping topping : this.toppings) {
            total += topping.calculatePrice();
        }
        return total;
    }

    @Override
    public String getDescription() {
        StringBuilder builder = new StringBuilder();

        builder.append(String.format("%-30s $%6.2f", size + " " + crust + " MYO Pizza", calculateBasePrice()));

        for (Topping topping : this.toppings) {

            builder.append("\n   -> ").append(topping.getDescription());
        }

        return builder.toString();
    }
}
