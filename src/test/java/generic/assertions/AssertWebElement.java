package generic.assertions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.AbstractAssert;
import org.openqa.selenium.WebElement;

public class AssertWebElement extends AbstractAssert<AssertWebElement,WebElement> {
    private Logger logger = LogManager.getLogger(AssertWebElement.class);

    public AssertWebElement(WebElement webElement){
        super(webElement,AssertWebElement.class);
    }

    public static AssertWebElement assertThat(WebElement webElement){
        return new AssertWebElement(webElement);
    }

    public AssertWebElement hasUserText(String expectedValue){
        logger.info("Checking if user was logging properly: " + expectedValue);
        isNotNull();

        String actualValue = actual.getText();
        if(!actualValue.equals(expectedValue)){
            failWithMessage("Element text was <%s> expecting to be <%s>!",actualValue,expectedValue);
        }
        logger.info("User logged properly!");
        return this;
    }
}
