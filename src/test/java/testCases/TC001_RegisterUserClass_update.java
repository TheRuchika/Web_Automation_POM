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
 * Test Case: TC001 – User Registration
 *
 * This test verifies that a user can successfully register
 * using valid details and receives a confirmation message.
 */
public class TC001_RegisterUserClass_update extends pages.Base.BaseClass {

    private static final Logger logger = LogManager.getLogger(TC001_RegisterUserClass_update.class);

    /**
     * Registers a new user and validates the success message.
     * Stores the registered credentials for reuse in login test.
     */
    @Test
    public void TC001_registerUser() {

        ChainTestListener.log("Test execution started");
        logger.debug("debug TC001_1 Test");
        logger.info("*** Starting TC001_1 Test ***");
        logger.warn("Warn TC001_1 Test");
        logger.error("Error TC001_1 Test");
        logger.fatal("Fatal TC001_1 Test");

        // Test data (can be externalized later)
        String username = "TheRuchika";
        String password = "Ruchika123";

        HomePage homePage = new HomePage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        RegisterSuccessPage successPage = new RegisterSuccessPage(driver);
        
        homePage.clickRegisterMenu();
        ChainTestListener.embed(takeScreenshot(),"image/png");
        registerPage.setFirstName("Ruchika");
        registerPage.setLastName("Kaludewa");
        registerPage.setPhone("0719368140");
        registerPage.setEmail("ruchikapromodya@gmail.com");
        ChainTestListener.embed(takeScreenshot(),"image/png");
        registerPage.setUserName(username);
        registerPage.setPassword(password);
        registerPage.setConfirmPassword(password);
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
    }
}
