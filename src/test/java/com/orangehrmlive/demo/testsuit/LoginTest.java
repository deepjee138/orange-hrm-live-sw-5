package com.orangehrmlive.demo.testsuit;

import com.orangehrmlive.demo.customelistners.CustomListeners;
import com.orangehrmlive.demo.pages.DashboardPage;
import com.orangehrmlive.demo.pages.HomePage;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class LoginTest extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;
    DashboardPage dashboardPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage = new LoginPage();
        homePage = new HomePage();
        dashboardPage = new DashboardPage();

    }

    @Test
    public void verifyUserShouldLoginSuccessFully() {

        // Enter username
        loginPage.enterUsername("Admin");


        // Enter password
        loginPage.enterPassword("admin123");


        // Click on Login Button
        loginPage.clickOnLoginButton();


        //  Verify "WelCome" Message


    }

    @Test
    public void verifyThatTheLogoDisplayOnHomePage() {

        //Login To The application
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickOnLoginButton();


        //Verify Logo is Displayed
        dashboardPage.clickOnUserProfileLogo();
        dashboardPage.clickOnLogoutButton();
    }

    @Test
    public void erifyUserShouldLogOutSuccessFully() {

        //Login To The application
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickOnLoginButton();


        // Click on User Profile logo
        dashboardPage.clickOnUserProfileLogo();

        //  Mouse hover on "Logout" and click
        dashboardPage.clickOnLogoutButton();

        // Verify the text "Login Panel" is displayed
    }


    @Test
    public void verifyErrorMessageWithInvalidCredentials(String username, String pwd, String errorMsg) {

        // Enter username <username>
        loginPage.loginToApp(username,pwd);



        // Verify Error message <errorMessage>

    }
}