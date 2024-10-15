package VendingMachine.State.Impl;

import VendingMachine.State.MachineState;
import VendingMachine.*;

import java.util.List;

public class ProductSelectionState implements MachineState {

    public ProductSelectionState() {
        System.out.println("Machine set to Product Selection State.");
    }

    @Override
    public void pressInsertCoinButton(VendingMachine machine) throws Exception {
        throw new Exception("Already pressed.");
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int productCode) throws Exception {
        throw new Exception("Product not selected");
    }

    @Override
    public int collectChange(int change) throws Exception {
        System.out.println("Please collect " + change + " from the change tray.");
        return change;
    }

    @Override
    public void selectProduct(VendingMachine machine, int productCode) throws Exception {
        Item item = machine.getInventory().getItem(productCode);
        int itemPrice = item.getPrice();
        int coinPaid = 0;
        for(Coin coin : machine.getCoinList()) {
            coinPaid += coin.value;
        }

        if(coinPaid < itemPrice) {
            System.out.println("Coin not sufficient for the selected product.");
            pressCancelButton(machine);
        }else {
            if(coinPaid > itemPrice) {
                collectChange(coinPaid - itemPrice);
            }
            machine.setVendingMachineState(new DispensingStage(machine, productCode));
        }
    }

    @Override
    public List<Coin> pressCancelButton(VendingMachine machine) throws Exception {
        System.out.println("Returned all coin.");
        machine.setVendingMachineState(new IdleState(machine));
        return machine.getCoinList();
    }

    @Override
    public void pressProductSelectionButton(VendingMachine machine) throws Exception {
        throw new Exception("Insert Coin first.");
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        throw new Exception("Press Insert Coin Button");
    }
}
