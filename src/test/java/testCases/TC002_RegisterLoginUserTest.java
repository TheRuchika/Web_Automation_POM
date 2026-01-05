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
        LoginSuccessPage loginSuccessPage = new LoginSuccessPage(driver);

        registerSuccessPage.clickSignIn();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername(Data.username)
                .setPassword(Data.password)
                .clickSubmit()

                .loginSuccess();

        Assert.assertTrue(loginSuccessPage.loginSuccess().contains("Login Successfully"),"Login error");
    }
}
