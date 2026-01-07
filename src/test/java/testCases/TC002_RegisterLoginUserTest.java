package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Base.BaseTest;
import pages.LoginSuccessPage;
import pages.RegisterSuccessPage;
import utils.Data;

/**
 * Test Case: TC002 – Login using registered user
 *
 * This test depends on TC001 (registration) and verifies that the user
 * can log in successfully using the stored credentials.
 */
public class TC002_RegisterLoginUserTest extends BaseTest {

    /**
     * Navigates to Sign-In from Register Success page,
     * logs in using stored credentials, and validates login success message.
     */
    @Test(dependsOnMethods = "testCases.TC001_RegisterUserTest.TC001_registerUser")
    public void TC002_loginWithRegisteredUser() {

        // Navigate to Login page via Sign-In link and perform login
        LoginSuccessPage loginSuccessPage =
                new RegisterSuccessPage(driver)
                        .clickSignIn()
                        .setUsername(Data.username)
                        .setPassword(Data.password)
                        .clickSubmit();

        // Validate login success message
        Assert.assertTrue(
                loginSuccessPage.getLoginSuccessMessage().contains("Login Successfully"),
                "Login failed: Success message not displayed"
        );
    }
}
