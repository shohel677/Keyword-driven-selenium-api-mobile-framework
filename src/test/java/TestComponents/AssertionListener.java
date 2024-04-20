package TestComponents;

import AbstarctComponents.Web.FrameworkAssertionLibrary;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import Utils.WebExtentReporterNG;

import java.util.List;

public class AssertionListener implements ITestListener {

    ExtentTest test;
    ExtentReports extent = WebExtentReporterNG.getReportObject();

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test Finished: " + context.getName());

        // Get the list of all assertions made during the test
        List<FrameworkAssertionLibrary.AssertionInfo> allAssertions = FrameworkAssertionLibrary.getAllAssertions();
        System.out.println(allAssertions);
        // Print or process all assertions with pass/fail status
        for (FrameworkAssertionLibrary.AssertionInfo assertion : allAssertions) {
            String status = assertion.getStatus() ? "Pass" : "Fail";
            String message = "STEP: " + status + " - " + assertion.getMessage();
            System.out.println(message);
            if (test != null) {
                if (assertion.getStatus()) {
                    test.log(Status.PASS, message);
                } else {
                    test.log(Status.FAIL, message);
                }
            }
        }
        if (test != null) {
            extent.flush();
        }
    }
}

