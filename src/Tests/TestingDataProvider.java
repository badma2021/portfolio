package Tests;

import Utils.JSON_Reader;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;


import java.io.IOException;

public class TestingDataProvider {
    @DataProvider(name = "registration data")
    public Object[][] passData() throws IOException, ParseException {

        return JSON_Reader.getData("src/Tests/Testing_data.json", "Registration data", 7);
    }


}
