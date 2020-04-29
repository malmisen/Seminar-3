package test;

import clientSide.integration.DiscountCatalog;
import clientSide.shared.Item;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DiscountTest {
    private int customerID;
    private ArrayList<Item> items;
    private DiscountCatalog catalog;

    @BeforeEach
    public void setUp(){
        customerID = 1;
        items = new ArrayList<>();
        Item apple = new Item(1, "apple", 15, 0.2, 0.1 , 5);
        Item banana = new Item(2, "banana", 7, 0.03, 0, 10);

        Item[] items = {apple, banana};
        catalog = new DiscountCatalog(items);
    }


    @Test
    public void testCustomerIDNotFound(){
        double discount = catalog.getTotalDiscount(10, items);
       assertTrue(discount == 0, "Customer ID not found");

    }

    @Test
    public void testNullInput(){
        Assertions.assertThrows(NullPointerException.class, () -> {catalog.getTotalDiscount(1, null);
        });
    }


}
