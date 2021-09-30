package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    public static WebDriver getBrowser(BrowserType browserType){
        switch (browserType){
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
                return new ChromeDriver();
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "C:/drivers/geckodriver.exe");
                return new FirefoxDriver();
            case MSE:
                System.setProperty("webdriver.edge.driver", "C:/drivers/msedgedriver.exe");
                return new EdgeDriver();
            default:
                throw new IllegalStateException("Unknown browser type!");
        }
    }
}
