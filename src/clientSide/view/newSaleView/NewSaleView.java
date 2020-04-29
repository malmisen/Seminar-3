package clientSide.view.newSaleView;

import clientSide.viewModel.viewModels.SaleViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class NewSaleView {

    private SaleViewModel viewModel;

    public void init(SaleViewModel viewModel){
        this.viewModel = viewModel;
    }

    @FXML
    void startNewSale(ActionEvent event) {
        viewModel.startNewSale();
    }

}