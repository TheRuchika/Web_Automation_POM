package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterSuccessPage;
import utils.Data;
import utils.PropertyFileReader;

/**
 * Test Case: TC001 – User Registration
 *
 * This test verifies that a user can successfully register
 * using valid details and receives a confirmation message.
 */
public class TC001_RegisterUserClass extends pages.Base.BaseClass {

    /**
     * Registers a new user and validates the registration success message.
     * Stores the credentials for reuse in the login test (TC002).
     */
    @Test
    public void TC001_registerUser() {

        // Read test data from properties (externalized test data)
        String username = PropertyFileReader.getInstance().getProperty("testData", "username");
        String password = PropertyFileReader.getInstance().getProperty("testData", "pass");

        // Initialize Home Page
        HomePage homePage = new HomePage(driver);

        // Perform user registration using POM method chaining
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
