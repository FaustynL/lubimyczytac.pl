package page_objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class LoginPage {

    Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//input[@id='Email']")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@id='Password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[contains(text(),'Zaloguj się')]")
    private WebElement loginButton;


    public LoginPage() {

        PageFactory.initElements(DriverManager.getWebDriver(), this);

    }

    /**
     * @fillEmailInput() method allows to fill in field with user's email.
     * @param email
     */
    public void fillEmailInput(String email) {
        WaitForElement.waitUntilElementIsVisible(emailInput);
        emailInput.sendKeys(email);
        logger.info("Field with email filled in");

    }

    /**
     * @fillPasswordInput() method allows to fill in field with user's password account.
     * @param password
     */
    public void fillPasswordInput(String password) {

        passwordInput.sendKeys(password);
        logger.info("Field with password filled in");

    }

    public void clickLoginButton() {

        loginButton.click();
        logger.info("Clicked log in button");

    }

}
