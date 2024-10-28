package AuctionPlanner;

public class Auction {
    public static void main(String args[]) {
        Mediator auctionMediator = new AuctionMediator();
        Bidder b1 = new AuctionBidder("ABC", auctionMediator);
        Bidder b2 = new AuctionBidder("QWE", auctionMediator);
        Bidder b3 = new AuctionBidder("SDF", auctionMediator);

        b1.placeBid(200);
        b2.placeBid(300);
    }
}
