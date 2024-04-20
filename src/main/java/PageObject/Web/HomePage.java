package PageObject.Web;

import AbstarctComponents.Web.GenericWebPage;
import Utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

public class HomePage  extends GenericWebPage{

    private final static String productXpath = "//a/div[normalize-space()='%s']";
    private final static String pageAddToCartXpath = "//button[normalize-space()='%s]";
    private final static String productCountXPath = "//a/span[@class='shopping_cart_badge']";
    private enum locationText {
        PRODUCT("Sauce Labs Backpack"),
        ADD_TO_CART("Add to cart'");
        private final String text;
        locationText(String text){
            this.text = text;

        }
    }

    public void openProduct() {
        WaitUtil.waitFor(3000);
        WebElement productName = getInstanceDriver().findElement(By.xpath(String.format(productXpath, locationText.PRODUCT.text)));
        logger.info("Clicking on product from homepage"+productName.getText());
        productName.click();

    }
    public void clickAddToCart()  {
        WaitUtil.waitFor(3000);
       logger.info("Clicking add to cart button from product details page");
        getInstanceDriver().findElement(By.xpath(String.format(pageAddToCartXpath, locationText.ADD_TO_CART.text))).click();
    }
    public void checkProductCount()  {
        WaitUtil.waitFor(3000);
        boolean isProduct =  getInstanceDriver().findElement(By.xpath(productCountXPath)).isDisplayed();
        logger.info("Asserting if product added number text visible on top tooltip");
        Assert.assertTrue(isProduct, "Is product count visible");
        logger.info("Product added number text visible on top tooltip");
    }


}
