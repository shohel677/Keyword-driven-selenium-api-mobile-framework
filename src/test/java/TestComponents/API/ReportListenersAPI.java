package TestComponents.API;

import AbstarctComponents.Web.FrameworkAssertionLibrary;
import TestComponents.Web.ApplicationWeb;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import Utils.APIExtentReporterNG;

import java.util.List;


public class ReportListenersAPI extends ApplicationWeb implements ITestListener{
	ExtentTest test;
	ExtentReports extent = APIExtentReporterNG.getReportObject();
	static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); //Thread safe
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);//unique thread id(ErrorValidationTest)->test
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		assertionAdd().clear();
		extentTest.get().log(Status.PASS, "Test Passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		assertionAdd().clear();
		extentTest.get().fail(result.getThrowable());//

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();

	}

	public static List<FrameworkAssertionLibrary.AssertionInfo> assertionAdd(){
		List<FrameworkAssertionLibrary.AssertionInfo> allAssertions = FrameworkAssertionLibrary.getAllAssertions();
		for (FrameworkAssertionLibrary.AssertionInfo assertion : allAssertions) {
			String status = assertion.getStatus() ? "Pass" : "Fail";
			String message = "Step: " + status + " - " + assertion.getMessage();
			System.out.println(message);
			if (extentTest.get() != null) {
				if (assertion.getStatus()) {
					extentTest.get().log(Status.PASS, message);
				} else {
					extentTest.get().log(Status.FAIL, message);
				}
			}
		}
		return allAssertions;
	}




}
