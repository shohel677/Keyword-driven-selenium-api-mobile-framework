package AbstarctComponents.API;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class APIGenericPage {
    public Logger logger = LogManager.getLogger(this.getClass());
    private static final String BASE_URI = "https://dummy.restapiexample.com";
    //private static final String BASE_URI = appAddress;

    protected RequestSpecification getRequestSpecification() {
        return RestAssured.given()
                .baseUri(BASE_URI)
                .contentType("application/json");
//                .log().all();
    }
}

