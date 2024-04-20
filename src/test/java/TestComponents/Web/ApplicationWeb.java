package TestComponents.Web;


import PageObject.Web.HomePage;
import PageObject.Web.LoginPage;
import TestCases.Web.steps.TestSteps;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import static AbstarctComponents.Web.GenericWebPage.*;
import static DataLoader.TestEssentials.*;

public class ApplicationWeb {
    public Logger logger = LogManager.getLogger(this.getClass());
    //public WebDriver driver;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected TestSteps testSteps;

    @BeforeMethod(alwaysRun=true)
    public void setup() throws IOException {
        getInstanceDriver();
        loginPage = new LoginPage();
        testSteps = new TestSteps();
        loginPage.appAccess(appAddress, userName, passWord);
    }

    @AfterMethod(alwaysRun=true)
    public void tearDown(ITestResult result) throws IOException {
        int status = result.getStatus();
        String testDescription = result.getMethod().getDescription();

        if (status == ITestResult.SUCCESS) {
            logger.info("'" + testDescription + "' is successfully passed");
        } else if (status == ITestResult.FAILURE) {
            logger.info("'" + testDescription + "' failed");
        } else if (status == ITestResult.SKIP) {
            logger.info("'" + testDescription + "' is skipped");
        }

        logger.info("---------------------------------------------------");

        if (instanceDriver == null) {
            return;
        }
        instanceDriver.quit();
        instanceDriver = null;
    }
//    private void initializePage() {
//        loginPage = new LoginPage(driver);
//        homePage = new HomePage(driver);
//        testSteps = new TestSteps(homePage);
//    }
}
