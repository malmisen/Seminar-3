package clientSide.view.transaction;

import clientSide.viewModel.viewModels.TransactionViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class TransactionView {

    private TransactionViewModel viewModel;

    @FXML
    private TextField runningTotal;

    @FXML
    private TextField amountPaidField;

    @FXML
    private TextField customerIDField;

    @FXML
    private TextField changeAmountField;

    @FXML
    private TextField totalVATField;

    @FXML
    private TextField discountField;

    public void init(TransactionViewModel model){
        viewModel = model;
        runningTotal.textProperty().bind(model.getRunningTotal());
        totalVATField.textProperty().bind(model.getTotalVAT());
        changeAmountField.textProperty().bind(model.getChange());
        discountField.textProperty().bind(model.getDiscount());

    }

    @FXML
    void payAction() {
        viewModel.payment(Integer.parseInt(amountPaidField.textProperty().getValue()));
    }

    @FXML
    void requestDiscount() {
        viewModel.discountRequest(Integer.parseInt(customerIDField.textProperty().getValue()));
    }
}
