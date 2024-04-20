package test_7_AddItemsToShoppingCart;

import Pages.P01_HomePage;
import Pages.P07_AddItemsToShoppingCart_Functions;
import Pages.P07_AddItemsToShoppingCart_Options;
import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PurchasesOrder_WhatIsNew extends BaseTests {


    @Test (priority = 2)
    void test_AITSC_from_WhatIsNew() {

        new P01_HomePage(driver).clickAddItemsToShoppingCart();
        new P07_AddItemsToShoppingCart_Options(driver).clickWhatIsNew_NewInWomen_HoodiesSweatshirts_AddItem()
                .WhatsNew_addMultiItem_Women_HoodiesSweatshirts(WomenProduct)
                .selectQuantity("2")
                .selectSize(1)
                .selectColour("Green")
                .submitProductToCart();
        String actualStatus =new P07_AddItemsToShoppingCart_Functions(driver).verifyItemAddedToCart();
        String expectedStatus = "You added " + WomenProduct + " to your shopping cart.";
        assertEquals(actualStatus, expectedStatus, "Item not added to shopping cart.");

        /*
        var aitsc = new P01_HomePage(driver).clickAddItemsToShoppingCart();
        var aitsc_wn = aitsc.clickWhatIsNew_NewInWomen_HoodiesSweatshirts_AddItem();

        aitsc_wn.WhatsNew_addMultiItem_Women_HoodiesSweatshirts(WomenProduct);

        aitsc_wn.selectQuantity("2");
        aitsc_wn.selectSize(1);
        aitsc_wn.selectColour("Green");

        aitsc_wn.submitProductToCart();
        String actualStatus = aitsc_wn.verifyItemAddedToCart();
        String expectedStatus = "You added " + WomenProduct + " to your shopping cart.";
*/


    }




}
