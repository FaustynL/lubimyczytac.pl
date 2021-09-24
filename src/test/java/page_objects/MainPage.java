package page_objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;


/**
 * Class page_objects.MainPage is handling main page of lubimyczytac.pl appliaction.
 */
public class MainPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//*[@id='onetrust-accept-btn-handler']")
    private WebElement cookiesInfo;

    @FindBy(xpath = "//header//div/a[contains(text(),'Zaloguj się')]")
    private WebElement clickLogin;

    @FindBy(xpath = "//span[@class='d-none d-lg-inline']" )
    private WebElement user;


    public MainPage() {

        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }

    public void acceptCookies(){
        WaitForElement.waitUntilElementIsClickable(cookiesInfo);
        cookiesInfo.click();
        logger.info("Accepted cookies.");
    }

    /**
     * @clickLogin() method allows to click log in button on the main page, which is redirecting to login form.
     */
    public  void clickLogin() {

        clickLogin.click();
        logger.info("Clicked on log in link.");

    }

    public String getUserNick() {
        WaitForElement.waitUntilElementIsVisible(user);
        String userNick = user.getText();
        logger.info("Got user's nick");
        return userNick;
    }
}