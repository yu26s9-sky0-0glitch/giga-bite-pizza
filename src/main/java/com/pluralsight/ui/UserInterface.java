package com.pluralsight.ui;

import com.pluralsight.entities.Order;
import com.pluralsight.entities.Pizza;
import com.pluralsight.entities.Topping;

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
                    0) Exit""",0,1);
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
            command = Console.promptForInt("""
                     1) Add Pizza
                     2) Add Drink
                     3) Add Garlic Knots
                     4) Checkout
                     0) Cancel Order
                    ->""",0,4);
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
                case 0:
                    break;
                default:
                    System.out.println("Invalid Input! Try Again!!");
            }
        }while(command!=0);
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

            if (command == 0) {
                break;
            }

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
            }

            if (toppingName != null) {
                boolean isExtra = false;
                int extraCommand = Console.promptForInt("Do you want EXTRA " + toppingName + "? (1 for Yes, 0 for No): ", 0, 1);

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
        int command;
        boolean isStuffed = false;
        command = Console.promptForInt("Would you like the pizza with stuffed crust? (press 1 for Yes, press 0 for No: ",0,1);
        switch (command){
            case 1:
                isStuffed = true;
                break;
            case 2:
                isStuffed = false;
        }
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
                size = "8";
                break;
            case 2:
                size = "12";
                break;
            case 3:
                size = "16";
                break;
            default:
                System.out.println("Invalid Input! Try Again!!");
        }
        return size;
    }

    private void processAddDrink() {
    }

    private void processAddGarlicKnots() {
    }

    private void processCheckOut() {
    }
}
