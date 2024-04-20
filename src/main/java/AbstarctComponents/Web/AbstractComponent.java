package AbstarctComponents.Web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponent  extends GenericWebPage {

    public static WebElement waitUntilVisible(int numberOfSecond, String  stringXpath){
        WebDriverWait wait = new WebDriverWait(instanceDriver, Duration.ofSeconds(numberOfSecond));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(stringXpath)));
    }
    public static WebElement waitUntilVisible(String stringXpath){
        WebDriverWait wait = new WebDriverWait(instanceDriver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(stringXpath)));
    }
    public static void waitUntilInvisible(String stringXpath){
        WebDriverWait wait = new WebDriverWait(instanceDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(stringXpath)));
    }
    public static void waitUntilInvisible(int numberOfSecond, String stringXpath){
        WebDriverWait wait = new WebDriverWait(instanceDriver, Duration.ofSeconds(numberOfSecond));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(stringXpath)));
    }
    public static WebElement waitUntilElementToBeClickable(int numberOfSecond, String stringXpath){
        WebDriverWait wait = new WebDriverWait(instanceDriver, Duration.ofSeconds(numberOfSecond));
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(stringXpath)));
    }
    public static WebElement waitUntilVisibleOf(int numberOfSecond, String  stringXpath){
        WebDriverWait wait = new WebDriverWait(instanceDriver, Duration.ofSeconds(numberOfSecond));
        return wait.until(ExpectedConditions.visibilityOf(getInstanceDriver().findElement(By.xpath(stringXpath))));
    }


}
