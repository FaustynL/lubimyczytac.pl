package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import page_objects.LoginPage;
import page_objects.MainPage;

public class LogInWithCorrectData extends TestBase {


    @Severity(SeverityLevel.CRITICAL)
    @Test
    @Description("The goal of test is to log in using proper credentials and check if user's nick is displayed in " +
            "top menu")
    public void logInWithCorrectData() {


        MainPage mainPage = new MainPage();
        mainPage
                .acceptCookies()
                .clickOnLogIn();

        LoginPage loginPage = new LoginPage();
        loginPage
                .fillEmailInput("faustl91@gmail.com")
                .fillPasswordInput("Chrupkiajaxa1")
                .clickLoginButton();

        MainPage newMainPage = new MainPage();
        newMainPage
                .assertTextInUserNick("Nuubek");

    }
}






