package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Base.BaseTest;
import pages.HomePage;
import pages.RegisterPage;
import pages.RegisterSuccessPage;
import utils.Data;

public class TC001_RegisterUserTest extends BaseTest {

    @Test
    public void TC001() {

        String username = "TheRuchika";
        String password = "Ruchika123";

        HomePage homePage = new HomePage(driver);
        homePage.clickRegisterMenu();

        RegisterPage registerPage = new RegisterPage(driver);
        RegisterSuccessPage successPage = new RegisterSuccessPage(driver);

        registerPage.setFirstName("Ruchika")
                    .setLastName("Kaludewa")
                    .setPhone("0719368140")
                    .setEmail("ruchikapromodya@gmail.com")
                    .setUserName(username)
                    .setPassword(password)
                    .setConfirmPassword(password)
                    .clickSubmit();

        Assert.assertTrue(successPage.registerSuccess().contains("Dear"));

        Data.username = username;
        Data.password = password;
    }
}
