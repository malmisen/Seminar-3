package clientSide.viewModel;

import clientSide.model.SaleLogicModel;
import clientSide.view.ViewHandler;
import clientSide.viewModel.viewModels.AddItemToCartViewModel;
import clientSide.viewModel.viewModels.SaleViewModel;
import clientSide.viewModel.viewModels.TransactionViewModel;

public class ViewModelProvider {

    private AddItemToCartViewModel addItemModel;
    private SaleViewModel newSaleModel;
    private TransactionViewModel tViewModel;

    public ViewModelProvider(SaleLogicModel model, ViewHandler vh){
            addItemModel = new AddItemToCartViewModel(model, vh);
            newSaleModel = new SaleViewModel(model, vh);
            tViewModel = new TransactionViewModel(model, vh);
    }

    public AddItemToCartViewModel getAddItemModel() {
        return addItemModel;
    }

    public SaleViewModel getStartNewSaleModel() {
        return newSaleModel;
    }

    public TransactionViewModel getTransactionViewModel(){
        return tViewModel;
    }
}
