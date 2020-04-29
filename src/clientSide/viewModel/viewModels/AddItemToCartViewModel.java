package clientSide.viewModel.viewModels;

import clientSide.model.SaleLogicModel;
import clientSide.shared.NewSale;
import clientSide.view.ViewHandler;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


/**
 *This class is responsible for making method calls on the model.
 * Mainly handling operations regarding items.
 */

public class AddItemToCartViewModel {
    private SaleLogicModel model;
    private ViewHandler viewHandler;

    private StringProperty runningTotal;
    private StringProperty totalVAT;
    private StringProperty errorMessage;

    /**
     *Creates a new instance
     *
     * @param model The model which holds all the business logic
     * @param viewHandler, the class which handles the different views.
     */

    public AddItemToCartViewModel(SaleLogicModel model, ViewHandler viewHandler){
        this.model = model;
        this.viewHandler = viewHandler;
        runningTotal = new SimpleStringProperty();
        totalVAT = new SimpleStringProperty();
        errorMessage = new SimpleStringProperty();
    }

    /**
     * Creates a new sale object by retrieving an item and its information from the item registry.
     * retrieves running total and total VAT and displays it on the view
     *
     * @param itemID The item identification number
     * @param quantity The amount of items with this ID being purchases
     */

    public void registerItem(int itemID, int quantity){
           NewSale sale = model.registerItem(itemID, quantity);
           System.out.println("Test, d1");
           runningTotal.setValue(String.valueOf(sale.getRunningTotal()));
           totalVAT.setValue(String.valueOf(sale.getTotalVAT()));
    }

    /**
     * @returns the running total price
     */
    public StringProperty runningTotalProperty() {
        return runningTotal;
    }

    /**
     * @returns the total VAT
     */
    public StringProperty totalVATProperty(){
        return totalVAT;
    }

    /**
     * @returns the errorMessage;
     */
    public StringProperty errorMessageProperty() {
        return errorMessage;
    }

    public void endSale() {
        viewHandler.openEndSaleView();
    }

    public void checkValidity(int itemID, int itemQuantity) {
        if(model.checkItemValidity(itemID, itemQuantity)){

        }
    }
}
