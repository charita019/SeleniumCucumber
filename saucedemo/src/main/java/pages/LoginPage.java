package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginBtn;

    @FindBy(css = "[data-test='error']")
    private WebElement errormessage;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUserName(String user){
        username.sendKeys(user);
    }

    public void enterPassword(String pass){
        password.sendKeys(pass);
    }

    public void clickOnLoginButton(){
        loginBtn.click();
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public String getErrorMessage(){
        return errormessage.getText();
    }
}
