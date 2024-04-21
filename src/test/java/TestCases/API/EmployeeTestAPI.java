package TestCases.API;

import PageObject.API.ApiTestPage;
import TestComponents.API.ApiBaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

import static AbstarctComponents.Web.FrameworkAssertionLibrary.assertionShouldBeTrue;

public class EmployeeTestAPI extends ApiBaseTest {

    @Test(description = "Employee details API")
    public void verifyEmployeesDetails() {

        ApiTestPage testPageAPI = new ApiTestPage();

        Response response = testPageAPI.getEmployeesDetails();

        int responseCode = response.getStatusCode();
        assertionShouldBeTrue(responseCode==200,"Found Response code: "+responseCode);
        logger.info("Response code for employee list get request: "+responseCode);
        logger.info("Response header: " + response.getHeaders());
        logger.info("Response body: " + response.getBody().asString());

    }

    @Test(description = "Employee creation API")
    public void testToCreateEmployee() throws IOException {

        ApiTestPage userAPI = new ApiTestPage();
        Response response = userAPI.createEmployee();
        int responseCode = response.getStatusCode();
        assertionShouldBeTrue(responseCode==200,"Found Response code: "+responseCode);
        logger.info("Response code for employee creation post request: " + responseCode);
        logger.info("Response header: " + response.getHeaders());
        logger.info("Response body: " + response.getBody().asString());

    }
}

