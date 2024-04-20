package PageObject.Web;

import AbstarctComponents.Web.GenericWebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

import static AbstarctComponents.Web.FrameworkAssertionLibrary.assertionShouldBeTrue;


public class LoginPage  extends GenericWebPage{
    private final static String loginXpath="//*[@id='%s']";


    private WebElement usernameField()  {
        WebElement username = getInstanceDriver().findElement(By.xpath(String.format(loginXpath,"user-name")));
        assertionShouldBeTrue(username.isDisplayed(),"Username field is displayed");
        return username;
    }
    private WebElement passwordField()  {
        WebElement password = getInstanceDriver().findElement(By.xpath(String.format(loginXpath,"password")));
        assertionShouldBeTrue(password.isDisplayed(),"Password field is displayed");
        return password;
    }
    private WebElement submitButton()  {
        WebElement submit = getInstanceDriver().findElement(By.xpath(String.format(loginXpath,"login-button")));
        assertionShouldBeTrue(submit.isDisplayed(),"Login button is displayed");
        return submit;
    }

    public void appAccess(String appAddress, String username, String password)  {
        getInstanceDriver().get(appAddress);
        logger.info("Open URL: " + appAddress);
        getInstanceDriver().manage().window().maximize();
        usernameField().sendKeys(username);
        logger.info("Enter username: "+username);
        passwordField().sendKeys(password);
        logger.info("Enter password: "+password);
        submitButton().click();
        logger.info("Click submit button");
    }

}
