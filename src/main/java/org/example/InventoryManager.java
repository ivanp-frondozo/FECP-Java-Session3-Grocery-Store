package org.example;

import java.util.*;

public class InventoryManager {
    private Map<String, Integer> groceryInventory;

    public InventoryManager() {
        groceryInventory = new HashMap<>();
    }

    public void addProduct(String name, int quantity) {
        if ( quantity == 0){
            System.out.println("Please enter a positive number.");
        }
        else {
            groceryInventory.put(name.toLowerCase(), quantity);
            System.out.println("Added: " + name + " - Quantity: " + quantity);
        }
    }

    public int getQuantity(String name) { //currently only used for testing addProduct method quantity
        return groceryInventory.getOrDefault(name.toLowerCase(), -1);
    }


    public boolean checkProduct(String name) {
        String key = name.toLowerCase();
        if (groceryInventory.containsKey(key)) {
            int quantity = groceryInventory.get(key);
            System.out.println("Product found: " + name + " - Quantity: " + quantity);
            return true;
        } else {
            System.out.println("Product " + name + " not found in inventory.");
            return false;
        }
    }

    public void updateProduct(String name, int changeInQuantity) {
        String key = name.toLowerCase();
        if (groceryInventory.containsKey(key)) {
            int newQty = changeInQuantity; //+ groceryInventory.get(key)
            newQty = Math.max(newQty, 0);
            groceryInventory.put(key, newQty);
            System.out.println("Updated " + name + " to quantity: " + newQty);
        } else {
            System.out.println(name + " not found in inventory list.");
        }
    }

    public void removeProduct(String name) {
        if (groceryInventory.remove(name.toLowerCase()) != null) {
            System.out.println(name + " removed from inventory.");
        } else {
            System.out.println(name + " not found in inventory list.");
        }
    }

    public void viewInventory() {
        if (groceryInventory.isEmpty()) {
            System.out.println("Inventory is currently empty.");
        } else {
            System.out.println("---Current Inventory---");
            for (Map.Entry<String, Integer> entry : groceryInventory.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}
