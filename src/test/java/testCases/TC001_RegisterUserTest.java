package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Base.BaseTest;
import pages.HomePage;
import pages.RegisterSuccessPage;
import utils.Data;

/**
 * Test Case: TC001 – User Registration
 *
 * This test verifies that a user can successfully register
 * using valid details and receives a confirmation message.
 */
public class TC001_RegisterUserTest extends BaseTest {

    /**
     * Registers a new user and validates the success message.
     * Stores the registered credentials for reuse in login test.
     */
    @Test
    public void TC001_registerUser() {

        // Test data (can be externalized later)
        String username = "TheRuchika";
        String password = "Ruchika123";

        // Initialize Home Page
        HomePage homePage = new HomePage(driver);

        // Perform user registration using method chaining (POM)
        RegisterSuccessPage successPage =
                homePage.clickRegisterMenu()
                        .setFirstName("Ruchika")
                        .setLastName("Kaludewa")
                        .setPhone("0719368140")
                        .setEmail("ruchikapromodya@gmail.com")
                        .setUserName(username)
                        .setPassword(password)
                        .setConfirmPassword(password)
                        .clickSubmit();

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
