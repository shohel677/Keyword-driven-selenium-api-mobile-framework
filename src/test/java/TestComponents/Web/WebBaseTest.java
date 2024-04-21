package TestComponents.Web;


import PageObject.Web.LoginPage;
import TestCases.Web.steps.TestSteps;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import static AbstarctComponents.Web.GenericWebPage.getInstanceDriver;
import static AbstarctComponents.Web.GenericWebPage.instanceDriver;
import static DataLoader.TestEssentials.*;

public class WebBaseTest {
    public Logger logger = LogManager.getLogger(this.getClass());
    protected LoginPage loginPage;
    protected TestSteps testSteps;

    @BeforeMethod(alwaysRun=true)
    public void setup() {
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

}
