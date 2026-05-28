package com.pluralsight.entities;

public class Topping{
    private String name;
    private String category;
    private boolean isExtra;
    private String size;
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

    public Topping(String name, String category, boolean isExtra,String size) {
        this.name = name;
        this.category = category;
        this.isExtra = isExtra;
        this.size=size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isExtra() {
        return isExtra;
    }

    public void setExtra(boolean extra) {
        isExtra = extra;
    }


    public double calculatePrice() {

            if (this.category.equalsIgnoreCase("Regular") ||
                    this.category.equalsIgnoreCase("Sauce")) {
                return 0.00;
            }


            if (this.category.equalsIgnoreCase("Meat")) {
                return switch (this.size) {
                    case "8 Inch" -> MEAT_8_BASE_PRICE + (isExtra() ? MEAT_8_EXTRA_PRICE : 0);
                    case "12 Inch" -> MEAT_12_BASE_PRICE + (isExtra() ? MEAT_12_EXTRA_PRICE : 0);
                    case "16 Inch" -> MEAT_16_BASE_PRICE + (isExtra() ? MEAT_16_EXTRA_PRICE : 0);
                    default -> 0.00;
                };
            }

            if (this.category.equalsIgnoreCase("Cheese")) {
                return switch (this.size) {
                    case "8 Inch" -> CHEESE_8_BASE_PRICE + (isExtra() ? CHEESE_8_EXTRA_PRICE : 0);
                    case "12 Inch" -> CHEESE_12_BASE_PRICE + (isExtra() ? CHEESE_12_EXTRA_PRICE : 0);
                    case "16 Inch" -> CHEESE_16_BASE_PRICE + (isExtra() ? CHEESE_16_EXTRA_PRICE : 0);
                    default -> 0.00;
                };
            }

            return 0.00;


    }

    public String getDescription() {
        if(isExtra){
        return String.format("%-24s %6.2f", "Extra "+this.name,calculatePrice());}
        else{
            return String.format("%-24s $%6.2f", this.name,calculatePrice());}
        }
    }
