package test_8_CheckoutCartItems;

import Pages.P01_HomePage;
import Pages.P03_LoginPage;
import Pages.P07_AddItemsToShoppingCart_Functions;
import Pages.P08_CheckoutCartItems;
import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class CheckoutCartItemsTests extends BaseTests {

    @Test
    void testCheckoutCartItems() {
        new P01_HomePage(driver).clickLoginPage();
        new P03_LoginPage(driver)
                .setLoginCredentials(email, password)
                .signIn();


        if(!new P08_CheckoutCartItems(driver).validateIfCartContainProducts()) {
            new P01_HomePage(driver).clickAddItemsToShoppingCart().clickNavigation_Men_Top_Jackets_AddItem();
            new P07_AddItemsToShoppingCart_Functions(driver).NavigationBar_addMultiItem_Men_Jackets(MenProduct)
                    .selectQuantity("2")
                    .selectSize(1)
                    .selectColour("Green")
                    .submitProductToCart();
        }


            new P01_HomePage(driver).clickCheckoutCartItems();
            new P08_CheckoutCartItems(driver).checkOutItemInCart()
                    .validateOrderPlacedSuccessfully();



        /*String actualStatus = new P08_CheckoutCartItems(driver).getCurrentURL(driver);
        *//*String expectedStatus = "Thank you for your purchase!";*//*

        assertTrue(actualStatus.contains("success"), "No item is purchased");
*/
    }

}
