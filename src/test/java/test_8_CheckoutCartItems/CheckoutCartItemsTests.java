package test_8_CheckoutCartItems;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class CheckoutCartItemsTests extends BaseTests {

    @Test
    void testCheckoutCartItems() {
        var log = p01HomePage.clickLoginPage();
        log.setLoginCredentials(email, password);
        log.signIn();

        var aitsc = p01HomePage.clickAddItemsToShoppingCart();
        var aitsc_wn = aitsc.clickNavigation_Men_Top_Jackets_AddItem();

        aitsc_wn.NavigationBar_addMultiItem_Men_Jackets(MenProduct);
        aitsc_wn.selectQuantity("2");
        aitsc_wn.selectSize(1);
        aitsc_wn.selectColour("Green");
        aitsc_wn.submitProductToCart();

        var checkout = p01HomePage.clickCheckoutCartItems();
        checkout.checkoutItemInCart();
        String actualStatus = checkout.getCurrentURL();
        /*String expectedStatus = "Thank you for your purchase!";*/

        assertTrue(actualStatus.contains("success"), "No item is purchased");

    }

}
