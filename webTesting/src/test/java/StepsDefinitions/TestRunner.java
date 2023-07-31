package StepsDefinitions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="classpath:features",
        glue="StepsDefinitions",
        monochrome = true,
        plugin = {"html:target/selenium-reports","pretty"})
public class TestRunner {

}
