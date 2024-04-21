package TestComponents.API;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import static DataLoader.TestEssentials.propertyDataLoader;

public class ApiBaseTest {
    public Logger logger = LogManager.getLogger(this.getClass());
    @BeforeMethod
    public void APIEssential(ITestResult result) throws IOException {
        propertyDataLoader();
        logger.info("Starting testcase: " + result.getMethod().getMethodName());

    }
    @AfterMethod
    public void BeforeTearDown(ITestResult result) {
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
    }

}

