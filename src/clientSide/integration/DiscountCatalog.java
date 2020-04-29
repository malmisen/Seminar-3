package clientSide.integration;

import clientSide.shared.Item;

import java.util.ArrayList;

/**
 * Class DiscountCatalog, has a list of valid customer identification numbers
 * and is able to return a totalDiscount on a purchase
 */
public class DiscountCatalog {
    private Item[] inStoreItems;
    private int[] vipCustomers = {1, 2, 3, 4};
    private double totalDiscount;

    /**
     * Create a new instance
     */
    public DiscountCatalog(Item[] inStoreItems){
        this.inStoreItems = inStoreItems;
    }

    private static double setTotalDiscount(ArrayList<Item> items){
        double tempDiscount = 0;
        for (int i = 0; i < items.size(); i++) {
            tempDiscount += (items.get(i).getDiscount() * items.get(i).getPrice());
        }
        return tempDiscount;
    }

    /**
     * @param customerID The identification number of the customer
     * @param items The list of items being purchased
     *
     * @return totalDiscount, the total discount on the purchase
     */
    public double getTotalDiscount(int customerID, ArrayList<Item> items) {

        totalDiscount = setTotalDiscount(items);

        for(int i = 0; i < vipCustomers.length; i++){
            if(customerID == vipCustomers[i]){
                return totalDiscount;
            }
        }

        return 0;
    }
}
