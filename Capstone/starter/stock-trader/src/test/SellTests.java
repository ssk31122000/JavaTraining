package src.test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import src.main.model.PersonalAccount;
import src.main.model.TfsaAccount;
import src.main.model.account.Account;

public class SellTests {
    
    Account[] accounts;
    PersonalAccount acc;
    TfsaAccount acc2;


    @Before
    public void setUp(){
        acc=new PersonalAccount(2000);
        acc.buy("GGL", 20, 3.50);
        acc.sell("GGL", 10, 4.00);

        acc2 = new TfsaAccount(2000);
        acc2.buy("GGL", 20, 3.50);
        acc2.sell("GGL", 10, 4.00);
    }

    @Test
    public void testPersonalShareDecrease(){
        assertEquals(10, acc.getShare("GGL"));
    }

    @Test
    public void testPersonalFundsIncrease(){
        assertEquals(1968.00, acc.getFunds());
    }

    @Test 
    public void testPersonalInsufficientShares(){
        assertFalse(acc.sell("GGL", 100, 4.00));
    }

    @Test
    public void testTfsaShareDecrease(){
        assertEquals(10, acc2.getShare("GGL"));
    }

    @Test
    public void testTfsaFundsIncrease(){
        assertEquals(1968.9, acc2.getFunds());
    }

    @Test
    public void testTfsaIbsufficientShares(){
        assertFalse(acc2.sell("GGL", 100, 4.00));
    }

}
