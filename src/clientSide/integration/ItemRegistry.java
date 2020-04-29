package clientSide.integration;

import clientSide.shared.Item;

/**
 * A class which represents a list which holds all the items that can be purchased.
 */

public class ItemRegistry {
    private Item[] items;

    /**
     * Creates a new instance
     *
     * @param items The list of items which are in store
     */
    public ItemRegistry(Item[] items){
        this.items = items;
    }

    /**
     * Finds an item
     *
     * @param itemID The identification number of the item being searched
     *
     * @return the item with this itemID, if item not found return null
     */
    public Item findItem(int itemID) {
        for (int i = 0; i < items.length; i++) {
            if(items[i].getItemID() == itemID){
                return items[i];
            }
        }
        return null;
    }

    /**
     * Verifies itemID and itemQuantity
     *
     * @param itemID, The item id which is used to identify items in the list stored items
     *
     * @param itemQuantity, the quantity of item which is requested
     *
     * @return true if item is found and the quantity request can be met, else returns false.
     */
    public boolean verifyItem(int itemID, int itemQuantity) {
        for (int i = 0; i < items.length; i++) {
            if(items[i].getItemID() == itemID && items[i].getQuantity() >= itemQuantity){
                items[i].setQuantity(items[i].getQuantity() - itemQuantity);
                return true;
            }
        }
        return false;
    }
}
