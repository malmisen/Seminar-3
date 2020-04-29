package clientSide.view;

import clientSide.model.SaleLogicModel;
import clientSide.view.addingItemToCartView.View;
import clientSide.view.newSaleView.NewSaleView;
import clientSide.view.transaction.TransactionView;
import clientSide.viewModel.ViewModelProvider;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Responsible for handling and presenting the different views
 */
public class ViewHandler {
    private ViewModelProvider viewModelProvider;
    private Stage mainStage;

    /**
     * Creates new instance
     *
     * @param mainStage The current stage
     * @param model The model which contains all the business logic
     */
    public ViewHandler(Stage mainStage, SaleLogicModel model){
        viewModelProvider = new ViewModelProvider(model, this);
        this.mainStage = mainStage;
    }

    public void start(){
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("newSaleView/NewSale.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        NewSaleView sale = loader.getController();
        sale.init(viewModelProvider.getStartNewSaleModel());
        mainStage.setTitle("initiate sale");

        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }

    public void openAddItemToCartView(){
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("addingItemToCartView/View.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        View addItemToCartView = loader.getController();
        addItemToCartView.init(viewModelProvider.getAddItemModel());
        mainStage.setTitle("register items");

        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();

    }

    public void openEndSaleView() {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("transaction/Transaction.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        TransactionView view = loader.getController();
        view.init(viewModelProvider.getTransactionViewModel());

        viewModelProvider.getTransactionViewModel().setRunningTotal();
        viewModelProvider.getTransactionViewModel().setTotalVAT();

        mainStage.setTitle("transaction");

        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }
}
