package StepsDefinitions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="classpath:features",
        glue="StepsDefinitions",
        monochrome = true,
        plugin = {"pretty",
                "html:target/cucumber-html-report.html",
                 "json:target/cucumber-report.json"})
public class TestRunner {    @BeforeClass
    public static void setup() {
        // Set up any other configurations you may need
    }

    @AfterClass
    public static void teardown() {

    }

}
