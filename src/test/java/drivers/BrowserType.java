package drivers;

public enum BrowserType {

    FIREFOX("firefox"),
    CHROME("chrome"),
    MSE("edge");

    private final String browser;

    BrowserType(String browser){
        this.browser = browser;
    }
}
