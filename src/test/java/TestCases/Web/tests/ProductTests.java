package TestCases.Web.tests;

import TestComponents.Web.WebBaseTest;
import org.testng.annotations.Test;
public class ProductTests extends WebBaseTest {

    @Test(description = "Verify if home page is opened")
    public void testToVerifyHomepage() {
        testSteps.openingProduct();

    }

    @Test(description = "Test to verify add to cart")
    public void testToVerifyAddToCart()  {
        testSteps.openingProduct();
        testSteps.clickingAddToCart2();
    }
    @Test(description = "Test to verify product count")
    public void testToVerifyProductCount() {
        testSteps.openingProduct();
        testSteps.clickingAddToCart();
        testSteps.checkingProductCount();
    }


}

