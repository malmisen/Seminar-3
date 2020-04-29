package clientSide.model;

import clientSide.shared.NewSale;

public interface SaleLogicModel {

    NewSale registerItem(int itemID, int quantity);

    double calculateRunningTotal();

    double getTotalVAT();

    double calculateChange(double amountPaid);

    double handleDiscountRequest(int customerID);

    boolean checkItemValidity(int itemID, int itemQuantity);
}
