package VendingMachine.State.Impl;

import VendingMachine.State.MachineState;
import VendingMachine.*;

import java.util.List;

public class DispensingStage implements MachineState {

    public DispensingStage(VendingMachine machine, int productCode) throws Exception {
        System.out.println("Machine set to product dispensing state.");
        dispenseProduct(machine, productCode);
    }

    @Override
    public void pressInsertCoinButton(VendingMachine machine) throws Exception {
        throw new Exception("Already pressed.");
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int productCode) throws Exception {
        System.out.println("Product has been dispensed");
        Item item = machine.getInventory().getItem(productCode);
        machine.getInventory().updateSoldOutItem(productCode);
        machine.setVendingMachineState(new IdleState(machine));
        return item;

    }

    @Override
    public int collectChange(int change) throws Exception {
        throw new Exception("No change to collect in Dispense state.");
    }

    @Override
    public void selectProduct(VendingMachine machine, int productCode) throws Exception {
        throw new Exception("Product selection not allowed in dispense state.");
    }

    @Override
    public List<Coin> pressCancelButton(VendingMachine machine) throws Exception {
        throw new Exception("Refund can not be happen in Dispense state");
    }

    @Override
    public void pressProductSelectionButton(VendingMachine machine) throws Exception {
        throw new Exception("Not allowed in Dispense state");
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        throw new Exception("Not allowed i Dispense state.");
    }
}
