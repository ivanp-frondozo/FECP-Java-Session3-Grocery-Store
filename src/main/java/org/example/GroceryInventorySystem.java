package org.example;

import java.util.Scanner;

public class GroceryInventorySystem {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("---Grocery Store Inventory---");
            System.out.println("1. Add Product");
            System.out.println("2. Check Product");
            System.out.println("3. Update Product");
            System.out.println("4. Remove Product");
            System.out.println("5. View Inventory");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    manager.addProduct(name, quantity);
                }
                case 2 -> {
                    System.out.print("Enter product name to check: ");
                    String name = scanner.nextLine();
                    boolean exists = manager.checkProduct(name);
                }
                case 3 -> {
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter quantity change (+ restock, - sold): ");
                    int change = scanner.nextInt();
                    manager.updateProduct(name, change);
                }
                case 4 -> {
                    System.out.print("Enter product name to remove: ");
                    String name = scanner.nextLine();
                    manager.removeProduct(name);
                }
                case 5 -> manager.viewInventory();
                case 6 -> {
                    running = false;
                    System.out.println("Exiting program...");
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}

