package introduction_to_unit_testing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    public void thatNewAccountShouldBeActiveAfterCreation() {
        //given + when
        Account newAccount = new Account();

        //then
        assertFalse(newAccount.isActive(), "Check if account is not active"); //sprawdzenie czy prametr pokaże fase; sprawdzenie czy dla nowego konta prametr account jest false
        assertThat(newAccount.isActive()).isFalse();
    }

    @Test
    public void thatNewAccountShouldBeActiveAfterActivation() {
        //given
        Account newAccount = new Account();

        //when
        newAccount.activate();

        //then
        assertTrue(newAccount.isActive()); //sprawdzenie czy konto zostało aktywowane po wykonaniu metody activate()
        assertThat(newAccount.isActive()).isTrue();
    }

    @Test
    public void thatNewNewCreatedAccountShouldNotHaveDefaultDeliveryAddressSet() {

        //given
        Account account = new Account();

        //when
        Address address = account.getDefaultDeliveryAddress();

        //then
        assertThat(address).isNull();

    }

    @Test
    public void thatDefaultDeliveryAddressShouldNotBeNullAfterBeingSet() {

        //given
        Address address = new Address("DragonBall", "4");
        Account account = new Account();
        account.setDefaultDeliveryAddress(address);

        //when
        Address defaultAddress = account.getDefaultDeliveryAddress();

        //then
        assertThat(defaultAddress).isNotNull();
    }


}