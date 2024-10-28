package AuctionPlanner;

public interface Mediator {
    public void addBidder(Bidder bidder);
    public void placeBid(Bidder bidder, int amount);
}
