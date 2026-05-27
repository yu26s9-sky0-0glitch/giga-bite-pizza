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
    private static final double MEAT_8_BASE_PRICE = 1.00;
    private static final double MEAT_8_EXTRA_PRICE = 0.50;
    private static final double MEAT_12_BASE_PRICE = 2.00;
    private static final double MEAT_12_EXTRA_PRICE = 1.00;
    private static final double MEAT_16_BASE_PRICE = 3.00;
    private static final double MEAT_16_EXTRA_PRICE = 1.50;
    private static final double CHEESE_8_BASE_PRICE = 0.75;
    private static final double CHEESE_8_EXTRA_PRICE = 0.30;
    private static final double CHEESE_12_BASE_PRICE = 1.50;
    private static final double CHEESE_12_EXTRA_PRICE = 0.60;
    private static final double CHEESE_16_BASE_PRICE = 2.25;
    private static final double CHEESE_16_EXTRA_PRICE = 0.90;

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
    private double calculateToppingPrice(Topping topping) {

        if (topping.getCategory().equalsIgnoreCase("Regular") ||
                topping.getCategory().equalsIgnoreCase("Sauce")) {
            return 0.00;
        }


        if (topping.getCategory().equalsIgnoreCase("Meat")) {
            return switch (this.size) {
                case "8" -> MEAT_8_BASE_PRICE + (topping.isExtra() ? MEAT_8_EXTRA_PRICE : 0);
                case "12" -> MEAT_12_BASE_PRICE + (topping.isExtra() ? MEAT_12_EXTRA_PRICE : 0);
                case "16" -> MEAT_16_BASE_PRICE + (topping.isExtra() ? MEAT_16_EXTRA_PRICE : 0);
                default -> 0.00;
            };
        }

        if (topping.getCategory().equalsIgnoreCase("Cheese")) {
            return switch (this.size) {
                case "8" -> CHEESE_8_BASE_PRICE + (topping.isExtra() ? CHEESE_8_EXTRA_PRICE : 0);
                case "12" -> CHEESE_12_BASE_PRICE + (topping.isExtra() ? CHEESE_12_EXTRA_PRICE : 0);
                case "16" -> CHEESE_16_BASE_PRICE + (topping.isExtra() ? CHEESE_16_EXTRA_PRICE : 0);
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
                total+= EIGHT_INCH_PRICE;
            case "12 Inch":
                total+= TWELVE_INCH_PRICE;
            case "16 Inch":
                total+= SIXTEEN_INCH_PRICE;
        }
        for (Topping topping : this.toppings) {
            total += calculateToppingPrice(topping);
        }
        return total;
    }

    @Override
    public String getDescription() {
        return size + " Inch " +crust+" MYO Pizza: "+calculatePrice();
    }
}
