package AuctionPlanner;

public class AuctionBidder implements Bidder {
    Mediator m;
    String name;

    public AuctionBidder(String name, Mediator m) {
        this.name = name;
        this.m = m;
        m.addBidder(this);
    }


    @Override
    public void placeBid(int amount) {
        m.placeBid(this, amount);
    }

    @Override
    public void recieveMessage(String msg) {
        System.out.println(name + " got the notification of bid placed by " + msg + ".");
    }

    @Override
    public String getName() {
        return name;
    }
}
