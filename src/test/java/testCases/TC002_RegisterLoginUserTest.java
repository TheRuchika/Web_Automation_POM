package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Base.BaseTest;
import pages.LoginPage;
import pages.LoginSuccessPage;
import pages.RegisterSuccessPage;
import utils.Data;


public class TC002_RegisterLoginUserTest extends BaseTest {

    @Test(dependsOnMethods = "testCases.TC001_RegisterUserTest.TC001")
    public void TC002(){

        RegisterSuccessPage registerSuccessPage = new RegisterSuccessPage(driver);
        registerSuccessPage.clickSignIn();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername(Data.username);
        loginPage.setPassword(Data.password);
        loginPage.clickSubmit();

        LoginSuccessPage loginSuccessPage = new LoginSuccessPage(driver);
        loginSuccessPage.loginSuccess();

        Assert.assertTrue(loginSuccessPage.loginSuccess().contains("Login Successfully"),"Login error");
    }
}
