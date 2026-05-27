package com.pluralsight.ui;

import com.pluralsight.entities.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserInterface {
    private Order order;

    public UserInterface() {
    }

    public void homeScreen(){
        int command;
        do{
            command = Console.promptForInt("""
                    1) New Order
                    0) Exit
                    -> """,0,1);
            switch (command){
                case 1:
                    newOrder();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid Input! Try Again!!");
            }
        }while(command!=0);
    }

    private void newOrder() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter idFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String orderId = "GBP-" + now.format(idFormatter);
        this.order = new Order(orderId,now);
        orderScreen();
    }

    private void orderScreen() {
        int command;
        do{
            this.order.displayItems();
            command = Console.promptForInt("""
                     1) Add Pizza
                     2) Add Drink
                     3) Add Garlic Knots
                     4) Checkout
                     5) Cancel Order
                    ->""",1,5);
            switch (command){
                case 1:
                    processAddPizza();
                    break;
                case 2:
                    processAddDrink();
                    break;
                case 3:
                    processAddGarlicKnots();
                    break;
                case 4:
                    processCheckOut();
                    command =0;
                    break;
                case 5:
                    cancelOrder();
                    command =0;
                    break;
                default:
                    System.out.println("Invalid Input! Try Again!!");
            }
        }while(command!=0);
    }

    private void processAddSide() {
        boolean wantParmesan = Console.promptForYesNo("Do you want Parmesan with your order? ");
        boolean wantRedPepper = Console.promptForYesNo("Do you want Red Pepper with your order? ");
        if (wantParmesan){
            this.order.addItem(new Side("Parmesan"));
        }
        if (wantRedPepper){
            this.order.addItem(new Side("Red Pepper"));
        }
    }


    private void processAddPizza() {
      String size = processPizzaSize();
      String crust = processPizzaCrust();
      boolean isStuffed = processPizzaIsStuffed();
      Pizza pizza = new Pizza(size,crust,isStuffed);
      processToppings(pizza);
        this.order.addItem(pizza);
        System.out.println("Awesome! Your custom pizza has been added to the order.");
    }

    private void processToppings(Pizza pizza) {
        int command;
        do {
            command = Console.promptForInt("""
                    --- Add Toppings ---
                    1) Add Meat
                    2) Add Cheese
                    3) Add Other Toppings (Regular)
                    4) Add Sauce
                    0) Done adding toppings
                    ->""", 0, 4);

            String category = "";
            String toppingName = null;

            switch (command) {
                case 1:
                    category = "Meat";
                    toppingName = processMeatSelection();
                    break;
                case 2:
                    category = "Cheese";
                    toppingName = processCheeseSelection();
                    break;
                case 3:
                    category = "Regular";
                    toppingName = processRegularSelection();
                    break;
                case 4:
                    category = "Sauce";
                   toppingName = processSauceSelection();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid Input! Try Again!!");
            }

            if (toppingName != null) {
                boolean isExtra = false;
                int extraCommand = Console.promptForInt("Do you want EXTRA " + toppingName + "? \n " +
                        "Press 1 for Yes\n Press 0 for No\n" +
                        "->", 0, 1);

                if (extraCommand == 1) {
                    isExtra = true;
                }

                pizza.addTopping(new Topping(toppingName, category, isExtra));
                System.out.println("\n>>> " + toppingName + " added to your pizza! <<<\n");
            }

        } while (command != 0);
    }

    private String processSauceSelection() {
        int command = Console.promptForInt("""
                --- Select Sauce ---
                1) Marinara
                2) Alfredo
                3) Pesto
                4) BBQ
                5) Buffalo
                6) Olive Oil
                ->""", 1, 6);

        return switch (command) {
            case 1 -> "Marinara";
            case 2 -> "Alfredo";
            case 3 -> "Pesto";
            case 4 -> "BBQ";
            case 5 -> "Buffalo";
            case 6 -> "Olive Oil";
            default -> null;
        };
    }

    private String processRegularSelection() {
        int command = Console.promptForInt("""
                --- Select Regular Topping ---
                1) Onions
                2) Mushrooms
                3) Bell Peppers
                4) Olives
                5) Tomatoes
                6) Spinach
                7) Basil
                8) Pineapple
                9) Anchovies
                ->""", 1, 9);

        return switch (command) {
            case 1 -> "Onions";
            case 2 -> "Mushrooms";
            case 3 -> "Bell Peppers";
            case 4 -> "Olives";
            case 5 -> "Tomatoes";
            case 6 -> "Spinach";
            case 7 -> "Basil";
            case 8 -> "Pineapple";
            case 9 -> "Anchovies";
            default -> null;
        };
    }

    private String processCheeseSelection() {
        int command = Console.promptForInt("""
                --- Select Cheese ---
                1) Mozzarella
                2) Parmesan
                3) Ricotta
                4) Goat Cheese
                5) Buffalo
                ->""", 1, 5);

        return switch (command) {
            case 1 -> "Mozzarella";
            case 2 -> "Parmesan";
            case 3 -> "Ricotta";
            case 4 -> "Goat Cheese";
            case 5 -> "Buffalo";
            default -> null;
        };
    }

    private String processMeatSelection() {
        int command = Console.promptForInt("""
                --- Select Meat ---
                1) Pepperoni
                2) Sausage
                3) Ham
                4) Bacon
                5) Chicken
                6) Meatball
                ->""", 1, 6);

        return switch (command) {
            case 1 -> "Pepperoni";
            case 2 -> "Sausage";
            case 3 -> "Ham";
            case 4 -> "Bacon";
            case 5 -> "Chicken";
            case 6 -> "Meatball";
            default -> null;
        };
    }


    private boolean processPizzaIsStuffed() {
        boolean isStuffed = Console.promptForYesNo("Would you like the your pizza with stuffed crust?");
        return isStuffed;
    }

    private String processPizzaCrust() {
        int command;
        String crust = null;
        System.out.println("Choose you crust!");
        command = Console.promptForInt("""
                1) thin
                2) regular
                3) thick
                4) cauliflower
                ->""",1,4);
        switch (command){
            case 1:
                crust = "Thin";
                break;
            case 2:
                crust = "Regular";
                break;
            case 3:
                crust = "Thick";
                break;
            case 4:
                crust = "Cauliflower";
                break;
            default:
                System.out.println("Invalid Input! Try Again!!");

        }
        return crust;
    }

    private String processPizzaSize() {
        String size=null;
        System.out.println("Choose the size!");
        int command = Console.promptForInt("""
                1) 8" Inch
                2) 12" Inch
                3) 16" Inch
                ->""",1,3);
        switch (command){
            case 1:
                size = "8 Inch";
                break;
            case 2:
                size = "12 Inch";
                break;
            case 3:
                size = "16 Inch";
                break;
            default:
                System.out.println("Invalid Input! Try Again!!");
        }
        return size;
    }

    private void processAddDrink() {
        String name = processDrinkName();
        String size = processDrinkSize();
        int quantity = Console.promptForInt("How many "+size+" "+name+" would you like: ",1,30);
        Drink drink = new Drink(name,size,quantity);
        this.order.addItem(drink);
    }


    private String processDrinkSize() {
        String size = null;
        int command = Console.promptForInt("""
                ---Choose the Size ---
                1) Small
                2) Medium
                3) Large
                -> """,1,3);
        switch (command){
            case 1:
                size="Small";
                break;
            case 2:
                size = "Medium";
                break;
            case 3:
                size="Large";
                break;
            default:
                System.out.println("Invalid Input! Try Again!!");
        }
        return size;
    }


    private String processDrinkName() {
        String name = null;
        int command = Console.promptForInt("""
                -----Drinks-----
                1) Coca Cola
                2) Sprite
                3) Fanta
                4) Dr. Pepper
                -> """,1,4);
        switch (command){
            case 1:
                name= "Coca Cola";
                break;
            case 2:
                name="Sprite";
                break;
            case 3:
                name = "Fanta";
                break;
            case 4:
                name = "Dr. Pepper";
            default:
                System.out.println("Invalid Input! Try Again!!");
        }
        return name;
    }

    private void processAddGarlicKnots() {
        int quantity = Console.promptForInt("How many garlic knots would you like: ",1,30);
        GarlicKnots knots = new GarlicKnots(quantity);
        this.order.addItem(knots);
    }

    private void processCheckOut() {
        processAddSide();
        System.out.println(this.order.generateReceiptText());
        int command;
        command = Console.promptForInt("Do you want to pay Cash or Card?\n press 1 for cash\n press 2 for card",1,2);
        switch (command){
            case 1:
                processCash();
                break;
            case 2:
                System.out.println("Follow the instruction on the PinPad!");
                System.out.println("Transaction Complete");
                break;
        }
        this.order = null;
        System.out.println("Checkout complete! Returning to main menu...\n");
    }

    private void processCash() {
        double total =this.order.calculateTotal();
        double amountPaid = 0.0;
        while (amountPaid < total) {
            double cash = Console.promptForDouble("Enter cash amount: ");
            amountPaid += cash;

            if (amountPaid < total) {
                System.out.printf("Still owe: $%.2f\n", (total - amountPaid));
            }
        }
        double change = amountPaid - total;
        System.out.printf("Cash Received! Change Due: $%.2f\n", change);
    }

    private void cancelOrder() {
        this.order = null;
        System.out.println("\nOrder has been cancelled. Returning to main menu...\n");
    }
}
