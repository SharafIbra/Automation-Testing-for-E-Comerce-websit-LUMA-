package HomePage;

import base.BaseTests;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTests {



    @Test
    void testCreateAcount(){
        homePage.clickCreateAcountPage();

    }
    @Test
    void testSignIn(){
        homePage.clickLoginPage();
    }
}
