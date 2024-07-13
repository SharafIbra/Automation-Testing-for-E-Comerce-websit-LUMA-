package test_7_AddItemsToShoppingCart;

import Pages.P01_HomePage;
import Pages.P07_AddItemsToShoppingCart_Functions;
import Pages.P07_AddItemsToShoppingCart_Options;
import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PurchasesOrder_NavigationBar_ByAnonymousUser extends BaseTests {
    /*
     *       AITSC stands for Add Item To Shopping Cart
     * */


    @Test(priority = 1)
    void test_AITSC_from_NavigationBar() {

        new P01_HomePage(driver).clickAddItemsToShoppingCart();
        new P07_AddItemsToShoppingCart_Options(driver).clickNavigation_Men_Top_Jackets_AddItem()
                .NavigationBar_addMultiItem_Men_Jackets(MenProduct_jacket)
                .selectQuantity("2")
                .selectSize(1)
                .selectColour("Green")
                .submitProductToCart();
        String actualStatus = new P07_AddItemsToShoppingCart_Functions(driver).verifyItemAddedToCart();
        String expectedStatus = "You added " + MenProduct_jacket + " to your shopping cart.";
        assertEquals(actualStatus, expectedStatus, "Item not added to shopping cart.");


    }

    @Test(priority = 2)
    void test_AITSC_from_WhatIsNew() {

        new P01_HomePage(driver).clickAddItemsToShoppingCart();
        new P07_AddItemsToShoppingCart_Options(driver).clickWhatIsNew_NewInWomen_HoodiesSweatshirts_AddItem()
                .WhatsNew_addMultiItem_Women_HoodiesSweatshirts(WomenProduct)
                .selectQuantity("2")
                .selectSize(1)
                .selectColour("Green")
                .submitProductToCart();
        String actualStatus = new P07_AddItemsToShoppingCart_Functions(driver).verifyItemAddedToCart();
        String expectedStatus = "You added " + WomenProduct + " to your shopping cart.";
        assertEquals(actualStatus, expectedStatus, "Item not added to shopping cart.");

    }

}
