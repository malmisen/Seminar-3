package clientSide.view.addingItemToCartView;

import clientSide.viewModel.viewModels.AddItemToCartViewModel;
import clientSide.viewModel.viewModels.SaleViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
*The Class View, this class contains data-bindings with AddItemToCartViewModel.
 * The class handles the presentation of data, displayed on the user interface.
*
*/


public class View {

    private SaleViewModel saleViewModel;
    private AddItemToCartViewModel addItemToCartViewModel;

    @FXML
    private Button appleAdder;
    @FXML
    private TextField appleQuantity;
    @FXML
    private Button bananaAdder;
    @FXML
    private TextField bananaQuantity;
    @FXML
    private Button pastaAdder;
    @FXML
    private TextField pastaQuantity;
    @FXML
    private Label totalPrice;
    @FXML
    private TextField totalPriceField;
    @FXML
    private Label totalVAT;
    @FXML
    private TextField totalVATField;
    @FXML
    private TextArea errorMessage;

    private int itemID;
    private int itemQuantity;

    /**
     *Initialize method, binds instance variables with the the view model's instance variables.
     *
     * @param addItemToCartViewModel The view model which is responsible for handling operations and changing values on the view.
     */
    public void init(AddItemToCartViewModel addItemToCartViewModel){
        this.addItemToCartViewModel = addItemToCartViewModel;
        appleQuantity.textProperty().setValue("0");
        totalPriceField.textProperty().bind(addItemToCartViewModel.runningTotalProperty());
        totalVATField.textProperty().bind(addItemToCartViewModel.totalVATProperty());
        errorMessage.textProperty().bind(addItemToCartViewModel.errorMessageProperty());
    }


    //itemID should probably not be hard coded here
    @FXML
    private void AddBananaToCart() {
        itemID = 2;
        itemQuantity = Integer.parseInt(bananaQuantity.textProperty().getValue());
        addItemToCartViewModel.checkValidity(itemID, itemQuantity);

        addItemToCart();

    }

    @FXML
    private void addAppleToCartAction() {
        itemID = 1;
        if(Integer.parseInt(appleQuantity.textProperty().getValue()) > 0){
            itemQuantity = Integer.parseInt(appleQuantity.textProperty().getValue());
            addItemToCart();
        }

    }

    @FXML
    private void addPastaToCartAction() {
        itemID = 3;
        itemQuantity = Integer.parseInt(pastaQuantity.textProperty().getValue());
        addItemToCart();

    }

    @FXML
    void endSaleAction() {
        addItemToCartViewModel.endSale();
    }


    private void addItemToCart(){
        addItemToCartViewModel.registerItem(itemID, itemQuantity);
    }



}
