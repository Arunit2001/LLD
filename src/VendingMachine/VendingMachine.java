package VendingMachine;

import VendingMachine.State.Impl.IdleState;
import VendingMachine.State.MachineState;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    MachineState vendingMachineState;
    List<Coin> coinList;
    Inventory inventory;

    public VendingMachine() {
        vendingMachineState = new IdleState();
        this.inventory = new Inventory(10);
        this.coinList = new ArrayList<>();
    }

    public MachineState getVendingMachineState() {
        return vendingMachineState;
    }

    public void setVendingMachineState(MachineState vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }

    public List<Coin> getCoinList() {
        return coinList;
    }

    public void setCoinList(List<Coin> coinList) {
        this.coinList = coinList;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void addCoin(Coin coin) {
        this.coinList.add(coin);
    }
}
