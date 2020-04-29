package clientSide.model;

import clientSide.integration.DiscountCatalog;
import clientSide.integration.ItemRegistry;
import clientSide.shared.Item;
import clientSide.shared.NewSale;
import clientSide.shared.ScannedGoods;

/**
 * A class which implements the model
 */

public class SaleLogicImp implements SaleLogicModel {

    private ScannedGoods scannedItems;
    private ItemRegistry registry;
    private DiscountCatalog discountCatalog;
    private NewSale sale;

    /**
     * Creates a new instance
     *
     * @param registry The registry containing all the available items
     * @param items The items which are registered and ready to be purchased
     */
    public SaleLogicImp(ItemRegistry registry, ScannedGoods items, DiscountCatalog discountCatalog){
        this.registry = registry;
        scannedItems = items;
        this.discountCatalog = discountCatalog;
    }


    /**
     * Creates new sale object and returns it.
     * Adds an item if possible to the list of scanned items.
     *
     * @param itemID The identification number of the item to be registered
     * @param quantity The amount of this item which should be added to the list of registered items.
     *
     * @return sale, the sale object which contains information regarding the ongoing sale.
     */

    @Override
    public NewSale registerItem(int itemID, int quantity) {
        NewSale sale = new NewSale("Item not found");
        Item item = registry.findItem(itemID);
        if(item != null){
            scannedItems.addItem(item, quantity);
            sale = new NewSale(scannedItems.totalPriceOfGoods(), scannedItems.totalVAT());
        }

        return sale;
    }

    /**
     * @return total price of the scanned items.
     */
    @Override
    public double calculateRunningTotal() {
        return scannedItems.totalPriceOfGoods();
    }

    /**
     * @return total VAT of the scanned items.
     */
    @Override
    public double getTotalVAT() {
        return scannedItems.totalVAT();
    }

    /**
     * Calculates the change
     * @param amountPaid The amount of money which was given by the customer
     * @return change, the amount of money which is given back to the customer
     */
    @Override
    public double calculateChange(double amountPaid) {
        double totalPrice = scannedItems.totalPriceOfGoods();
        double change = amountPaid - totalPrice;
        return change;

    }

    /**
     * Handles the discount request
     * Checks with the discount catalog if customer is eligible for discount.
     * @param customerID The identification number of the customer
     * @return the total discount. 0 if customer is not eligible.
     */
    @Override
    public double handleDiscountRequest(int customerID) {
            return discountCatalog.getTotalDiscount(customerID, scannedItems.getList());
    }

    /**
     * Checks the in item registry if the itemID and the requested quantity is valid.
     * @param itemID The identification number of the item
     * @param itemQuantity The requested quantity of the item
     * @return true if the itemID exists and the quantity can be met, else returns false.
     */
    @Override
    public boolean checkItemValidity(int itemID, int itemQuantity) {
        return registry.verifyItem(itemID, itemQuantity);

    }

}
