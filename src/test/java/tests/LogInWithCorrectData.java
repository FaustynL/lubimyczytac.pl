package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import page_objects.LoginPage;
import page_objects.MainPage;

import static org.testng.AssertJUnit.assertEquals;

public class LogInWithCorrectData extends TestBase {

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
        String userNick = newMainPage.getUserNick();
        assertEquals("Check if user was logging properly", "FaauussT", userNick);

    }
}






