package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Base.BaseTest;
import pages.HomePage;
import pages.RegisterPage;
import pages.RegisterSuccessPage;
import utils.Data;

/**
 * Test Case: TC001 – User Registration
 *
 * This test verifies that a user can successfully register
 * using valid details and receives a confirmation message.
 */
public class TC001_RegisterUserTest_CrossBrowser extends BaseTest {

    /**
     * Registers a new user and validates the success message.
     * Stores the registered credentials for reuse in login test.
     */
    @Test
    public void TC001_registerUser() {

        // Test data (can be externalized later)
        String username = "TheRuchika";
        String password = "Ruchika123";

        HomePage homePage = new HomePage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        RegisterSuccessPage successPage = new RegisterSuccessPage(driver);
        
        homePage.clickRegisterMenu();
        registerPage.setFirstName("Ruchika");
        registerPage.setLastName("Kaludewa");
        registerPage.setPhone("0719368140");
        registerPage.setEmail("ruchikapromodya@gmail.com");
        registerPage.setUserName(username);
        registerPage.setPassword(password);
        registerPage.setConfirmPassword(password);
        registerPage.clickSubmit();

        // Validate registration success message
        Assert.assertTrue(
                successPage.getRegisterSuccessMessage().contains("Dear"),
                "Registration failed: Success message not displayed"
        );

        // Store credentials for login test (TC002)
        Data.username = username;
        Data.password = password;
    }
}
