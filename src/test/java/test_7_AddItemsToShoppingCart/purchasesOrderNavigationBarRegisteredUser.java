package test_7_AddItemsToShoppingCart;

import Pages.P01_HomePage;
import Pages.P07_AddItemsToShoppingCart_Functions;
import Pages.P07_AddItemsToShoppingCart_Options;
import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class purchasesOrderNavigationBarRegisteredUser extends BaseTests {


    @Test(priority = 1)
    void test_AITSC_from_NavigationBar_RegisteredUser() {

        new P01_HomePage(driver)
                .bypassLoginHomepage()
                .clickAddItemsToShoppingCart();
        new P07_AddItemsToShoppingCart_Options(driver).clickNavigation_Men_Top_Jackets_AddItem()
                .NavigationBar_addMultiItem_Men_Jackets(MenProduct_jacket)
                .selectQuantity("2")
                .selectSize(1)
                .selectColour("Green")
                .submitProductToCart()
                .verifyItemAddedToCart(MenProduct_jacket);



    }


    @Test(priority = 1)
    void test_Add_Many_ITSC_from_NavigationBar_RegisteredUser() {

        new P01_HomePage(driver)
                .bypassLoginHomepage()
                .clickAddItemsToShoppingCart();

        /*add first product*/
        new P07_AddItemsToShoppingCart_Options(driver).clickNavigation_Men_Top_Jackets_AddItem()
                .NavigationBar_addMultiItem_Men_Jackets(MenProduct_jacket)
                .selectQuantity("2")
                .selectSize(1)
                .selectColour("Green")
                .submitProductToCart()
                .verifyItemAddedToCart(MenProduct_jacket);

        /*add second product*/
        new P07_AddItemsToShoppingCart_Options(driver).clickWhatIsNew_NewInWomen_HoodiesSweatshirts_AddItem()
                .WhatsNew_addMultiItem_Women_HoodiesSweatshirts(WomenProduct)
                .selectQuantity("2")
                .selectSize(1)
                .selectColour("Green")
                .submitProductToCart()
                .verifyItemAddedToCart(MenProduct_jacket);



    }



}
