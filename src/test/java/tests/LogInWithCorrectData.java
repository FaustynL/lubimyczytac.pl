package tests;

import org.testng.annotations.Test;
import page_objects.LoginPage;
import page_objects.MainPage;

import static org.testng.AssertJUnit.assertEquals;


public class LogInWithCorrectData extends TestBase {

    @Test
    public void logInWithCorrectData(){


        MainPage mainPage = new MainPage();
        mainPage.acceptCookies();
        mainPage.clickLogin();

        LoginPage loginPage = new LoginPage();
        loginPage.fillEmailInput("faustl91@gmail.com");
        loginPage.fillPasswordInput("Chrupkiajaxa1");
        loginPage.clickLoginButton();

        String userNick = mainPage.getUserNick();
        assertEquals("Check if user was logging properly", "FaauussT", userNick);



    }
}

