import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "StepDefinitions",
        plugin = { "pretty", "html:target/cucumber-reports","json:target/cucumber.json" },
        monochrome = true,
        tags = {""}

)
public class TestsRunner {
/*
    @AfterClass
    public static void importResultToXray() throws IOException, NoSuchAlgorithmException, KeyStoreException, InterruptedException, KeyManagementException {

        ImportResultToXray.ImportToXray();
    }
*/

}