package lowleveldesigns.vendingmachine;

import java.util.List;

public class VendingMachine {
    private State currentState;
    private Double amount;
    private int noOfRacks;
    private List<Rack> racks;

    private static VendingMachine vendingMachine = null;

    private VendingMachine(){}

    public static VendingMachine getInstance(){
        if(vendingMachine == null){
            vendingMachine = new VendingMachine();
        }
        return vendingMachine;
    }

    public void insertMoney(double amount){

    }
    public void pressButton(int rackName){}
    public void returnChange(double amount) {}
    public void updateInventory(int rackNumber){}
    public void  dispenseProduct(int rackNumber){}
    public int getProductIdAtrack(int rackNumber){ return 0;}

}
