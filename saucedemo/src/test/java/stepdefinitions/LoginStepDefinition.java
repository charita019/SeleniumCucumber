package stepdefinitions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginStepDefinition {

    WebDriver driver;
    LoginPage loginPage;
    Actions actions;

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        actions = new Actions(driver);
    }

    @When("User enters valid username {string}")
    public void user_enters_valid_username(String usernm) {
        loginPage.enterUserName(usernm);
    }

    @When("User enters valid password {string}")
    public void user_enters_valid_password(String pass) {
        loginPage.enterPassword(pass);
    }

    @When("User clicks on Login Button")
    public void user_clicks_on_login_button() {
        loginPage.clickOnLoginButton();
    }

    @Then("User is navigated to Swag Labs page")
    public void user_is_navigated_to_swag_labs_page() {
        String currenturl = loginPage.getCurrentUrl();
        Assert.assertTrue(currenturl.contains("inventory.html"));
        driver.quit();
    }

    @When("User enters invalid username {string}")
    public void user_enters_invalid_username(String usernm){
        loginPage.enterUserName(usernm);
    }

    @When("User enters invalid password {string}")
    public void user_enters_invalid_password(String pass){
        loginPage.enterPassword(pass);
    }

    @Then("User is not logged in and gets message as {string}")
    public void user_is_not_logged_in_and_gets_message_as(String expectedmessage){
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertEquals(actualMessage.trim(), expectedmessage.trim(), "Actual Message is not same as Expected Message");
        driver.quit();
    }

    @When("User enters lockedout username {string}")
    public void user_enters_lockedout_username(String usernm){
        loginPage.enterUserName(usernm);
    }

    @When("User does not enter any credentials")
    public void user_does_not_enter_any_credentials(){
        //intentially leave field blank
    }

    @When("User leave password field blank")
    public void user_leave_password_field_blank(){
        //intentionally leave password field as blank
    }

    @Then("User is not logged in and gets required field validation {string}")
    public void user_is_not_logged_in_and_gets_required_field_validation(String expectedMessage){
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertEquals(actualMessage, expectedMessage, "Required Message is not coming correctly");
        driver.quit();
    }

    @When("User presses TAB key")
    public void user_presses_tab_key(){
        actions.sendKeys(Keys.TAB).perform();
    }

    @When("User presses ENTER key")
    public void user_presses_enter_key(){
        actions.sendKeys(Keys.ENTER).perform();
    }
}
