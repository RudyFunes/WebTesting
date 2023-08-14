package pages.mastodon;

import Setups.DriverSetup;
import Setups.WebElementPropertiesReader;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collections;
import java.util.List;

public class MastodonFlowPage {

    final private ChromeDriver driver;

    public MastodonFlowPage() {
        driver = DriverSetup.driverSetUp();
    }

    public void launchBrowser() {
        driver.get("https://www.google.com/");

    }

    public void enterSearchCriteria(String search) {
        driver.findElement(By.xpath((String) WebElementPropertiesReader.getWebElementsPath()
                .get("google.search.bar")))
                    .sendKeys(search);

    }

    public void resolveIFrame() {
        // Switch to the iframe by its ID or Name attribute
        // Replace "iframe_id_or_name" with the actual ID or Name of the iframe element
        driver.switchTo().frame("callout");

        driver.findElement(By.xpath((String)WebElementPropertiesReader.getWebElementsPath()
                        .get("google.iframe.staysignout.button")))
                .click();
        driver.switchTo().defaultContent();
    }
    public void startSearch() {
        driver.findElement(By.xpath((String) WebElementPropertiesReader.getWebElementsPath()
                        .get("google.search.bar")))
                .sendKeys(Keys.ENTER);
    }


    public void verifySearch(String search) {
        Assert.assertEquals(search, driver.findElement(By.xpath((String) WebElementPropertiesReader
              .getWebElementsPath()
              .get("google.search.bar")))
                  .getText());
    }


    public void clickMastodonSocialOptionFromResults() {
        driver.findElement(By.xpath((String) WebElementPropertiesReader.getWebElementsPath()
                .get("google.mastodon.search.result")))
                .click();
    }

    public void logInToMastodon() {
        driver.findElement(By.xpath((String) WebElementPropertiesReader.getWebElementsPath()
                .get("mastodon.email.input")))
                    .sendKeys(WebElementPropertiesReader
                            .getMastodonLogInCredentials()
                                .get(0));
        driver.findElement(By.xpath((String) WebElementPropertiesReader.getWebElementsPath()
                .get("mastodon.password.input")))
                    .sendKeys(WebElementPropertiesReader
                            .getMastodonLogInCredentials()
                                .get(1));
        driver.findElement(By.xpath((String) WebElementPropertiesReader.getWebElementsPath()
                .get("mastodon.submit.button")))
                    .click();

    }

    public void postSomething(String post) {
        driver.manage().deleteAllCookies();
        driver.findElement(By.xpath((String) WebElementPropertiesReader.getWebElementsPath()
                .get("mastodon.textarea.post")))
                .sendKeys(post);

    }
    public void clickProfileImage() {
        driver.findElement(By.xpath((String) WebElementPropertiesReader.getWebElementsPath()
                .get("mastodon.profile.image")))
                .click();
    }

    public void siteDisplayRightUsername(String username) throws InterruptedException {
        Thread.sleep(5000);
       driver.manage().deleteAllCookies();
       Assert.assertEquals( driver.findElement(By.xpath((String) WebElementPropertiesReader.getWebElementsPath()
               .get("mastodon.username.display"))).getText(),username);


    }

    public void displayCorrectAccountCreationDate(String joinedDate) {
        Assert.assertEquals( driver.findElement(By.xpath((String) WebElementPropertiesReader.getWebElementsPath()
                .get("mastodon.data.joined.display"))).getText(),joinedDate);

    }

    public void clicksPublishPost() {
       driver.findElement(By.xpath((String) WebElementPropertiesReader.getWebElementsPath()
                .get("mastodon.publish.button")))
                .click();


    }

    public void deletePost() throws InterruptedException {
        Thread.sleep(5000);

       //clicks the 3 dots to make the dropdown container appear
       driver.findElement(By.xpath((String) WebElementPropertiesReader.getWebElementsPath()
                            .get("mastodon.three.dots.dropdown.menu"))).click();
        Thread.sleep(3000);
       //use to scroll to teh button of the page
        driver.executeScript("window.scrollTo(0, document.body.scrollHeight);");


        List<WebElement>  dropdownElements = driver.findElements(By.xpath((String) WebElementPropertiesReader.getWebElementsPath()
               .get("mastodon.dropdown.menu.container")));

        for (WebElement elements :dropdownElements){
            if(elements.getText().equals("Delete")){
                elements.click();
                break;
            }
        }
        Thread.sleep(3000);
        driver.findElement(By.xpath((String) WebElementPropertiesReader.getWebElementsPath()
               .get("mastodon.delete.button")))
               .click();
    }

}
