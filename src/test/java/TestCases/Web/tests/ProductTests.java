package TestCases.Web.tests;

import TestComponents.Web.WebBaseTest;
import org.testng.annotations.Test;
public class ProductTests extends WebBaseTest {

    @Test(description = "Test to verify add to cart")
    public void testToVerifyAddToCart() {
        testSteps.openingProduct();
        testSteps.clickingAddToCart();
        testSteps.checkingProductCount();
    }

    @Test(description = "Test to verify add to cart2")
    public void testToVerifyAddToCart2()  {
        testSteps.openingProduct();
        testSteps.clickingAddToCart2();
        testSteps.checkingProductCount();
    }
    @Test(description = "Test to verify add to cart")
    public void testToVerifyAddToCart3() {
        testSteps.openingProduct();
        testSteps.clickingAddToCart();
        testSteps.checkingProductCount();
    }

    @Test(description = "Test to verify add to cart2")
    public void testToVerifyAddToCart4()  {
        testSteps.openingProduct();
        testSteps.clickingAddToCart2();
        testSteps.checkingProductCount();
    }
}

