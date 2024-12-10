package com.orangehrmlive.demo.pages;


import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement userNameField;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
    WebElement loginErrorMessage1;


    public void enterUsername(String value) {
        sendTextToElement(userNameField, value);
        Reporter.log("enter " + value);


    }

    public void enterPassword(String value) {
        sendTextToElement(passwordField, value);
        Reporter.log("enter " + value);

    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
        Reporter.log("click on " + loginButton);


    }

    public void loginToApp(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickOnLoginButton();
    }


}







