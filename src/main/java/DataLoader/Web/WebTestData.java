package DataLoader.Web;

import java.io.File;

public class WebTestData {
    public static String webDataCSVLocation(String fileName){
        return System.getProperty("user.dir") + File.separator + "src" + File.separator +  "main"+ File.separator + "resources"+ File.separator + "DataManagement"+ File.separator + "DataWeb"+ File.separator + "DataCSV"+ File.separator + "testdata"+ File.separator + fileName;

    }
    public static String webFieldsCSVLocation(String fileName){
        return System.getProperty("user.dir") + File.separator + "src" + File.separator +  "main"+ File.separator + "resources"+ File.separator + "DataManagement"+ File.separator + "DataWeb"+ File.separator + "FieldsCSV"+ File.separator + "testdata"+ File.separator + fileName;

    }

}
