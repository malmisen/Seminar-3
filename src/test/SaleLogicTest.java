package test;

import clientSide.integration.DiscountCatalog;
import clientSide.integration.ItemRegistry;
import clientSide.model.SaleLogicImp;
import clientSide.shared.Item;
import clientSide.shared.NewSale;
import clientSide.shared.ScannedGoods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class SaleLogicTest {

    private SaleLogicImp imp;

    @BeforeEach
    public void setUp(){

        Item apple = new Item(1, "apple", 15, 0.2, 0.1 , 5);
        Item banana = new Item(2, "banana", 7, 0.03, 0, 10);

        Item[] items = {apple, banana};
        ItemRegistry reg = new ItemRegistry(items);
        ScannedGoods goods = new ScannedGoods();
        DiscountCatalog catalog = new DiscountCatalog(items);
        imp = new SaleLogicImp(reg, goods, catalog);
    }

    @Test
    public void registerZero(){
            NewSale sale = imp.registerItem(0, 0);
            Assertions.assertTrue(sale.getErrorMsg() != null);
    }

    @Test()
    public void registerQuantityZero(){
       NewSale sale = imp.registerItem(1, 0);
       Assertions.assertTrue(sale.getErrorMsg() != null);
    }

    @Test
    public void registerCorrectId(){
       NewSale sale =  imp.registerItem(1, 1);
       Assertions.assertTrue(sale.getRunningTotal() == 15);
    }

    @Test void registerTwoItems(){
        NewSale sale = imp.registerItem(1, 2);
        Assertions.assertTrue(sale.getRunningTotal() == 30);
    }

    @Test
    public void calculateRunningTotal(){
        NewSale sale =  imp.registerItem(1, 1);
        Assertions.assertTrue(imp.calculateRunningTotal() == 15);

    }

    @Test
    public void calculateTwoRunningTotal(){
        NewSale sale = imp.registerItem(1, 2);
        Assertions.assertTrue(imp.calculateRunningTotal() == 30);
    }

    @Test
    public void calculateRunningTotalZero(){
        NewSale sale = imp.registerItem(200, 200);
        Assertions.assertTrue(imp.calculateRunningTotal() == 0);
    }

    @Test
    public void checkTotalVAT() {
        NewSale sale = imp.registerItem(1, 1);
        double tempVAT = imp.getTotalVAT();
        Assertions.assertTrue(tempVAT == 3);
    }

    @Test
    public void calcChange(){
        NewSale sale = imp.registerItem(1, 1);
        double change = imp.calculateChange(100);
        Assertions.assertTrue(change == 85);
    }

    @Test
    public void calcChangeWithoutHavingRegisteredItems(){
        double change = imp.calculateChange(100);
        Assertions.assertTrue(change == 0);
    }

}
