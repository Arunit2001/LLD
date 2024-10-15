package VendingMachine.State;

import VendingMachine.VendingMachine;
import VendingMachine.Coin;
import VendingMachine.Item;

import java.util.List;

public interface MachineState {
    public void pressInsertCoinButton(VendingMachine machine) throws Exception;
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception;
    public void pressProductSelectionButton(VendingMachine machine) throws Exception;
    public List<Coin> pressCancelButton(VendingMachine machine) throws Exception;
    public void selectProduct(VendingMachine machine, int productCode) throws Exception;
    public int collectChange(int change) throws Exception;
    public Item dispenseProduct(VendingMachine machine, int productCode) throws Exception;
}
