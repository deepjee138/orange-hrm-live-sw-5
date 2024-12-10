package com.orangehrmlive.demo.testsuit;

import com.orangehrmlive.demo.pages.*;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.testdata.TestData;

public class UsersTest extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;
    AdminPage adminPage;
    AddUserPage addUserPage;
    ViewSystemUsersPage viewSystemUsersPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage = new LoginPage();
        homePage = new HomePage();
        adminPage = new AdminPage();
        addUserPage = new AddUserPage();
        viewSystemUsersPage = new ViewSystemUsersPage();

    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void adminShouldAddUserSuccessFully() {

        // Login to Application
        loginPage.loginToApp("Admin", "admin123");


        // click On "Admin" Tab
        homePage.clickOnAdminTab();

        // Verify "System Users" Text

        // click On "Add" button
        adminPage.clickOnAddButton();

        // Verify "Add User" Text
        // Assert.assertEquals(addUserPage.getAddUserText(), "Add User");

        // Select User Role "Admin"
        addUserPage.clickOnRoleDropdown();              //expand dropdown
        addUserPage.selectAdminRoleFromDropdown();

        // enter Employee Name "Ananya Dash"

        //        addUserPage.enterEmpName("Ananya Dash");

        // enter Username
        addUserPage.enterUserName("Rangrani");
        addUserPage.selectStatusDropdown();

        // Select status "Disable"
        addUserPage.selectDisabledStatusFromDropdown();
        // enter psaaword
        addUserPage.enterPassword("prime1234");
        // enter Confirm Password
        addUserPage.enterConfirmPassword("prime1234");
        // click On "Save" Button
        addUserPage.clickOnSaveButton();

        // verify message "Successfully Saved"

    }

    @Test(groups = {"smoke", "regression"})
    public void searchTheUserCreatedAndVerifyIt() {

        //Login to Application
        loginPage.loginToApp("Admin", "admin123");

        // click On "Admin" Tab
        homePage.clickOnAdminTab();

        // Verify "System Users" Text
// Assert.assertEquals(addUserPage.getAddUserText(), "Add User");

        // Enter Username

        addUserPage.enterUserName("Rangrani");


        // Select User Role
        addUserPage.clickOnRoleDropdown();

        // Select Satatus
        addUserPage.selectStatusDropdown();

        // Click on "Search" Button


        // Verify the User should be in Result list
        viewSystemUsersPage.enterUsername("Admin");
        viewSystemUsersPage.clickOnRoleDropdown();
        viewSystemUsersPage.selectRoleFromDropdown("Admin");
        viewSystemUsersPage.selectStatusDropdown();
        viewSystemUsersPage.selectStatusFromDropdown("Enabled");
        viewSystemUsersPage.clickOnSearchButton();
//        List<String> userDetail = viewSystemUsersPage.getUserDetails();
//        Assert.assertEquals(userDetail.get(1),"Admin");
//        Assert.assertEquals(userDetail.get(2),"Admin");
//        Assert.assertEquals(userDetail.get(4),"Enabled");

    }

    @Test(groups = {"regression"})
    public void verifyThatAdminShouldDeleteTheUserSuccessFully() {

        // Login to Application
        loginPage.loginToApp("Admin", "admin123");
        // click On "Admin" Tab
        homePage.clickOnAdminTab();
        // Verify "System Users" Text
// Assert.assertEquals(addUserPage.getAddUserText(), "Add User");
        // Enter Username
        addUserPage.enterUserName("Rangrani");
        // Select User Role
        addUserPage.clickOnRoleDropdown();

        // Select Satatus
        addUserPage.selectStatusDropdown();
        // Click on "Search" Button

        // Verify the User should be in Result list.
        viewSystemUsersPage.enterUsername("Rangrani");
        viewSystemUsersPage.clickOnRoleDropdown();
        viewSystemUsersPage.selectRoleFromDropdown("Admin");
        viewSystemUsersPage.selectStatusDropdown();
        viewSystemUsersPage.selectStatusFromDropdown("Enabled");
        viewSystemUsersPage.clickOnSearchButton();
        // Click on Check box
        viewSystemUsersPage.clickOnSelectUserCheckbox();
        // Click on Delete Button
        viewSystemUsersPage.clickOnDeleteUserButton();
        // Popup will display
        viewSystemUsersPage.clickOnYesDeleteButton();

        // Click on Ok Button on Popup

        // verify message "Successfully Deleted"
        //Assert.assertEquals(viewSystemUsersPage.getSuccessDeleteToasterMsg(), "Successfully Deleted");
    }

    @Test(groups = {"regression"}, dataProvider = "searchUserData", dataProviderClass = TestData.class)
    public void searchTheUserAndVerifyTheMessageRecordFound(String username, String role, String empName, String status) {

        // Login to Application
        loginPage.loginToApp("Admin", "admin123");

        //click On "Admin" Tab
        homePage.clickOnAdminTab();

        // Verify "System Users" Text

       // Assert.assertEquals(adminPage.getSystemUsersText(), "System Users");
        // Enter Username <username>

        viewSystemUsersPage.enterUsername(username);
        //   Select User Role <userRole>
        viewSystemUsersPage.clickOnRoleDropdown();

        //    Enter EmployeeName <employeeName>
        viewSystemUsersPage.selectRoleFromDropdown(role);

        // Select Satatus <status>
        viewSystemUsersPage.selectStatusFromDropdown(status);


        //  Click on "Search" Button

        viewSystemUsersPage.clickOnSearchButton();
        // verify message "(1) Record Found"

       // Assert.assertEquals(viewSystemUsersPage.getRecordFoundText(), "(1) Record Found");
       // Assert.assertEquals(viewSystemUsersPage.getUsernameText(), username);
        // Verify username <username>


        //  Click on Reset Tab
        viewSystemUsersPage.clickOnResetButton();
    }
}