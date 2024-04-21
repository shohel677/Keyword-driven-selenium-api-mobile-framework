package PageObject.Web;

import AbstarctComponents.Web.GenericWebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static AbstarctComponents.Web.FrameworkAssertionLibrary.assertionShouldBeTrue;


public class LoginPage  extends GenericWebPage{
    private final static String loginXpath="//*[@id='%s']";


    private WebElement usernameField()  {
        WebElement username = getInstanceDriver().findElement(By.xpath(String.format(loginXpath,"user-name")));
        assertionShouldBeTrue(username.isDisplayed(),"Is username field displayed","Username field is displayed","Username field is not displayed");
        return username;
    }
    private WebElement passwordField()  {
        WebElement password = getInstanceDriver().findElement(By.xpath(String.format(loginXpath,"password")));
        assertionShouldBeTrue(password.isDisplayed(),"Is password field displayed","Password field is displayed","Password field is not displayed");
        return password;
    }
    private WebElement submitButton()  {
        WebElement submit = getInstanceDriver().findElement(By.xpath(String.format(loginXpath,"login-button")));
        assertionShouldBeTrue(submit.isDisplayed(),"Is login button displayed","Login button is displayed","Login button is not displayed");
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
