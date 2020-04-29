package test;

import clientSide.shared.Item;
import clientSide.shared.ScannedGoods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestScannedGoods {

    private ScannedGoods goods;
    @BeforeEach
    public void setUp(){
         goods = new ScannedGoods();
    }

    @Test
    public void getItemList(){
        ArrayList<Item> items = new ArrayList<>();
        Assertions.assertTrue(goods.getList().equals(items));
    }

    @Test
    public void addItemNull(){
        Exception exception = assertThrows(NullPointerException.class, () -> {
            goods.addItem(null, 1);
        });
    }

    @Test
    public void addZeroApples(){
        Item apple = new Item(1, "apple", 15, 0.2, 0.1 , 5);
        goods.addItem(apple, 0);
        Assertions.assertFalse(goods.getList().contains(apple));
    }

    @Test
    public void addOneItem(){
        Item apple = new Item(1, "apple", 15, 0.2, 0.1 , 5);
        goods.addItem(apple, 1);
        Assertions.assertTrue(goods.getList().size() == 1);
    }

    @Test
    public void addTwoOfOneItem(){
        Item apple = new Item(1, "apple", 15, 0.2, 0.1 , 5);
        goods.addItem(apple, 2);
        Assertions.assertTrue(goods.getList().size() == 2);
    }

    @Test
    public void addTwoItems(){
        Item apple = new Item(1, "apple", 15, 0.2, 0.1 , 5);
        Item banana = new Item(2, "banana", 15, 0.2, 0.1 , 5);

        goods.addItem(apple, 1);
        goods.addItem(banana, 1);

        Assertions.assertTrue(goods.getList().size() == 2);
    }

}
