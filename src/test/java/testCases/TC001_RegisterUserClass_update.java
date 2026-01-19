package testCases;

import com.aventstack.chaintest.plugins.ChainTestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;
import pages.RegisterSuccessPage;
import utils.Data;

/**
 * Test Case: TC001 – User Registration (with reporting + logging)
 *
 * This test:
 * - Registers a user using POM
 * - Captures screenshots at key steps for ChainTest report
 * - Logs execution details using Log4j
 */
public class TC001_RegisterUserClass_update extends pages.Base.BaseClass {

    private static final Logger logger = LogManager.getLogger(TC001_RegisterUserClass_update.class);

    /**
     * Registers a new user and validates the registration success message.
     * Stores the credentials for reuse in login test (TC002).
     */
    @Test
    public void TC001_registerUser() {

        // Report + log: test start
        ChainTestListener.log("TC001 started: User Registration");
        logger.info("=== Starting TC001: User Registration ===");
        ChainTestListener.log("Test execution started");
        logger.debug("debug TC001_1 Test");
        logger.info("*** Starting TC001_1 Test ***");
        logger.warn("Warn TC001_1 Test");
        logger.error("Error TC001_1 Test");
        logger.fatal("Fatal TC001_1 Test");
        // Report + log: test start
        ChainTestListener.log("TC001 started: User Registration");
        logger.info("=== Starting TC001: User Registration ===");

        // Test data (can be externalized later)
        String username = "TheRuchika";
        String password = "Ruchika123";

        // Navigate to Register page
        HomePage homePage = new HomePage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        RegisterSuccessPage successPage = new RegisterSuccessPage(driver);

        homePage.clickRegisterMenu();
        ChainTestListener.embed(takeScreenshot(),"image/png");
        homePage.clickRegisterMenu();

        // Screenshot: after navigation to Register page
        ChainTestListener.embed(takeScreenshot(), "image/png");

        // Fill registration form
        registerPage.setFirstName("Ruchika");
        registerPage.setLastName("Kaludewa");
        registerPage.setPhone("0719368140");
        registerPage.setEmail("ruchikapromodya@gmail.com");

        // Screenshot: after filling basic details
        ChainTestListener.embed(takeScreenshot(), "image/png");

        registerPage.setUserName(username);
        registerPage.setPassword(password);
        registerPage.setConfirmPassword(password);

        // Submit registration and land on Success page
        registerPage.clickSubmit();

        // Screenshot: after form submission
        ChainTestListener.embed(takeScreenshot(), "image/png");
        registerPage.clickSubmit();
        ChainTestListener.embed(takeScreenshot(),"image/png");

        // Validate registration success message
        Assert.assertTrue(
                successPage.getRegisterSuccessMessage().contains("Dear"),
                "Registration failed: Success message not displayed"
        );

        logger.info("*** Executed TC001_1 Test ***");

        // Store credentials for login test (TC002)
        Data.username = username;
        Data.password = password;

        // Report + log: test end
        logger.info("=== Completed TC001: User Registration ===");
        ChainTestListener.log("TC001 completed successfully");
    }
}
