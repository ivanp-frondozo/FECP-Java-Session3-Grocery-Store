package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InventoryManagerTest {

    InventoryManager inventory;

    @BeforeEach
    public void setup() {
        inventory = new InventoryManager();
    }

    @Test //addProduct method
    public void shouldAddItemWithCorrectQuantity() {
        inventory.addProduct("Banana", 30);
        assertTrue(inventory.checkProduct("Banana"));
        assertEquals(30, inventory.getQuantity("Banana"));
    }

    @Test //addProduct method
    public void shouldNotAddItemWithQuantityZero() {
        inventory.addProduct("Banana", 0);
        assertFalse(inventory.checkProduct("Banana"));
    }

    @Test //checkProduct method
    public void shouldReturnExistingProduct() { //practically the same with first test method
        inventory.addProduct("Banana", 30);
        assertTrue(inventory.checkProduct("Banana"));
    }

    @Test //checkProduct method
    public void shouldReturnProductNotFound() {
        inventory.addProduct("Banana", 30);
        assertFalse(inventory.checkProduct("Mango"));
    }

    @Test //updateProduct method
    public void shouldUpdateExistingProductWithValidQuantity() {
        inventory.addProduct("Banana", 30);
        inventory.updateProduct("Banana", 10);
        assertEquals(10, inventory.getQuantity("Banana"));
    }

    @Test //updateProduct method
    public void shouldNotUpdateNonexistingProduct() {
        inventory.addProduct("Banana", 30);
        inventory.updateProduct("Tofu", 10);
        assertFalse(inventory.checkProduct("Tofu"));
        assertEquals(30, inventory.getQuantity("Banana")); //to check Banana was not updated
    }

    @Test //removeProduct method
    public void shouldRemoveExistingProduct() {
        inventory.addProduct("Banana", 30);
        inventory.removeProduct("Banana");
        assertFalse(inventory.checkProduct("Banana"));
    }

    @Test //removeProduct method
    public void shouldNotRemoveNonexistingProduct() {
        inventory.addProduct("Banana", 30);
        inventory.removeProduct("Tofu");
        assertFalse(inventory.checkProduct("Tofu"));
        assertTrue(inventory.checkProduct("Banana")); //checks if banana was not changed
    }
}