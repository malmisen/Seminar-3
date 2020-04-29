package clientSide.viewModel.viewModels;

import clientSide.model.SaleLogicModel;
import clientSide.view.ViewHandler;

public class SaleViewModel {
    private SaleLogicModel model;
    private ViewHandler viewHandler;

    public SaleViewModel(SaleLogicModel model, ViewHandler vh){
        this.model = model;
        viewHandler = vh;
    }

    public void startNewSale(){
        viewHandler.openAddItemToCartView();
    }

}
