package resources.testdata;

import org.testng.annotations.DataProvider;

/**
 * Created by Jay Vaghani
 */
public class TestData {


    @DataProvider(name = "searchUserData")
    public Object[][] getBuildComData() {
        Object[][] data = new Object[][]{
                {"Aman gupta", "Admin", "Test Tester", "Enabled"},
//                {"FMLName1", "ESS", "FName LName", "Disabled"},
        };
        return data;
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        Object[][] data = new Object[][]{
//                {"", "", "Required"},
//                {"test123@gmail.com", "", "Required"},
//                {"", "test123 ", "Required"},
                {"test123@gmail.com", "test123 ", "Invalid credentials"},
        };
        return data;
    }

}
