package TestCases.API;

import PageObject.API.TestPageAPI;
import TestComponents.API.ApplicationAPI;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

import static AbstarctComponents.Web.FrameworkAssertionLibrary.assertionShouldBeTrue;

public class EmployeeTestAPI extends ApplicationAPI {

    @Test(description = "Employee details API")
    public void verifyEmployeesDetails() {

        TestPageAPI testPageAPI = new TestPageAPI();

        Response response = testPageAPI.getEmployeesDetails();

        int responseCode = response.getStatusCode();
        assertionShouldBeTrue(responseCode==200,"Found Response code: "+responseCode);
        logger.info("Response code for employee list get request: "+responseCode);
        logger.info("Response header: " + response.getHeaders());
        logger.info("Response body: " + response.getBody().asString());

    }

    @Test(description = "Employee creation API")
    public void testToCreateEmployee() throws IOException {

        TestPageAPI userAPI = new TestPageAPI();
        Response response = userAPI.createEmployee();
        int responseCode = response.getStatusCode();
        assertionShouldBeTrue(responseCode==200,"Found Response code: "+responseCode);
        logger.info("Response code for employee creation post request: " + responseCode);
        logger.info("Response header: " + response.getHeaders());
        logger.info("Response body: " + response.getBody().asString());

    }
}

