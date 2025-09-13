package org.example;

import javax.swing.*;

/**
 * Main class: controls the menu and connects to Inventory
 */
public class MiniStore {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        boolean running = true;

        while (running) {
            String option = JOptionPane.showInputDialog(
                    null,
                    "=== Mini-Store Menu ===\n" +
                            "1. Add product\n" +
                            "2. List inventory\n" +
                            "3. Buy product\n" +
                            "4. Show statistics\n" +
                            "5. Search product\n" +
                            "6. Exit\n\n" +
                            "Choose an option:",
                    "Mini-Store", JOptionPane.QUESTION_MESSAGE
            );

            if (option == null) break;

            switch (option) {
                case "1": inventory.addProduct(); break;
                case "2": inventory.listInventory(); break;
                case "3": inventory.buyProduct(); break;
                case "4": inventory.showStatistics(); break;
                case "5": inventory.searchProduct(); break;
                case "6": inventory.exitProgram(); running = false; break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please choose 1-6.");
            }
        }
    }
}
