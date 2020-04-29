package clientSide.shared;

/**
 * Class Item, holds the data which belongs to an item
 */
public class Item {
    private int itemID;
    private String itemName;
    private double itemPrice;
    private double itemVAT;
    private double discount;
    private int quantityLeftInStore;

    public Item(int itemID, String itemName, double itemPrice, double itemVAT,double discount, int quantityLeftInStore){
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemVAT = itemVAT;
        this.discount = discount;
        this.quantityLeftInStore = quantityLeftInStore;

    }

    public double getPrice(){
        return itemPrice;
    }
    public double getDiscount(){
        return discount;
    }
    public double getItemVAT(){
        return itemVAT;
    }
    public int getItemID(){
        return itemID;
    }
    public int getQuantity(){
        return quantityLeftInStore;
    }
    public void setQuantity(int quantity){
        quantityLeftInStore = quantity;
    }

}
