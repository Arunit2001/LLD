package AuctionPlanner;

public interface Bidder {
    public void placeBid(int amount);
    public void recieveMessage(String msg);
    public String getName();
}
