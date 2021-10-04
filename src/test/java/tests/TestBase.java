package tests;

import configuration.ConfigurationProperties;
import configuration.PropertiesLoader;
import driver.manager.DriverManager;
import driver.manager.DriverUtils;
import io.qameta.allure.Step;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.Properties;


public class TestBase {

    @Step("Loading configuration from configuration.properties")
    @BeforeClass
    public void beforeClass(){
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        Properties propertiesFromFile = propertiesLoader.getPropertiesFromFile("configuration.properties");
        ConfigurationProperties.setProperties(propertiesFromFile);
    }

    @Step("Setting up browser: {browserType} and open Home Page")
    @BeforeMethod
    public void beforeTest(){
        DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage(TestData.URL);
    }

    @Step("Closing browser")
    @AfterMethod
    public void afterTest() {
        DriverManager.disposeDriver();
    }
}
