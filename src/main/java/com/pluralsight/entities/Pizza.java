package com.pluralsight.entities;

import java.util.ArrayList;
import java.util.List;

public class Pizza implements Orderable{
    private String size;
    private String crust;
    private boolean isStuffed;
    private List<Topping> toppings;
    private static final double EIGHT_INCH = 8.50;
    private static final double TWELVE_INCH = 12.00;
    private static final double SIXTEEN_INCH =16.50;
    private static final double MEAT_8_BASE = 1.00;
    private static final double MEAT_8_EXTRA = 0.50;
    private static final double MEAT_12_BASE = 2.00;
    private static final double MEAT_12_EXTRA = 1.00;
    private static final double MEAT_16_BASE = 3.00;
    private static final double MEAT_16_EXTRA = 1.50;
    private static final double CHEESE_8_BASE = 0.75;
    private static final double CHEESE_8_EXTRA = 0.30;
    private static final double CHEESE_12_BASE = 1.50;
    private static final double CHEESE_12_EXTRA = 0.60;
    private static final double CHEESE_16_BASE = 2.25;
    private static final double CHEESE_16_EXTRA = 0.90;

    public Pizza(String size, String crust, boolean isStuffed, List<Topping> toppings) {
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
    private void addTopping(Topping t){
        toppings.add(t);
    }
    private double calculateToppingPrice(Topping topping) {

        if (topping.getCategory().equalsIgnoreCase("Regular") ||
                topping.getCategory().equalsIgnoreCase("Sauce")) {
            return 0.00;
        }


        if (topping.getCategory().equalsIgnoreCase("Meat")) {
            return switch (this.size) {
                case "8" -> MEAT_8_BASE + (topping.isExtra() ? MEAT_8_EXTRA : 0);
                case "12" -> MEAT_12_BASE + (topping.isExtra() ? MEAT_12_EXTRA : 0);
                case "16" -> MEAT_16_BASE + (topping.isExtra() ? MEAT_16_EXTRA : 0);
                default -> 0.00;
            };
        }

        if (topping.getCategory().equalsIgnoreCase("Cheese")) {
            return switch (this.size) {
                case "8" -> CHEESE_8_BASE + (topping.isExtra() ? CHEESE_8_EXTRA : 0);
                case "12" -> CHEESE_12_BASE + (topping.isExtra() ? CHEESE_12_EXTRA : 0);
                case "16" -> CHEESE_16_BASE + (topping.isExtra() ? CHEESE_16_EXTRA : 0);
                default -> 0.00;
            };
        }

        return 0.00;
    }

    @Override
    public double calculatePrice() {
        double total = 0.00;
        switch (size){
            case "8 Inch":
                total+= EIGHT_INCH;
            case "12 Inch":
                total+= TWELVE_INCH;
            case "16 Inch":
                total+= SIXTEEN_INCH;
        }
        for (Topping topping : this.toppings) {
            total += calculateToppingPrice(topping);
        }
        return total;
    }

    @Override
    public String getDescription() {
        return size +" Inch MYO Pizza: "+calculatePrice();
    }
}
