package test_5_EditAccountAddresses;

import Pages.P01_HomePage;
import Pages.P03_LoginPage;
import Pages.P04and5_EditAccountInformation___pages;
import Pages.P05_AddDefaultAddresses;
import base.BaseTests;
import org.testng.annotations.Test;

public class AddDefaultAddressesTests extends BaseTests {
    @Test(priority = 1)
    void testAddNewAddress_DefaultAddress() {
        new P01_HomePage(driver).clickLoginPage();
        new P03_LoginPage(driver)
                .setLoginCredentials(email, password)
                .signIn();

        new P01_HomePage(driver).clickEditAccountPage();

        new P04and5_EditAccountInformation___pages(driver).clickAddDefaultAddresses();
        new P05_AddDefaultAddresses(driver)
                .setContactInformation(firstname, lastname, company, phone_number)
                .setStreetAddress(address1, address2, address3)
                .setCity(city)
                .setCountrydropdown(country)
                .setState(state)
                .setPostalCode(postalcode)
                .saveAddress()
                .verifyAddressAdded();

    }
}
