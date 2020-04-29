package test;

import clientSide.integration.ItemRegistry;
import clientSide.shared.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestRegistry {

    private ItemRegistry registry;
    @BeforeEach
    public void setUp(){
        Item apple = new Item(1, "apple", 15, 0.2, 0.1 , 5);
        Item banana = new Item(2, "banana", 7, 0.03, 0, 10);

        Item[] items = {apple, banana};
        registry = new ItemRegistry(items);
    }

    @Test
    public void returnNullObject(){
        Assertions.assertTrue(registry.findItem(100) == null, "Invalid item ID");
    }
    @Test
    public void returnCorrectItemObj(){
        Item apple = new Item(1, "apple", 15, 0.2, 0.1, 5);
        Item item = registry.findItem(1);
        Assertions.assertEquals(item.getItemID(), apple.getItemID());
    }

    @Test
    public void requestTooLargeQuantity(){
        Assertions.assertTrue(registry.verifyItem(1, 100) == false, "Too large quantity");
    }

    @Test
    public void checkItemQuantity(){
        Item item = registry.findItem(1);
        Assertions.assertTrue(4 == item.getQuantity());
    }

    @Test
    public void itemOutOfStock(){
        Item item = registry.findItem(1);
        Assertions.assertTrue(registry.findItem(1) == null, "Not in stock");
    }

    @Test
    public void illegalArgument(){
    }
}
