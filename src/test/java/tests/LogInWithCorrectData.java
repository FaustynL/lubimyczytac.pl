package tests;

import org.testng.annotations.Test;
import page_objects.LoginPage;
import page_objects.MainPage;

import static org.testng.AssertJUnit.assertEquals;

public class LogInWithCorrectData extends TestBase {

    @Test
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






