package src.test;


import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import src.main.model.PersonalAccount;
import src.main.model.TfsaAccount;
import src.main.model.account.Account;

public class BuyTests {
    
    Account[] accounts;
    PersonalAccount acc;
    TfsaAccount acc2;

    @Before
    public void setUp(){
        acc = new PersonalAccount(2000);
        acc.buy("GGL",20,3.50);

        acc2 = new TfsaAccount(2000);
        acc2.buy("GGL", 20, 3.50);
    }

    @Test
    public void testPersonalShareIncrease(){
        assertEquals(20 , acc.getShare("GGL"));
    }

    @Test
    public void testPersonalFundsDecrease(){
        assertEquals(1930.00, acc.getFunds());
    }

    @Test
    public void testPersonalInsufficientBalance(){
        assertFalse(acc.buy("GGL",2000,3.50));
    }

    @Test
    public void testTfsaAccountShareIncrease(){
        assertEquals(20, acc2.getShare("GGL"));
    }

    @Test
    public void testTfsaAccountFundsDecrease(){
        assertEquals(1929.30,acc2.getFunds());
    }

    @Test
    public void testTfsaInsufficientBalance(){
        assertFalse(acc2.buy("GGL", 2000, 3.50));
    }
}
