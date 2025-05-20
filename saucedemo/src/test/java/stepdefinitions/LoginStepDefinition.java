package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginStepDefinition {

    WebDriver driver;
    LoginPage loginPage;

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

    @When("User enters valid username {string}")
    public void user_enters_valid_username(String string) {
        loginPage.enterUserName("standard_user");
    }

    @When("User enters valid password {string}")
    public void user_enters_valid_password(String string) {
        loginPage.enterPassword("secret_sauce");
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
}
