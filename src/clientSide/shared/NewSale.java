package clientSide.shared;

/**
 * Class NewSale, The Class holds the information regarding the ongoing sale
 */

public class NewSale {
    private double runningTotal;
    private double totalVAT;
    private ScannedGoods registeredItems;
    private String errorMsg;

    public NewSale(double runningTotal, double totalVAT){
        this.runningTotal = runningTotal;
        this.totalVAT = totalVAT;
    }
    public NewSale(String errorMsg){
        this.errorMsg = errorMsg;
    }

    public double getRunningTotal(){
        return runningTotal;
    }
    public double getTotalVAT(){
        return totalVAT;
    }

    public String getErrorMsg(){
        return errorMsg;
    }
}
