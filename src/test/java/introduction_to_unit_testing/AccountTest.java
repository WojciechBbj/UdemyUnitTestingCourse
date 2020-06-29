package introduction_to_unit_testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountTest {

    @Test
    public void myTest() {
        Account newAccount = new Account();
        assertFalse(newAccount.isActive(), "Check if account is not active"); //sprawdzenie czy prametr pokaże fase; sprawdzenie czy dla nowego konta prametr account jest false
    }

    @Test
    public void myTest2() {
        Account newAccount = new Account();
        assertFalse(newAccount.isActive(), "Check if account is not active");
        newAccount.activate();
        assertTrue(newAccount.isActive()); //sprawdzenie czy konto zostało aktywowane po wykonaniu metody activate()
    }

}