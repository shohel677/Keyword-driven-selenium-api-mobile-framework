package TestCases.Web.steps;

import PageObject.Web.HomePage;
import TestComponents.Web.ApplicationWeb;

import static AbstarctComponents.Web.FrameworkAssertionLibrary.stepAssertionShouldBeTrue;

public class TestSteps extends ApplicationWeb {

    private final HomePage homePage = new HomePage();

    @Step("Open home page")
    public void openingProduct() {
        try{
            homePage.openProduct();
            stepAssertionShouldBeTrue(true, "Home page opened");
            logger.info("Clicked on product from home page");
        }catch (AssertionError | Exception ae){
            stepAssertionShouldBeTrue(false, "Home page is not opened");
        }
    }
    @Step("Click add to cart button")
    public void clickingAddToCart() {
        try{
            homePage.clickAddToCart();
            stepAssertionShouldBeTrue(true, "Add cart button is clicked");
            logger.info("Clicked add to cart button from product details page");
            }catch (AssertionError | Exception ae){
                stepAssertionShouldBeTrue(false, "Add cart button is not clicked");
        }
    }
    @Step("Click add to cart button")
    public void clickingAddToCart2() {
        try{
            homePage.clickAddToCart();
            stepAssertionShouldBeTrue(false, "Add cart button is clicked");
            logger.info("Clicked add to cart button from product details page");
            }catch (AssertionError | Exception ae){
                stepAssertionShouldBeTrue(false, "Add cart button is not clicked");
        }
    }
    @Step("Add product in cart icon")
    public void checkingProductCount() {
        try {
            homePage.checkProductCount();
            stepAssertionShouldBeTrue(true, "Product count updated on busket icon in homepage");
            logger.info("Product added on cart");
            }catch (AssertionError | Exception ae){
                stepAssertionShouldBeTrue(false, "Product count is not updated on busket icon in homepage");
            }
    }
}
