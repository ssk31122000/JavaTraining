package src.main.model;


import java.text.DecimalFormat;

import src.main.model.account.Account;

public class TfsaAccount extends Account{

    private static final DecimalFormat df = new DecimalFormat("#.##");
    
    public TfsaAccount(double funds){
        super(funds);
    }

    @Override
    public boolean buy(String share, int quantity, double price) {
        if((quantity*price)*1.01 > this.getFunds()){
            return false;
        }
        this.addShares(share, quantity);
        this.setFunds(this.getFunds()-(price*quantity*1.01));
        return true;
    }

    @Override
    public boolean sell(String share, int quantity, double price) {
        if(quantity>this.getShare("GGL")){
            return false;
        }
        this.addShares(share, -quantity); 
        this.setFunds(Double.valueOf(df.format(this.getFunds()+(quantity*price*0.99))));    
        return true;   
    }
}
