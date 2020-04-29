package clientSide.shared;

import java.util.ArrayList;

/**
 * A Class which represents a list of registered items. Items which are ready to be purchased,
 */

public class ScannedGoods {
    private ArrayList<Item> items;

    /**
     * Creates a new instance
     */
    public ScannedGoods(){
        items = new ArrayList<>();
    }
    /**
     * Add item to the list of registered items
     *
     * @param item The item to be added
     * @param quantity The quantity of the item to be added
     */
    public void addItem(Item item, int quantity) {
        int counter = 0;
        while(counter < quantity){
            items.add(item);
            counter++;
        }
    }

    /**
     * @return the total price of all the registered items
     */
    public double totalPriceOfGoods() {
        double tempPrice = 0;
        for(int i = 0; i < items.size(); i++)
            tempPrice += items.get(i).getPrice();

        return tempPrice;
    }

    /**
     * @return the total VAT of all the scanned items
     */
    public double totalVAT() {
        double totalVAT = 0;
        for (int i = 0; i < items.size() ; i++) {
            totalVAT += (items.get(i).getPrice() * items.get(i).getItemVAT());
        }

        return totalVAT;
    }

    public ArrayList<Item> getList() {
        return items;
    }
}
