package com.pluralsight.ui;

public class Graphics {
    public static void displayOrderUp() {
        System.out.println(ColorUtils.WHITE);
        System.out.println("        (   )  (   )   )");
        System.out.println("         )   )    (   (");
        System.out.println(ColorUtils.RED);
        System.out.println("       _________________");
        System.out.println("      /                 \\");
        System.out.println("     / " + ColorUtils.YELLOW_BOLD + " GIGA-BITE PIZZA " + ColorUtils.RED + " \\");
        System.out.println("    /_____________________\\");
        System.out.println("    | " + ColorUtils.WHITE_BOLD + "  HOT AND FRESH   " + ColorUtils.RED + " |");
        System.out.println("    \\_____________________/" + ColorUtils.RESET);
        System.out.println();
        System.out.println(ColorUtils.GREEN_BOLD + "   🔔 DING! Order sent to the kitchen! 🔔" + ColorUtils.RESET);
        System.out.println();
    }
    public static void displayLogo() {
        System.out.println(ColorUtils.YELLOW);
        System.out.println("  ____ ___ _____    _          ____ ___ _____ _____ ");
        System.out.println(" / ___|_ _| ____|  / \\        | __ )_ _|_   _| ____|");
        System.out.println("| |  _ | ||  _|   / _ \\ _____ |  _ \\| |  | | |  _|  ");
        System.out.println("| |_| || || |___ / ___ \\_____|| |_) | |  | | | |___ ");
        System.out.println(" \\____|___|_____/_/   \\_\\     |____/___| |_| |_____|");
        System.out.println("                                                    ");
        System.out.println(ColorUtils.RED_BOLD + "          🍕 Welcome to GIGA-Bite Pizza! 🍕" + ColorUtils.RESET);
        System.out.println();
    }
    public static void displayGoodbye() {
        System.out.println(ColorUtils.YELLOW_BOLD);
        System.out.println("  ____               _  _                 _ ");
        System.out.println(" / ___|  ___   ___  | || |__   _   _  ___| |");
        System.out.println("| |  _  / _ \\ / _ \\ | || '_ \\ | | | |/ _ \\ |");
        System.out.println("| |_| || (_) | (_) || || |_) || |_| |  __/_|");
        System.out.println(" \\____| \\___/ \\___/ |_||_.__/  \\__, |\\___(_)");
        System.out.println("                               |___/        ");
        System.out.println(ColorUtils.RESET);

        System.out.println(ColorUtils.CYAN_BOLD + "             _______________ ");
        System.out.println("            |  " + ColorUtils.YELLOW_BOLD + "GIGA-BITE" + ColorUtils.CYAN_BOLD + "    |__ ");
        System.out.println("       _    |    " + ColorUtils.YELLOW_BOLD + "PIZZA" + ColorUtils.CYAN_BOLD + "      |  \\\\__ ");
        System.out.println("      ( )   |_______________|_____| ");
        System.out.println("              (O)             (O)   " + ColorUtils.RESET);

        System.out.println(ColorUtils.GREEN_BOLD + "\n Thanks for stopping by! See you next time!\n" + ColorUtils.RESET);
    }
}
