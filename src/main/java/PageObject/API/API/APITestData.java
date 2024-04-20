package PageObject.API.API;

import java.io.File;

public class APITestData {
    public static String apiDataFileLocation(String jsonFileName){
        return System.getProperty("user.dir") + File.separator + "src" + File.separator +  "main"+ File.separator + "resources"+ File.separator + "DataManagement"+ File.separator + "DataAPI"+ File.separator + jsonFileName;

    }

}
