package com.orangehrmlive.demo.pages;


import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class DashboardPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
    WebElement userProfileLogo;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Logout']")
    WebElement logoutButton;

    public void clickOnUserProfileLogo() {
        clickOnElement(userProfileLogo);
        Reporter.log("click on " + userProfileLogo);


    }

    public void clickOnLogoutButton() {
        clickOnElement(logoutButton);
        Reporter.log("click on " + logoutButton);

    }
}
