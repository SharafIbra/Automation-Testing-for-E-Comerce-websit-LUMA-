package EditAccountInformation;

import base.BaseTests;
import net.bytebuddy.build.Plugin;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class EditAccountInformationTests extends BaseTests {


    @Test   (priority = 4)
    void testChangePassword(){
        var log =homePage.clickLoginPage();
        log.setLoginCredentials(email,password);
        log.signIn();

        var edit =homePage.clickEditAccountPage();
        var change = edit.clickChangePassword();
        change.setCurrentPassword(password);
        //will work with the same password for no conflict
        change.setNewPassword(password);
        change.setConfirmNewPassword(confirm_password);
        change.save();
    }




    @Test   (priority = 3)
    void testChangeEmail(){
        var log =homePage.clickLoginPage();
        log.setLoginCredentials(email,password);
        log.signIn();

        var edit =homePage.clickEditAccountPage();

        var change = edit.clickChangeEmail();
        change.setChangeEmail(email);
        change.setCurrentPassword(password);
        change.save();

        String expectedStatus = "You saved the account information.";
        String actualStatus = change.getStatus();
        assertEquals(actualStatus,expectedStatus,"Password not changed");

    }

    @Test (priority = 1)
    void testAddNewAddress_DefaultAddress_FirstTime(){
        var log =homePage.clickLoginPage();
        log.setLoginCredentials(email,password);
        log.signIn();

        var edit =homePage.clickEditAccountPage();

        var Daddress = edit.clickAddDefaultAddresses();
        Daddress.setContactInformation(firstname,lastname,company,phone_number);
        Daddress.setStreetAddress(address1,address2,address3);
        Daddress.setCity(city);
        Daddress.setCountrydropdown(country);
        Daddress.setState(state);
        Daddress.setPostalCode(postalcode);
        Daddress.saveAddress();
        String expectedStatus = "You saved the address.";
        String actualStatus = Daddress.getStatus();
        assertEquals(actualStatus,expectedStatus,"Address not saved");
    }



    @Test   (priority = 2)
    void testAddNewAddress_IfCountryUSA(){
        var log =homePage.clickLoginPage();
        log.setLoginCredentials(email,password);
        log.signIn();

        var edit =homePage.clickEditAccountPage();

        var Naddress = edit.clickAddNewAddresses();
        Naddress.setContactInformation(firstname,lastname,company,phone_number);
        Naddress.setStreetAddress(address1,address2,address3);
        Naddress.setCity(city);
        Naddress.setCountrydropdown("United States");
        Naddress.setState_DROPDOWN("Alaska");
        Naddress.setPostalCode(postalcode);
        Naddress.saveAddress();
        String expectedStatus = "You saved the address.";
        String actualStatus = Naddress.getStatus();
        assertEquals(actualStatus,expectedStatus,"Address not saved");

    }





}
