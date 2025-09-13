# Mini-Store with JOptionPane (Arrays + ArrayList + HashMap)

## 📌 Feature Name
**Mini-Store with JOptionPane (Arrays + ArrayList + HashMap)**

---

## 🎯 Objective
This project implements a **mini-application in Java** that allows managing a product inventory with simple GUI dialogs using `JOptionPane`.  

The system integrates different **data structures**:
- **ArrayList** → stores product names.
- **Array (double[])** → stores product prices synchronized with names.
- **HashMap** → manages stock per product.

The program provides the following options:
1. Add product.  
2. List inventory.  
3. Buy product.  
4. Show statistics (cheapest & most expensive).  
5. Search product by name (partial matches allowed).  
6. Exit with a final purchase ticket.

This user story provides value by combining **basic data structures** with **simple GUI interaction**, reinforcing programming logic and improving the user experience.

---

## ✅ Acceptance Criteria
- The program compiles and runs without errors.  
- All menu options work correctly using only `JOptionPane`.  
- `Array`, `ArrayList`, and `HashMap` are used in an integrated and coherent way.  
- Input validation is applied (non-empty values, valid numbers, sufficient stock).  
- A final ticket is displayed when exiting, showing total accumulated purchases.  
- Delivery: Java source files with explanatory comments in English.

---

## 🛠️ Technologies and Tools
- **Java 17+**  
- **Swing (JOptionPane)** → for graphical user dialogs.  
- **Maven** → project build management.  
- **IntelliJ IDEA** → IDE for development.  

---

## 📂 Project Structure
```
src/main/java/org/example/
│
├── MiniStoreApp.java   // Main class with menu loop
├── Inventory.java      // Business logic: add, list, buy, stats, search, exit
├── Product.java        // Data model (encapsulation of name, price, stock)
└── Utils.java          // Helper methods for validations and formatting
```

---

## 🧩 Best Practices Applied
- **Modularization** → separated into multiple classes (`Product`, `Inventory`, `Utils`, `MiniStoreApp`) to respect **Single Responsibility Principle**.  
- **Encapsulation** → private attributes in `Product` with getters and setters.  
- **Validation** → prevents empty inputs, invalid numbers, negative stock, and duplicate products.  
- **User feedback** → clear messages with `showMessageDialog` for errors, confirmations, and results.  
- **Formatted output** → prices shown with `String.format` for readability.  
- **Maintainability** → reusable helper methods and comments in English for clarity.  

---

## ▶️ How to Run
1. Clone or download this repository.  
2. Open the project in **IntelliJ IDEA** (with Maven support).  
3. Ensure you are using **Java 17+**.  
4. Run the class:  
 ```bash
   MiniStore.java
 ```

The program will display a graphical menu using JOptionPane.

## 📊 Example Flow

- **Add a new product** → "Laptop", price $1500, stock 5  
- **List inventory** → shows "Laptop - $1500.00 - Stock: 5"  
- **Buy** → "Laptop", qty 2. Updates stock and adds to total sales  
- **Show statistics** → shows cheapest and most expensive products  
- **Search** → enter "Lap", finds "Laptop"  
- **Exit** → displays final ticket with total purchases  
