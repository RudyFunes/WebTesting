package StepsDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.After;
import pages.mastodon.MastodonFlowPage;


public class MastodonStepDefs {
    private MastodonFlowPage GFlowPage;

    @Before
    public void setUp(){

        GFlowPage = new MastodonFlowPage();
    }

    @Given("browser launches successfully")
    public void browser_launches_successfully() {
        GFlowPage.launchBrowser();
    }

    @And("User enter {string}")
    public void enterSearchCriteria(String search) throws InterruptedException {
        Thread.sleep(5000);
        GFlowPage.enterSearchCriteria(search);

    }

    @And("{string} clicks stay signed out option")
    public void clearIframe(String arg0) {
        GFlowPage.resolveIFrame();
    }

    @Then("{string} clicks enter to begin search")
    public void clicksEnterToStartSearch(String arg0) {
        GFlowPage.startSearch();

    }

    @Then("Search is Verified {string}")
    public void searchIsVerified(String search) {
        GFlowPage.verifySearch(search);

    }
    @And("mastodon social option is click")
    public void mastodonSocialOptionIsClick() {
        GFlowPage.clickMastodonSocialOptionFromResults();

    }

    @And("Log in to mastodon {string} {string}")
    public void logInToMastodon(String arg0, String arg1) {
        GFlowPage.logInToMastodon();
    }

    @And("post something {string}")
    public void postSomething(String post) {
            GFlowPage.postSomething(post);
    }

    @And("user clicks on the profile image")
    public void userClicksOnTheProfileImage() {
        GFlowPage.clickProfileImage();
    }


   @And("site display the right {string}label")
    public void siteDisplayTheRightLabel( String username ) throws InterruptedException {
        GFlowPage.siteDisplayRightUsername(username);
    }

    @And("site display the right {string}")
    public void siteDisplayTheRight(String joinedDate) {
        GFlowPage.displayCorrectAccountCreationDate(joinedDate);
    }

    @Then("{string} clicks publish button")
    public void clicksPublishButton(String arg0) {
            GFlowPage.clicksPublishPost();
    }
    @Then("Post is deleted")
    public void postIsDeleted() throws InterruptedException {
       GFlowPage.deletePost();

    }
    @After
    public void quitTest(){
        //DriverSetup.quitDriver();
    }



}
