package VendingMachine.State.Impl;

import VendingMachine.State.MachineState;
import VendingMachine.*;

import java.util.List;

public class CollectMoneyState implements MachineState {

    public CollectMoneyState() {
        System.out.println("Machine in CollectMoney State.");
    }

    @Override
    public void pressInsertCoinButton(VendingMachine machine) throws Exception {
        throw new Exception("Already pressed.");
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int productCode) throws Exception {
        throw new Exception("Product not selected.");
    }

    @Override
    public int collectChange(int change) throws Exception {
        throw new Exception("No change to collect");
    }

    @Override
    public void selectProduct(VendingMachine machine, int productCode) throws Exception {
        throw new Exception("Insert coin first.");
    }

    @Override
    public List<Coin> pressCancelButton(VendingMachine machine) throws Exception {
        System.out.println("Returned the full amount back in the Coin Dispense Tray");
        machine.setVendingMachineState(new IdleState(machine));
        return machine.getCoinList();
    }

    @Override
    public void pressProductSelectionButton(VendingMachine machine) throws Exception {
        machine.setVendingMachineState(new ProductSelectionState());
        System.out.println("Machine is now in Product Selection Stage.");
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        System.out.print("Accepted Coin.");
        machine.addCoin(coin);
    }
}
