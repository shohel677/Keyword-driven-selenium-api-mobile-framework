package PageObject.API;

import AbstarctComponents.API.APIGenericPage;
import io.restassured.response.Response;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static AbstarctComponents.API.Endpoints.createEmployeeEndpoint;
import static AbstarctComponents.API.Endpoints.getEmployeeEndpoint;
import static PageObject.API.API.APITestData.apiDataFileLocation;


public class TestPageAPI extends APIGenericPage {

    public Response getEmployeesDetails() {
        logger.info("Get request for employee list");
        return getRequestSpecification()
                .when()
                .get(getEmployeeEndpoint)
                .then()
                .extract()
                .response();
    }

    public Response createEmployee() throws IOException {

        String jsonBody = new String(Files.readAllBytes(Paths.get(apiDataFileLocation("createEmployee.json"))));

        logger.info("Post request for employee creation");
        return getRequestSpecification()
                .body(jsonBody)
                .when()
                .post(createEmployeeEndpoint)
                .then()
                .extract()
                .response();
    }
}
