package page_objects;

import driver.manager.DriverManager;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class LoginPage {

    Logger logger = LogManager.getLogger(LoginPage.class);

    @FindBy(xpath = "//input[@id='Email']")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@id='Password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@class=\"btn btn-primary\"]")
    private WebElement loginButton;


    public LoginPage() {

        PageFactory.initElements(DriverManager.getWebDriver(), this);

    }

    /**
     * @fillEmailInput() method allows to fill in field with user's email.
     * @param email
     */
    @Step("Filling in user email field: {email}")
    public LoginPage fillEmailInput(String email) {
        WaitForElement.waitUntilElementIsVisible(emailInput);
        emailInput.sendKeys(email);
        logger.info("Filled in with user's email: {}", email);
        return this;

    }

    /**
     * @fillPasswordInput() method allows to fill in field with user's password account.
     * @param password
     */
    @Step("Filling in user password field: {password}")
    public LoginPage fillPasswordInput(String password) {
        WaitForElement.waitUntilElementIsVisible(passwordInput);
        passwordInput.sendKeys(password);
        logger.info("Filled in with password: {} ", password);
        return this;

    }
    @Step("Submiting log in button")
    public MainPage clickLoginButton() {

        loginButton.click();
        logger.info("Clicked log in button");
        return new MainPage();

    }

}
