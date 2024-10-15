package VendingMachine;

public class Inventory {
    ItemShelve[] shelve;
    int shelveSize;

    public Inventory(int shelveSize) {
        this.shelveSize = shelveSize;
        this.shelve = new ItemShelve[shelveSize];
        initialEmptyInventory();
    }

    public ItemShelve[] getShelve() {
        return shelve;
    }

    public void setShelve(ItemShelve[] shelve) {
        this.shelve = shelve;
    }

    public int getShelveSize() {
        return shelveSize;
    }

    public void setShelveSize(int shelveSize) {
        this.shelveSize = shelveSize;
    }

    public void initialEmptyInventory() {
        int startCode = 101;
        for (int i = 0; i < shelveSize; i++) {
            ItemShelve space = new ItemShelve(startCode);
            space.setSoldOut(true);
            shelve[i]= space;
            startCode++;
        }
    }

    public void addItem(Item item, int codeNumber) throws Exception {

        for (ItemShelve itemShelf : shelve) {
            if (itemShelf.getCode() == codeNumber) {
                if (itemShelf.isSoldOut()) {
                    itemShelf.setItem(item);
                    itemShelf.setSoldOut(false);
                } else {
                    throw new Exception("already item is present, you can not add item here");
                }
            }
        }
    }

    public Item getItem(int codeNumber) throws Exception {

        for (ItemShelve itemShelf : shelve) {
            if (itemShelf.getCode() == codeNumber) {
                if (itemShelf.isSoldOut()) {
                    throw new Exception("item already sold out");
                } else {

                    return itemShelf.getItem();
                }
            }
        }
        throw new Exception("Invalid Code");
    }

    public void updateSoldOutItem(int codeNumber){
        for (ItemShelve itemShelf : shelve) {
            if (itemShelf.getCode() == codeNumber) {
                itemShelf.setSoldOut(true);
            }
        }
    }

}
