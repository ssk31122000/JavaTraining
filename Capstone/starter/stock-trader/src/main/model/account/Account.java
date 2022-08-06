package src.main.model.account;

import java.util.HashMap;

import src.main.utils.Color;

public abstract class Account {

    private double funds;
    private HashMap<String,Integer> portfolio;

    public Account(double funds){
        this.funds=funds;
        this.portfolio=new HashMap<>();
    }

    public double getFunds(){
        return this.funds;
    }

    public void setFunds(double funds){
        this.funds=funds;
    }

    public void addShares(String share, int quantity){
        if(portfolio.containsKey(share)){
            portfolio.replace(share, portfolio.get(share)+quantity);
        }else{
            portfolio.put(share, quantity);
        }
    }

    public int getShare(String share){
        if(portfolio.containsKey(share)){
            return portfolio.get(share);
        }

        return 0;
    }

    public abstract boolean buy(String share, int quantity, double price);

    public abstract boolean sell(String share, int quantity, double price);

    public String displayPortofolio(){
        StringBuilder temp=new StringBuilder("");
        portfolio.forEach((k,v)-> temp.append("  "+k+"\t\t"+v+"\n"));
        return temp.toString();
    }


    public String toString() {
        return "\n  Stock\t\t"  + Color.RESET + "Shares" +
        "\n\n" + displayPortofolio() + Color.RESET +
        "\n  Funds Left\t" + Color.GREEN + "$" + Math.round(this.getFunds()) + Color.RESET;
    }

}
