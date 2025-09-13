package org.example;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Inventory management: products, stock, and statistics
 */
public class Inventory {
    private ArrayList<Product> products = new ArrayList<>();
    private HashMap<String, Integer> productIndex = new HashMap<>();
    private double totalSales = 0.0;

    // --- Add product ---
    public void addProduct() {
        String name = JOptionPane.showInputDialog("Enter product name:");
        if (!Utils.isValidName(name)) return;

        if (productIndex.containsKey(name)) {
            JOptionPane.showMessageDialog(null, "Product already exists.");
            return;
        }

        try {
            double price = Double.parseDouble(JOptionPane.showInputDialog("Enter product price:"));
            if (price <= 0) {
                JOptionPane.showMessageDialog(null, "Price must be greater than 0.");
                return;
            }

            int stock = Integer.parseInt(JOptionPane.showInputDialog("Enter stock quantity:"));
            if (stock < 0) {
                JOptionPane.showMessageDialog(null, "Stock cannot be negative.");
                return;
            }

            Product p = new Product(name, price, stock);
            products.add(p);
            productIndex.put(name, products.size() - 1);

            JOptionPane.showMessageDialog(null, "Product added successfully!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid number format.");
        }
    }

    // --- List inventory ---
    public void listInventory() {
        if (products.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Inventory is empty.");
            return;
        }

        StringBuilder sb = new StringBuilder("=== Inventory ===\n");
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            sb.append(String.format("%d. %s - $%.2f - Stock: %d\n",
                    (i + 1), p.getName(), p.getPrice(), p.getStock()));
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    // --- Buy product ---
    public void buyProduct() {
        if (products.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No products available.");
            return;
        }

        String name = JOptionPane.showInputDialog("Enter product name to buy:");
        if (!Utils.isValidName(name)) return;

        if (!productIndex.containsKey(name)) {
            JOptionPane.showMessageDialog(null, "Product not found.");
            return;
        }

        int index = productIndex.get(name);
        Product p = products.get(index);

        try {
            int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter quantity to buy:"));
            if (qty <= 0) {
                JOptionPane.showMessageDialog(null, "Quantity must be greater than 0.");
                return;
            }

            if (qty > p.getStock()) {
                JOptionPane.showMessageDialog(null, "Not enough stock available.");
                return;
            }

            p.setStock(p.getStock() - qty);
            double total = qty * p.getPrice();
            totalSales += total;

            JOptionPane.showMessageDialog(null,
                    "Purchase successful!\nTotal: $" + String.format("%.2f", total));

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid quantity format.");
        }
    }

    // --- Show statistics ---
    public void showStatistics() {
        if (products.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No products available.");
            return;
        }

        Product min = products.get(0);
        Product max = products.get(0);

        for (Product p : products) {
            if (p.getPrice() < min.getPrice()) min = p;
            if (p.getPrice() > max.getPrice()) max = p;
        }

        String msg = String.format(
                "Cheapest: %s ($%.2f)\nMost expensive: %s ($%.2f)",
                min.getName(), min.getPrice(), max.getName(), max.getPrice()
        );
        JOptionPane.showMessageDialog(null, msg);
    }

    // --- Search product ---
    public void searchProduct() {
        if (products.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No products to search.");
            return;
        }

        String query = JOptionPane.showInputDialog("Enter product name (partial allowed):");
        if (!Utils.isValidName(query)) return;

        StringBuilder sb = new StringBuilder("Search results:\n");
        boolean found = false;

        for (Product p : products) {
            if (p.getName().toLowerCase().contains(query.toLowerCase())) {
                sb.append(String.format("%s - $%.2f - Stock: %d\n",
                        p.getName(), p.getPrice(), p.getStock()));
                found = true;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(null, "No products found.");
        } else {
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }

    // --- Exit with ticket ---
    public void exitProgram() {
        JOptionPane.showMessageDialog(null,
                "Final ticket:\nTotal purchases: $" +
                        String.format("%.2f", totalSales) + "\nThanks for using Mini-Store!");
    }
}
