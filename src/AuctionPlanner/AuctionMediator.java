package AuctionPlanner;

import java.util.ArrayList;
import java.util.List;

public class AuctionMediator implements Mediator {
    List<Bidder> bidders = new ArrayList<>();


    @Override
    public void addBidder(Bidder bidder) {
        bidders.add(bidder);
    }

    @Override
    public void placeBid(Bidder bidder, int amount) {
        for(Bidder b : bidders) {
            if(b!=bidder) {
                b.recieveMessage(bidder.getName() + " for " + amount);
            }
        }
    }
}
