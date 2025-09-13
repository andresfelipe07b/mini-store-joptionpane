package org.example;

import javax.swing.*;

/**
 * Utility class with helper methods
 */
public class Utils {

    // Validate name input
    public static boolean isValidName(String input) {
        if (input == null || input.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Input cannot be empty.");
            return false;
        }
        return true;
    }
}
