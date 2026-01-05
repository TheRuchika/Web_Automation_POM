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
        registerPage.setFirstName("Ruchika");
        registerPage.setLastName("Kaludewa");
        registerPage.setPhone("0719368140");
        registerPage.setEmail("ruchikapromodya@gmail.com");
        registerPage.setUserName(username);
        registerPage.setPassword(password);
        registerPage.setConfirmPassword(password);
        registerPage.clickSubmit();

        RegisterSuccessPage successPage = new RegisterSuccessPage(driver);
        Assert.assertTrue(successPage.registerSuccess().contains("Dear"));

        Data.username = username;
        Data.password = password;
    }
}
