package lowleveldesigns.vendingmachine;

public interface State {

    public void insertMoney(VendingMachine machine, double amount);
    public void pressButton(VendingMachine machine, int rackNumber);
    public void returnChange(double amount);
    public void updateInventory(VendingMachine machine, int rackNumber);
    public void dispenseProduct(VendingMachine machine, int rackNumber);
}

class NoMoneyInsertedState implements State{

    @Override
    public void insertMoney(VendingMachine machine, double amount) {

    }

    @Override
    public void pressButton(VendingMachine machine, int rackNumber) {

    }

    @Override
    public void returnChange(double amount) {

    }

    @Override
    public void updateInventory(VendingMachine machine, int rackNumber) {

    }

    @Override
    public void dispenseProduct(VendingMachine machine, int rackNumber) {

    }
}

class MoneyInserted implements State{

    @Override
    public void insertMoney(VendingMachine machine, double amount) {

    }

    @Override
    public void pressButton(VendingMachine machine, int rackNumber) {

    }

    @Override
    public void returnChange(double amount) {

    }

    @Override
    public void updateInventory(VendingMachine machine, int rackNumber) {

    }

    @Override
    public void dispenseProduct(VendingMachine machine, int rackNumber) {

    }
}
class DispenseState implements State {

    @Override
    public void insertMoney(VendingMachine machine, double amount) {

    }

    @Override
    public void pressButton(VendingMachine machine, int rackNumber) {

    }

    @Override
    public void returnChange(double amount) {

    }

    @Override
    public void updateInventory(VendingMachine machine, int rackNumber) {

    }

    @Override
    public void dispenseProduct(VendingMachine machine, int rackNumber) {

    }
}