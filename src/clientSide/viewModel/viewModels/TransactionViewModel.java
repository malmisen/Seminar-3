package clientSide.viewModel.viewModels;

import clientSide.model.SaleLogicModel;
import clientSide.view.ViewHandler;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class TransactionViewModel {
    private SaleLogicModel model;
    private ViewHandler viewHandler;

    private StringProperty runningTotal;
    private StringProperty totalVAT;
    private StringProperty discount;
    private StringProperty change;

    public TransactionViewModel(SaleLogicModel model, ViewHandler vh){
        this.model = model;
        viewHandler = vh;
        runningTotal = new SimpleStringProperty();
        totalVAT = new SimpleStringProperty();
        change = new SimpleStringProperty();
        discount = new SimpleStringProperty();

    }

    public void discountRequest(int customerID){
        double tempDisc = model.handleDiscountRequest(customerID);
        double price = model.calculateRunningTotal();
        double tempTotal = price - tempDisc;
        discount.setValue(String.valueOf(tempDisc));
        totalVAT.setValue(String.valueOf(model.getTotalVAT()));
        runningTotal.setValue(String.valueOf(tempTotal));
    }

    public void payment(double amountPaid){
       change.setValue(String.valueOf(model.calculateChange(amountPaid)));
    }

    public StringProperty getRunningTotal() {
        return runningTotal;
    }

    public StringProperty getTotalVAT(){
        return totalVAT;
    }

    public StringProperty getChange() {
        return change;
    }

    public void setRunningTotal() {
        runningTotal.setValue(String.valueOf(model.calculateRunningTotal()));
    }
    public void setTotalVAT(){
        totalVAT.setValue(String.valueOf(model.getTotalVAT()));
    }

    public StringProperty getDiscount() {
        return discount;
    }
}
