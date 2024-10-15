package VendingMachine.State.Impl;

import VendingMachine.State.MachineState;
import VendingMachine.*;

import java.util.ArrayList;
import java.util.List;

public class IdleState implements MachineState {

    public IdleState() {
        System.out.println("Machine in Idle State.");
    }

    public IdleState(VendingMachine machine) {
        System.out.println("Machine in Idle State.");
        machine.setCoinList(new ArrayList<>());
    }

    @Override
    public void pressInsertCoinButton(VendingMachine machine) throws Exception {
        machine.setVendingMachineState(new CollectMoneyState());
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int productCode) throws Exception {
        throw new Exception("Product not selected.");
    }

    @Override
    public int collectChange(int change) throws Exception {
        throw new Exception("No change to collect.");
    }

    @Override
    public void selectProduct(VendingMachine machine, int productCode) throws Exception {
        throw new Exception("Insert coin first.");
    }

    @Override
    public List<Coin> pressCancelButton(VendingMachine machine) throws Exception {
        throw new Exception("Nothing to cancel.");
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
