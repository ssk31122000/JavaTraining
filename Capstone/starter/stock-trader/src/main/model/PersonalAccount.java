package src.main.model;

import src.main.model.account.Account;

public class PersonalAccount extends Account {
    
    public PersonalAccount(double funds) {
        super(funds);
    }

    @Override
    public boolean buy(String share, int quantity, double price){
        if(quantity*price > this.getFunds()){
            return false;
        }
        this.addShares(share, quantity);
        this.setFunds(this.getFunds()-(price*quantity));
        return true;
    }

    @Override
    public boolean sell(String share, int quantity, double price) {
        if(quantity>this.getShare(share)){
            return false;
        }
        this.addShares(share, -quantity);
        this.setFunds(this.getFunds()+(quantity*price*0.95));
        return true;
    }
}
