package base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;

public class TestBase extends Configuration {

    @BeforeSuite(alwaysRun = true)
    public void setup() {
        RestAssured.baseURI = getProperties().getProperty("baseUrl");
    }
}
