package test_7_AddItemsToShoppingCart;

import Pages.P01_HomePage;
import Pages.P07_AddItemsToShoppingCart_Functions;
import Pages.P07_AddItemsToShoppingCart_Options;
import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PurchasesOrder_NavigationBar extends BaseTests {
    @Test(priority = 1)
    void test_AITSC_from_NavigationBar() {

        new P01_HomePage(driver).clickAddItemsToShoppingCart();
        new P07_AddItemsToShoppingCart_Options(driver).clickNavigation_Men_Top_Jackets_AddItem()
                .NavigationBar_addMultiItem_Men_Jackets(MenProduct)
                .selectQuantity("2")
                .selectSize(1)
                .selectColour("Green")
                .submitProductToCart();
        String actualStatus =new P07_AddItemsToShoppingCart_Functions(driver).verifyItemAddedToCart();
        String expectedStatus = "You added " + MenProduct + " to your shopping cart.";
        assertEquals(actualStatus, expectedStatus, "Item not added to shopping cart.");


/*
        var aitsc_wn = new P01_HomePage(driver).clickAddItemsToShoppingCart().clickNavigation_Men_Top_Jackets_AddItem();

        aitsc_wn.NavigationBar_addMultiItem_Men_Jackets(MenProduct);
        aitsc_wn.selectQuantity("2");
        aitsc_wn.selectSize(1);
        aitsc_wn.selectColour("Green");

        aitsc_wn.submitProductToCart();
        String actualStatus = aitsc_wn.verifyItemAddedToCart();
        String expectedStatus = "You added " + MenProduct + " to your shopping cart.";


        assertEquals(actualStatus, expectedStatus, "Item not added to shopping cart.");
*/

    }



}
