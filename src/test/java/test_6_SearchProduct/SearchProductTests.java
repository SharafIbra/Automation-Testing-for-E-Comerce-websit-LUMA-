package test_6_SearchProduct;

import Pages.P01_HomePage;
import Pages.P06_SearchProduct;
import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SearchProductTests extends BaseTests {
    @Test(description = "")
    void testSearchProduct() {

        String product = "shirts";
        new P01_HomePage(driver).clickSearchProduct();
        new P06_SearchProduct(driver).enterProductName(product);
        String actualstatus = new P06_SearchProduct(driver).getStatus();
        assertTrue(actualstatus.contains(product), "test False");
    }
}
