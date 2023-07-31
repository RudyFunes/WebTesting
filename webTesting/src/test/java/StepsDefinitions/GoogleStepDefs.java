package StepsDefinitions;

import Setups.DriverSetup;
import Setups.WebElementPropertiesReader;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;


public class GoogleStepDefs {
    ChromeDriver driver;

    @Before
    public void setUp(){
      driver = DriverSetup.driverSetUp();
    }

    @Given("browser launches successfully")
    public void browser_launches_successfully() {
        driver.get("https://www.google.com/");
    }

    @And("User enter {string}")
    public void enterSearchCriteria(String search) {
        driver.findElement(By.xpath((String) WebElementPropertiesReader.getWebElementsPath()
                .get("google.search.bar")))
                    .sendKeys(search);
    }

    @And("{string} clicks stay signed out option")
    public void clearIframe(String arg0) {
        // Switch to the iframe by its ID or Name attribute
        // Replace "iframe_id_or_name" with the actual ID or Name of the iframe element
        driver.switchTo().frame("callout");

        driver.findElement(By.xpath((String)WebElementPropertiesReader.getWebElementsPath()
                .get("google.iframe.staysignout.button")))
                    .click();
        driver.switchTo().defaultContent();
    }

    @Then("{string} clicks enter to begin search")
    public void clicksEnterToStartSearch(String arg0) {
        driver.findElement(By.xpath((String) WebElementPropertiesReader.getWebElementsPath()
                .get("google.search.bar")))
                    .sendKeys(Keys.ENTER);
    }

    @Then("Search is Verified {string}")
    public void searchIsVerified(String search) {
        Assert.assertEquals(search, driver.findElement(By.xpath((String) WebElementPropertiesReader
              .getWebElementsPath()
              .get("google.search.bar")))
                  .getText());
    }

    @After
    public void quitTest(){
        if (driver != null) {
            driver.quit();
        }
    }
}
