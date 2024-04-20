package AbstarctComponents.Web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.io.IOException;
import static DataLoader.TestEssentials.browserName;
import static DataLoader.TestEssentials.propertyDataLoader;


public class GenericWebPage  {
    public static WebDriver instanceDriver;

    public static WebDriver getInstanceDriver() {
        propertyDataLoader();
        if (instanceDriver == null) {
            if (browserName.contains("chrome")) {
                ChromeOptions options = new ChromeOptions();
                WebDriverManager.chromedriver().setup();
                if (browserName.contains("headless")) {
                    options.addArguments("headless");
                }
                instanceDriver = new ChromeDriver(options);
            } else if (browserName.contains("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                instanceDriver = new FirefoxDriver();
            } else if (browserName.contains("edge")) {
                WebDriverManager.edgedriver().setup();
                instanceDriver = new EdgeDriver();
            } else if (browserName.contains("safari")) {
                WebDriverManager.safaridriver().setup();
                instanceDriver = new SafariDriver();
            }

        }
        return instanceDriver;
    }
    public Logger logger = LogManager.getLogger(this.getClass());


}

