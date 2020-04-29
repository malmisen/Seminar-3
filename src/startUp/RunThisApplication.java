package startUp;


import clientSide.integration.DiscountCatalog;
import clientSide.integration.ItemRegistry;
import clientSide.model.SaleLogicImp;
import clientSide.model.SaleLogicModel;

import clientSide.shared.Item;
import clientSide.shared.ScannedGoods;
import clientSide.view.ViewHandler;
import javafx.application.Application;
import javafx.stage.Stage;

public class RunThisApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Item apple = new Item(1, "apple", 15, 0.2, 0.1 , 5);
        Item banana = new Item(2, "banana", 7, 0.03, 0, 10);
        Item pasta = new Item(3, "pasta", 25, 0.028, 0.4, 15);

        Item[] items = {apple, banana, pasta};
        ItemRegistry itemRegistry = new ItemRegistry(items);
        ScannedGoods scannedItems = new ScannedGoods();

        DiscountCatalog discountCatalog = new DiscountCatalog(items);

        SaleLogicModel model = new SaleLogicImp(itemRegistry, scannedItems, discountCatalog);
        ViewHandler viewHandler = new ViewHandler(stage, model);
        viewHandler.start();
    }



}
