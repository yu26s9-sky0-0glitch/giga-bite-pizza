package com.pluralsight.ui;

public class Graphics {

    public static void displayOrderUp() {
        System.out.println("""
        %s        (   )  (   )   )
                 )   )    (   (
        %s       _________________
              /                 \\
             / %s GIGA-BITE PIZZA %s \\
            /_____________________\\
            | %s  HOT AND FRESH   %s |
            \\_____________________/%s
        
        %s   🔔 DING! Order sent to the kitchen! 🔔%s
        """.formatted(
                ColorUtils.WHITE,
                ColorUtils.RED,
                ColorUtils.YELLOW_BOLD, ColorUtils.RED,
                ColorUtils.WHITE_BOLD, ColorUtils.RED,
                ColorUtils.RESET,
                ColorUtils.GREEN_BOLD, ColorUtils.RESET
        ));
    }

    public static void displayLogo() {
        System.out.println(ColorUtils.YELLOW + """
              ____ ___ _____    _          ____ ___ _____ _____ 
             / ___|_ _| ____|  / \\        | __ )_ _|_   _| ____|
            | |  _ | ||  _|   / _ \\ _____ |  _ \\| |  | | |  _|  
            | |_| || || |___ / ___ \\_____|| |_) | |  | | | |___ 
             \\____|___|_____/_/   \\_\\     |____/___| |_| |_____|
                                                                """ + ColorUtils.RESET);

        System.out.println(ColorUtils.RED_BOLD + "          🍕 Welcome to GIGA-Bite Pizza! 🍕\n" + ColorUtils.RESET);
    }

    public static void displayGoodbye() {
        System.out.println(ColorUtils.YELLOW_BOLD + """
              ____               _  _                 _ 
             / ___|  ___   ___  | || |__   _   _  ___| |
            | |  _  / _ \\ / _ \\ | || '_ \\ | | | |/ _ \\ |
            | |_| || (_) | (_) || || |_) || |_| |  __/_|
             \\____| \\___/ \\___/ |_||_.__/  \\__, |\\___(_)
                                           |___/        """ + ColorUtils.RESET);

        System.out.println("""
        %s             _______________ 
                    |  %sGIGA-BITE%s    |__ 
               _    |    %sPIZZA%s      |  \\\\__ 
              ( )   |_______________|_____| 
                      (O)             (O)   %s
        """.formatted(
                ColorUtils.CYAN_BOLD,
                ColorUtils.YELLOW_BOLD, ColorUtils.CYAN_BOLD,
                ColorUtils.YELLOW_BOLD, ColorUtils.CYAN_BOLD,
                ColorUtils.RESET
        ));

        System.out.println(ColorUtils.GREEN_BOLD + "\n Thanks for stopping by! See you next time!\n" + ColorUtils.RESET);
    }

    public static void displayOrderCancelled() {
        System.out.println(ColorUtils.RED_BOLD + """
               _______ 
              /       \\ 
             |  R.I.P. |
             |         |
             |  X   X  |
             |    _    |
             |___/ \\___|
           \\/\\/\\/\\/\\/\\/\\/\\""" + ColorUtils.RESET);

        System.out.println(ColorUtils.RED_BOLD + "\n  [ ORDER TRASHED AND CANCELLED ]" + ColorUtils.RESET);
        System.out.println(ColorUtils.YELLOW + "      Returning to main menu...\n" + ColorUtils.RESET);
    }
}